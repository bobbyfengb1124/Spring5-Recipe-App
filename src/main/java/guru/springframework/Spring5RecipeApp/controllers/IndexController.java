/**
 * @Author Feng Bo
 * @Date 11 Aug 2017 11:07:00 am
 */
package guru.springframework.Spring5RecipeApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.Spring5RecipeApp.services.RecipeService;

/**
 * 
 */
@Controller
public class IndexController {

	private final RecipeService recipeService;

	/**
	 * @param recipeService
	 */
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	// private CategoryRepository categoryRepository;
	// private UnitOfMeasureRepository unitOfMeasureRepository;
	//
	// /**
	// * @param categoryRepository
	// * @param unitOfMeasure
	// */
	// public IndexController(CategoryRepository categoryRepository,
	// UnitOfMeasureRepository unitOfMeasureRepository) {
	// this.categoryRepository = categoryRepository;
	// this.unitOfMeasureRepository = unitOfMeasureRepository;
	// }

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {

		// Optional<Category> categoryOptional =
		// categoryRepository.findByDescription("American");
		// Optional<UnitOfMeasure> unitOfMeasureOptional =
		// unitOfMeasureRepository.findByDescription("Teaspoon");
		//
		// System.out.println("Cat Id is:" + categoryOptional.get().getId());
		// System.out.println("UOM Id is:" +
		// unitOfMeasureOptional.get().getId());

		model.addAttribute("recipes", recipeService.getRecipes());

		return "index";
	}
}
