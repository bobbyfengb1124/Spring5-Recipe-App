/**
 * @Author Feng Bo
 * @Date 22 Aug 2017 10:18:46 am
 */
package guru.springframework.Spring5RecipeApp.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.Spring5RecipeApp.commands.RecipeCommand;
import guru.springframework.Spring5RecipeApp.exceptions.NotFoundException;
import guru.springframework.Spring5RecipeApp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@Controller
public class RecipeController {
	private final RecipeService recipeService;
	private static final String RECIPE_RECIPEFORM_URL = "recipe/recipeform";

	/**
	 * @param recipeService
	 */
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping
	@RequestMapping({ "/recipe/{id}/show" })
	public String showRecipeById(@PathVariable String id, Model model) {

		model.addAttribute("recipe", recipeService.findById(new Long(id)));

		return "recipe/show";
	}

	@GetMapping
	@RequestMapping("recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());

		return "recipe/recipeform";

	}

	@GetMapping
	@RequestMapping({ "/recipe/{id}/update" })
	public String updateRecipe(@PathVariable String id, Model model) {

		model.addAttribute("recipe", recipeService.findCommandById(new Long(id)));

		return "recipe/recipeform";
	}

	@RequestMapping({ "/recipe/{id}/delete" })
	public String deleteAction(@PathVariable String id, Model model) {

		log.debug("Deleting id:" + id);
		recipeService.deleteById(Long.valueOf(id));

		return "redirect:/";
	}

	@PostMapping
	@RequestMapping("recipe")
	public String saveOrUpdate(@Valid @ModelAttribute RecipeCommand command, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(objectError -> {
				log.error(objectError.toString());
			});

			return RECIPE_RECIPEFORM_URL;
		}

		RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

		return "redirect:/recipe/" + savedCommand.getId() + "/show";
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ModelAndView handleNotFound(Exception exception) {

		log.error("Handling not found exception");
		log.error(exception.getMessage());

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("404error");
		modelAndView.addObject("exception", exception);
		return modelAndView;

	}

}
