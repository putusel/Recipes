package fi.syksy.Recipes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.syksy.Recipes.domain.Recipe;
import fi.syksy.Recipes.domain.RecipeRepository;

public class RestRecipeController {
	
	@Autowired
	private RecipeRepository rrepository;
	
	//RESTful service to get all recipes
	@RequestMapping(value="/recipes", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> recipeListRest() {
		return (List<Recipe> rrepository.findAll());
	}
	//RESTful service to get book by id
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public @ResponseBoduý Optional<Recipe> findRecipeRest(@PathVariable("id") Long recipeId) {
		return rrepository.findById(recipeId);
	}

}
