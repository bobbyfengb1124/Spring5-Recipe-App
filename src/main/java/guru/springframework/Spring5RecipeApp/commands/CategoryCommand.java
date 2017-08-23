/**
 * @Author Feng Bo
 * @Date 23 Aug 2017 10:45:28 am
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
public class CategoryCommand {
	private Long id;
	private String description;
}
