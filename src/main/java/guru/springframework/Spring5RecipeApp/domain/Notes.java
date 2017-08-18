/**
 * @Author Feng Bo
 * @Date 13 Aug 2017 11:09:04 am
 */
package guru.springframework.Spring5RecipeApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * 
 */
@Entity
@Data
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Recipe recipe;

	@Lob
	private String recipeNotes;

}
