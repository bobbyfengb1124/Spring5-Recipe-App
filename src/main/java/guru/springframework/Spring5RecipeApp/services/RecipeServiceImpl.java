/**
 * @Author Feng Bo
 * @Date 15 Aug 2017 4:25:54 pm
 */
package guru.springframework.Spring5RecipeApp.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guru.springframework.Spring5RecipeApp.commands.RecipeCommand;
import guru.springframework.Spring5RecipeApp.converters.RecipeCommandToRecipe;
import guru.springframework.Spring5RecipeApp.converters.RecipeToRecipeCommand;
import guru.springframework.Spring5RecipeApp.domain.Recipe;
import guru.springframework.Spring5RecipeApp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	private RecipeCommandToRecipe recipeCommandToRecipe;
	private RecipeToRecipeCommand recipeToRecipeCommand;

	/**
	 * @param recipeRepository
	 * @param recipeCommandToRecipe
	 * @param recipeToRecipeCommand
	 */
	public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe,
			RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * guru.springframework.Spring5RecipeApp.services.RecipeService#getRecipes()
	 */
	@Override
	public Set<Recipe> getRecipes() {
		log.debug("I am in the service");
		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}

	@Override
	public Recipe findById(long l) {
		Optional<Recipe> r = recipeRepository.findById(l);

		if (!r.isPresent()) {
			throw new RuntimeException("Recipe Not Found!");
		}
		return r.get();
	}

	@Override
	public RecipeCommand saveRecipeCommand(RecipeCommand command) {
		Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

		Recipe savedRecipe = recipeRepository.save(detachedRecipe);
		log.debug("Saved RecipeId:" + savedRecipe.getId());
		return recipeToRecipeCommand.convert(savedRecipe);
	}

	@Override
	@Transactional
	public RecipeCommand findCommandById(Long long1) {
		return recipeToRecipeCommand.convert(findById(long1));
	}

}
