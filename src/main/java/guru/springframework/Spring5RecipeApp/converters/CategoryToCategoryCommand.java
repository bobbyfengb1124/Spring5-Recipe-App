/**
 * @Author Feng Bo
 * @Date 23 Aug 2017 11:48:13 am
 */
package guru.springframework.Spring5RecipeApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.Spring5RecipeApp.commands.CategoryCommand;
import guru.springframework.Spring5RecipeApp.domain.Category;
import lombok.Synchronized;

/**
 * 
 */
@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

	@Synchronized
	@Nullable
	@Override
	public CategoryCommand convert(Category source) {
		if (source == null) {
			return null;
		}

		final CategoryCommand categoryCommand = new CategoryCommand();

		categoryCommand.setId(source.getId());
		categoryCommand.setDescription(source.getDescription());

		return categoryCommand;
	}
}
