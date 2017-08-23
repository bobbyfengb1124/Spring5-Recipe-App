/**
 * @Author Feng Bo
 * @Date 23 Aug 2017 11:43:26 am
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
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

	@Synchronized
	@Nullable
	@Override
	public Category convert(CategoryCommand source) {
		if (source == null) {
			return null;
		}

		final Category category = new Category();
		category.setId(source.getId());
		category.setDescription(source.getDescription());
		return category;
	}
}
