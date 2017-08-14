/**
 * @Author Feng Bo
 * @Date 14 Aug 2017 1:43:40 pm
 */
package guru.springframework.Spring5RecipeApp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.Spring5RecipeApp.domain.Category;

/**
 * 
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
