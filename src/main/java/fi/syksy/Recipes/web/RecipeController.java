package fi.syksy.Recipes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.syksy.Recipes.domain.Recipe;
import fi.syksy.Recipes.domain.RecipeCategoryRepository;
import fi.syksy.Recipes.domain.RecipeRepository;

public class RecipeController {
	
	@Autowired
	private RecipeRepository rrepository;
	
	@Autowired
	private RecipeCategoryRepository crepository;
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
    @ResponseBody
    public String recipeExample() {
        return "XXXX";
     
    }
	@RequestMapping(value= "/recipelist", method = RequestMethod.GET)
    public String recipelist(Model model) {
		model.addAttribute("recipes", rrepository.findAll());
        return "recipelist";
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	//@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteRecipe(@PathVariable("id") Long recipeId, Model model) {
		rrepository.deleteById(recipeId);
		return "redirect:../recipelist";
	}
	@RequestMapping(value = "/edit/{id}")
	public String addRecipe (@PathVariable("id") Long recipeId, Model model) {
		model.addAttribute("recipe", rrepository.findById(recipeId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	@PostMapping("saveRecipe")
	public String saveRecipe(Recipe recipe, Model model) {
		rrepository.save(recipe);
		return "redirect:/recipelist";
	}
}
