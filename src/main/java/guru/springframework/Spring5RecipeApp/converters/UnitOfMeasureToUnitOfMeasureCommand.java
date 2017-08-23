/**
 * @Author Feng Bo
 * @Date 23 Aug 2017 11:49:51 am
 */
package guru.springframework.Spring5RecipeApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.Spring5RecipeApp.commands.UnitOfMeasureCommand;
import guru.springframework.Spring5RecipeApp.domain.UnitOfMeasure;
import lombok.Synchronized;

/**
 * 
 */
@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasureCommand convert(UnitOfMeasure arg0) {
		if (arg0 == null) {
			return null;
		}
		UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
		uomCommand.setId(arg0.getId());
		uomCommand.setDescription(arg0.getDescription());
		return uomCommand;
	}

}
