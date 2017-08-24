/**
 * @Author Feng Bo
 * @Date 23 Aug 2017 11:10:08 am
 */
package guru.springframework.Spring5RecipeApp.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import guru.springframework.Spring5RecipeApp.commands.IngredientCommand;
import guru.springframework.Spring5RecipeApp.commands.UnitOfMeasureCommand;
import guru.springframework.Spring5RecipeApp.domain.Ingredient;
import guru.springframework.Spring5RecipeApp.domain.Recipe;

/**
 * 
 */
public class IngredientCommandToIngredientTest {

	IngredientCommandToIngredient converter;
	private static final Recipe RECIPE = new Recipe();
	private static final BigDecimal AMOUNT = new BigDecimal("1");
	private static final Long ID_VALUE = new Long(1L);
	private static final String DESCRIPTION = "Cheeseburger";
	private static final Long UOM_ID = new Long(2L);

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
	}

	@Test
	public void testNullParameter() throws Exception {
		assertNull(converter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new IngredientCommand()));
	}

	@Test
	public void testConvert() throws Exception {
		// given
		IngredientCommand command = new IngredientCommand();
		command.setId(ID_VALUE);
		command.setAmount(AMOUNT);
		command.setDescription(DESCRIPTION);
		UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
		unitOfMeasureCommand.setId(UOM_ID);
		command.setUom(unitOfMeasureCommand);

		// when
		Ingredient ingredient = converter.convert(command);

		// then
		assertNotNull(ingredient);
		assertNotNull(ingredient.getUom());
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(DESCRIPTION, ingredient.getDescription());
		assertEquals(UOM_ID, ingredient.getUom().getId());
	}

}
