/**
 * @Author Feng Bo
 * @Date 13 Aug 2017 11:37:27 am
 */
package guru.springframework.Spring5RecipeApp.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 */
@Data
@EqualsAndHashCode(exclude = { "recipe" })
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private BigDecimal amount;

	@ManyToOne
	private Recipe recipe;

	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;

	public Ingredient() {
	}

	public Ingredient(String description, BigDecimal amount, UnitOfMeasure eachUom) {
		this.description = description;
		this.amount = amount;
		this.uom = eachUom;
	}

	public Ingredient(String description2, BigDecimal amount2, UnitOfMeasure eachUom, Recipe guaca) {
		this.description = description2;
		this.amount = amount2;
		this.recipe = guaca;
		this.uom = eachUom;
	}

}
