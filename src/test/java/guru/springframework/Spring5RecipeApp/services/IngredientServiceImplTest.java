/**
 * @Author Feng Bo
 * @Date 26 Aug 2017 10:48:21 am
 */
package guru.springframework.Spring5RecipeApp.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.Spring5RecipeApp.commands.IngredientCommand;
import guru.springframework.Spring5RecipeApp.converters.IngredientCommandToIngredient;
import guru.springframework.Spring5RecipeApp.converters.IngredientToIngredientCommand;
import guru.springframework.Spring5RecipeApp.converters.UnitOfMeasureCommandToUnitOfMeasure;
import guru.springframework.Spring5RecipeApp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.Spring5RecipeApp.domain.Ingredient;
import guru.springframework.Spring5RecipeApp.domain.Recipe;
import guru.springframework.Spring5RecipeApp.repositories.RecipeRepository;
import guru.springframework.Spring5RecipeApp.repositories.UnitOfMeasureRepository;

/**
 * 
 */
public class IngredientServiceImplTest {
	private final IngredientToIngredientCommand ingredientToIngredientCommand;

	@Mock
	RecipeRepository recipeRepository;

	IngredientService ingredientService;

	IngredientCommandToIngredient ingredientCommandToIngredient;

	@Mock
	UnitOfMeasureRepository unitOfMeasureRepository;

	// init converters
	public IngredientServiceImplTest() {
		this.ingredientToIngredientCommand = new IngredientToIngredientCommand(
				new UnitOfMeasureToUnitOfMeasureCommand());
		this.ingredientCommandToIngredient = new IngredientCommandToIngredient(
				new UnitOfMeasureCommandToUnitOfMeasure());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, ingredientCommandToIngredient,
				recipeRepository, unitOfMeasureRepository);
	}

	@Test
	public void testSaveRecipeCommand() throws Exception {
		// given
		IngredientCommand command = new IngredientCommand();
		command.setId(3L);
		command.setRecipeId(2L);

		Optional<Recipe> recipeOptional = Optional.of(new Recipe());
		Recipe savedRecipe = new Recipe();
		savedRecipe.addIngredient(new Ingredient());
		savedRecipe.getIngredients().iterator().next().setId(3L);

		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

		when(recipeRepository.save(any())).thenReturn(savedRecipe);

		// when
		IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

		// then
		assertEquals(Long.valueOf(3L), savedCommand.getId());
		verify(recipeRepository, times(1)).findById(anyLong());
		verify(recipeRepository, times(1)).save(any(Recipe.class));
	}

	@Test
	public void testFindByRecipeIdAndIngredientId() throws Exception {
	}

	@Test
	public void findByRecipeIdAndIngredientIdHappyPath() throws Exception {
		// given
		Recipe recipe = new Recipe();
		recipe.setId(1L);

		Ingredient ingredient1 = new Ingredient();
		ingredient1.setId(1L);

		Ingredient ingredient2 = new Ingredient();
		ingredient2.setId(1L);

		Ingredient ingredient3 = new Ingredient();
		ingredient3.setId(3L);

		recipe.addIngredient(ingredient1);
		recipe.addIngredient(ingredient2);
		recipe.addIngredient(ingredient3);
		Optional<Recipe> recipeOptional = Optional.of(recipe);

		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

		// then
		IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

		// when
		assertEquals(Long.valueOf(3L), ingredientCommand.getId());
		assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
		verify(recipeRepository, times(1)).findById(anyLong());
	}
}