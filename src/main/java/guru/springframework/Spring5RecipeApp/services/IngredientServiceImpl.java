/**
 * @Author Feng Bo
 * @Date 26 Aug 2017 10:16:57 am
 */
package guru.springframework.Spring5RecipeApp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import guru.springframework.Spring5RecipeApp.commands.IngredientCommand;
import guru.springframework.Spring5RecipeApp.converters.IngredientCommandToIngredient;
import guru.springframework.Spring5RecipeApp.converters.IngredientToIngredientCommand;
import guru.springframework.Spring5RecipeApp.domain.Ingredient;
import guru.springframework.Spring5RecipeApp.domain.Recipe;
import guru.springframework.Spring5RecipeApp.repositories.RecipeRepository;
import guru.springframework.Spring5RecipeApp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {
	private final IngredientToIngredientCommand ingredientToIngredientCommand;
	private final IngredientCommandToIngredient ingredientCommandToIngredient;

	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;

	/**
	 * @param ingredientToIngredientCommand
	 * @param ingredientCommandToIngredient
	 * @param recipeRepository
	 * @param unitOfMeasureRepository
	 */
	public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand,
			IngredientCommandToIngredient ingredientCommandToIngredient, RecipeRepository recipeRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		this.ingredientToIngredientCommand = ingredientToIngredientCommand;
		this.ingredientCommandToIngredient = ingredientCommandToIngredient;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
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

	@Override
	public IngredientCommand saveIngredientCommand(IngredientCommand command) {

		Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());
		if (!recipeOptional.isPresent()) {
			// todo toss error if not found!
			log.error("Recipe not found for id: " + command.getRecipeId());
			return new IngredientCommand();
		} else {
			Recipe recipe = recipeOptional.get();
			Optional<Ingredient> ingredientOptional = recipe.getIngredients().stream()
					.filter(ingredient -> ingredient.getId().equals(command.getId())).findFirst();
			if (ingredientOptional.isPresent()) {
				Ingredient ingredientFound = ingredientOptional.get();
				ingredientFound.setAmount(command.getAmount());
				ingredientFound.setDescription(command.getDescription());
				ingredientFound.setUom(unitOfMeasureRepository.findById(command.getUom().getId())
						.orElseThrow(() -> new RuntimeException("UOM NOT FOUND")));
			} else {
				// add new Ingredient
				recipe.addIngredient(ingredientCommandToIngredient.convert(command));
			}
			Recipe savedRecipe = recipeRepository.save(recipe);

			// to do to check result
			return ingredientToIngredientCommand.convert(savedRecipe.getIngredients().stream()
					.filter(recipeIngredients -> recipeIngredients.getId().equals(command.getId())).findFirst().get());
		}

	}

}
