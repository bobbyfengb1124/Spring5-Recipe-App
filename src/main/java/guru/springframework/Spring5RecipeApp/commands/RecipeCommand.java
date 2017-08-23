/**
 * @Author Feng Bo
 * @Date 23 Aug 2017 10:47:37 am
 */
package guru.springframework.Spring5RecipeApp.commands;

import java.util.HashSet;
import java.util.Set;

import guru.springframework.Spring5RecipeApp.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

	private Long id;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	private String directions;
	private Set<IngredientCommand> ingredients = new HashSet<>();
	private Difficulty difficulty;
	private NotesCommand notes = new NotesCommand();
	private Set<CategoryCommand> categories = new HashSet<>();

}
