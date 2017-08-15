/**
 * @Author Feng Bo
 * @Date 15 Aug 2017 4:24:59 pm
 */
package guru.springframework.Spring5RecipeApp.services;

import java.util.Set;

import guru.springframework.Spring5RecipeApp.domain.Recipe;

/**
 * 
 */
public interface RecipeService {

	Set<Recipe> getRecipes();
}
