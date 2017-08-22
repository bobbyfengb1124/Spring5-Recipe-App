/**
 * @Author Feng Bo
 * @Date 15 Aug 2017 4:25:54 pm
 */
package guru.springframework.Spring5RecipeApp.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

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

	/**
	 * @param recipeRepository
	 */
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
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

}
