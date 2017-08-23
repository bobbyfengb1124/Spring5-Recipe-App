/**
 * @Author Feng Bo
 * @Date 23 Aug 2017 10:50:49 am
 */
package guru.springframework.Spring5RecipeApp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

	private Long id;

	private String recipeNotes;

}
