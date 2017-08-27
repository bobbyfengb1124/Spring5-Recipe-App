/**
 * @Author Feng Bo
 * @Date 26 Aug 2017 5:55:34 pm
 */
package guru.springframework.Spring5RecipeApp.services;

import java.util.Set;

import guru.springframework.Spring5RecipeApp.commands.UnitOfMeasureCommand;

/**
 * 
 */
public interface UnitOfMeasureService {

	Set<UnitOfMeasureCommand> listAllUoms();

}
