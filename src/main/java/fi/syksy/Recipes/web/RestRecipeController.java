package fi.syksy.Recipes.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.syksy.Recipes.domain.Recipe;
import fi.syksy.Recipes.domain.RecipeRepository;

@Controller
public class RestRecipeController {
	
	@Autowired
	private RecipeRepository rrepository;
	
	//RESTful service to get all recipes
	@RequestMapping(value="/recipes", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> recipeListRest() {
		return (List<Recipe>) rrepository.findAll();
	}
	//RESTful service to get book by id
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Recipe> RestRecipeController(@PathVariable("id") Long recipeId) {
		return rrepository.findById(recipeId);
	}

}
