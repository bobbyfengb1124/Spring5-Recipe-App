/**
 * @Author Feng Bo
 * @Date 23 Aug 2017 2:31:12 pm
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
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

	@Synchronized
	@Nullable
	@Override
	public NotesCommand convert(Notes source) {
		if (source == null) {
			return null;
		}

		final NotesCommand notesCommand = new NotesCommand();
		notesCommand.setId(source.getId());
		notesCommand.setRecipeNotes(source.getRecipeNotes());
		return notesCommand;
	}
}