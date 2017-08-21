/**
 * @Author Feng Bo
 * @Date 19 Aug 2017 10:59:53 am
 */
package guru.springframework.Spring5RecipeApp.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class CategoryTest {

	Category category;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		category = new Category();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link guru.springframework.Spring5RecipeApp.domain.Category#getId()}.
	 */
	@Test
	public void testGetId() {
		Long idValue = 4L;

		category.setId(idValue);

		assertEquals(idValue, category.getId());
	}

	// /**
	// * Test method for
	// * {@link
	// guru.springframework.Spring5RecipeApp.domain.Category#getDescription()}
	// * .
	// */
	// @Test
	// public void testGetDescription() {
	// fail("Not yet implemented");
	// }
	//
	// /**
	// * Test method for
	// * {@link
	// guru.springframework.Spring5RecipeApp.domain.Category#getRecipes()}
	// * .
	// */
	// @Test
	// public void testGetRecipes() {
	// fail("Not yet implemented");
	// }

}
