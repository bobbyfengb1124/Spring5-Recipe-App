/**
 * @Author Feng Bo
 * @Date 14 Aug 2017 1:17:53 pm
 */
package guru.springframework.Spring5RecipeApp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * 
 */
@Entity
@Data
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@ManyToMany(mappedBy = "categories")
	private Set<Recipe> recipes;
}
