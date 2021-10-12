package fi.syksy.Recipes.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long categoryid;
	private String title;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="category")
	private List<Recipe> recipes;

	public Category() {
		
	}

	public Category(String title) {
		super();
		this.title = title;
	}

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", title=" + title + "]";
	}
	
	
	
		
	

}
