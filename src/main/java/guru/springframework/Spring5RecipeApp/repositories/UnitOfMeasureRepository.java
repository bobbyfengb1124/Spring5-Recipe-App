/**
 * @Author Feng Bo
 * @Date 14 Aug 2017 1:44:40 pm
 */
package guru.springframework.Spring5RecipeApp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.Spring5RecipeApp.domain.UnitOfMeasure;

/**
 * 
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);
}
