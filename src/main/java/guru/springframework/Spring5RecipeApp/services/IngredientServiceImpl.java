/**
 * @Author Feng Bo
 * @Date 26 Aug 2017 10:16:57 am
 */
package guru.springframework.Spring5RecipeApp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import guru.springframework.Spring5RecipeApp.commands.IngredientCommand;
import guru.springframework.Spring5RecipeApp.converters.IngredientToIngredientCommand;
import guru.springframework.Spring5RecipeApp.domain.Recipe;
import guru.springframework.Spring5RecipeApp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {
	private final IngredientToIngredientCommand ingredientToIngredientCommand;

	private final RecipeRepository recipeRepository;

	/**
	 * @param ingredientToIngredientCommand
	 * @param recipeRepository
	 */
	public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand,
			RecipeRepository recipeRepository) {
		this.ingredientToIngredientCommand = ingredientToIngredientCommand;
		this.recipeRepository = recipeRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see guru.springframework.Spring5RecipeApp.services.IngredientService#
	 * findByRecipeIdAndId(java.lang.Long, java.lang.Long)
	 */
	@Override
	public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

		Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
		if (!recipeOptional.isPresent()) {
			log.error("recipe id not found. Id:" + recipeId);
		}
		Recipe recipe = recipeOptional.get();
		Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
				.filter(ingredient -> ingredient.getId().equals(ingredientId))
				.map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

		if (!ingredientCommandOptional.isPresent()) {
			log.error("Ingredient Id Not Found. Id:" + ingredientId);
		}

		return ingredientCommandOptional.get();
	}

}
