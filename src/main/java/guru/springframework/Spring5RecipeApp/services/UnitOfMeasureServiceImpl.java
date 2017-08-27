/**
 * @Author Feng Bo
 * @Date 27 Aug 2017 3:32:17 pm
 */
package guru.springframework.Spring5RecipeApp.services;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import guru.springframework.Spring5RecipeApp.commands.UnitOfMeasureCommand;
import guru.springframework.Spring5RecipeApp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.Spring5RecipeApp.repositories.UnitOfMeasureRepository;

/**
 * 
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

	/**
	 * @param unitOfMeasureRepository
	 * @param unitOfMeasureToUnitOfMeasureCommand
	 */
	public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
			UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see guru.springframework.Spring5RecipeApp.services.UnitOfMeasureService#
	 * listAllUoms()
	 */
	@Override
	public Set<UnitOfMeasureCommand> listAllUoms() {
		return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(), false)
				.map(unitOfMeasureToUnitOfMeasureCommand::convert).collect(Collectors.toSet());
	}

}
