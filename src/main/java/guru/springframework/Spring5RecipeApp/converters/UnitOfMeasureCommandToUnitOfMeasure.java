/**
 * @Author Feng Bo
 * @Date 23 Aug 2017 10:53:08 am
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
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasure convert(UnitOfMeasureCommand arg0) {
		if (arg0 == null) {
			return null;
		}
		UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(arg0.getId());
		uom.setDescription(arg0.getDescription());
		return uom;
	}

}
