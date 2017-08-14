/**
 * @Author Feng Bo
 * @Date 14 Aug 2017 1:41:57 pm
 */
package guru.springframework.Spring5RecipeApp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.Spring5RecipeApp.domain.Recipe;

/**
 * 
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
