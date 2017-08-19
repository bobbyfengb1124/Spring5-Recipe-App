/**
 * @Author Feng Bo
 * @Date 19 Aug 2017 11:33:39 am
 */
package guru.springframework.Spring5RecipeApp.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import guru.springframework.Spring5RecipeApp.services.RecipeService;

/**
 * 
 */
public class IndexControllerTest {

	IndexController indexController;

	@Mock
	RecipeService recipeService;

	@Mock
	private Model model;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		indexController = new IndexController(recipeService);
	}

	@Test
	public void test() {

		assertEquals(indexController.getIndexPage(model), "index");
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute("recipes", recipeService.getRecipes());
	}

}
