/**
 * @Author Feng Bo
 * @Date 27 Aug 2017 4:07:49 pm
 */
package guru.springframework.Spring5RecipeApp.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.Spring5RecipeApp.commands.UnitOfMeasureCommand;
import guru.springframework.Spring5RecipeApp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.Spring5RecipeApp.domain.UnitOfMeasure;
import guru.springframework.Spring5RecipeApp.repositories.UnitOfMeasureRepository;

/**
 * 
 */
public class UnitOfMeasureServiceImplTest {

	UnitOfMeasureService service;
	@Mock
	UnitOfMeasureRepository unitOfMeasureRepository;
	UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		service = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
	}

	@Test
	public void testListAllUoms() {
		// given
		Set<UnitOfMeasure> unitOfMeasures = new HashSet<UnitOfMeasure>();
		UnitOfMeasure uom1 = new UnitOfMeasure();
		uom1.setId(1L);
		unitOfMeasures.add(uom1);

		UnitOfMeasure uom2 = new UnitOfMeasure();
		uom2.setId(2L);
		unitOfMeasures.add(uom2);

		when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

		// when
		Set<UnitOfMeasureCommand> commands = service.listAllUoms();

		// then
		assertEquals(2, commands.size());
		verify(unitOfMeasureRepository, times(1)).findAll();
	}

}
