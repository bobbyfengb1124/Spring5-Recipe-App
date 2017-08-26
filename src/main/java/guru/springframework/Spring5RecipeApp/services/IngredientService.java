/**
 * @Author Feng Bo
 * @Date 26 Aug 2017 10:14:40 am
 */
package guru.springframework.Spring5RecipeApp.services;

import guru.springframework.Spring5RecipeApp.commands.IngredientCommand;

/**
 * 
 */
public interface IngredientService {

	IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

}
