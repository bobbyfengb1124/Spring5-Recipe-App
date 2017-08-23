/**
 * @Author Feng Bo
 * @Date 23 Aug 2017 11:44:19 am
 */
package guru.springframework.Spring5RecipeApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.Spring5RecipeApp.commands.NotesCommand;
import guru.springframework.Spring5RecipeApp.domain.Notes;
import lombok.Synchronized;

/**
 * 
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

	@Synchronized
	@Nullable
	@Override
	public Notes convert(NotesCommand source) {
		if (source == null) {
			return null;
		}

		final Notes notes = new Notes();
		notes.setId(source.getId());
		notes.setRecipeNotes(source.getRecipeNotes());
		return notes;
	}
}