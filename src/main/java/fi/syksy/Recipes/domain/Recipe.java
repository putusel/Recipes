package fi.syksy.Recipes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Recipe {
	//unique id
	@Id
	//automatically generated
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private long id;
	@NotEmpty
	private String title;
	@NotEmpty
	private String mainIngredient;
	@NotEmpty
	@Min(1)
	private int cookingTime;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	@JsonManagedReference
	private Category category;
		
	public Recipe() {
			
	}
	
	public Recipe(String title, String mainIngredient, int cookingTime) {
		super();
		this.title = title;
		this.mainIngredient = mainIngredient;
		this.cookingTime = cookingTime;
	}

	public Recipe(String title, String mainIngredient, int cookingTime, Category category) {
		super();
		this.title = title;
		this.mainIngredient = mainIngredient;
		this.cookingTime = cookingTime;
		this.category = category;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMainIngredient() {
		return mainIngredient;
	}
	public void setMainIngredient(String mainIngredient) {
		this.mainIngredient = mainIngredient;
	}
	public int getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}



	@Override
	public String toString() {
		if (this.category != null)
			return "Recipe [id=" + id + ", title=" + title + ", mainIngredient=" + mainIngredient + ", cookingTime="
				+ cookingTime + ", category=" + this.getCategory() + "]";
		else 
			return "Recipe [id=" + id + ", title=" + title +", mainIngredient=" + mainIngredient + ", cookingTime="
					+ cookingTime + "]";
	}
	

}
