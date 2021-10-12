package fi.syksy.Recipes.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.syksy.Recipes.domain.Recipe;
import fi.syksy.Recipes.domain.RecipeCategoryRepository;
import fi.syksy.Recipes.domain.RecipeRepository;


@Controller
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
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("recipe", new Recipe());
    	model.addAttribute("categories", crepository.findAll());
        return "addrecipe";
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteRecipe(@PathVariable("id") Long recipeId, Model model) {
		rrepository.deleteById(recipeId);
		return "redirect:../recipelist";
	}
	//@RequestMapping(value = "/edit/{id}")
	//public String addRecipe (@PathVariable("id") Long recipeId, Model model) {
		//model.addAttribute("recipe", rrepository.findById(recipeId));
		//model.addAttribute("categories", crepository.findAll());
		//return "editbook";
	//}
	//studentlistsignup demo
	@PostMapping("saveRecipe")
	public String saveRecipe(@Valid @ModelAttribute ("recipe") Recipe recipe, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			if (bindingResult.getFieldError().getField().equalsIgnoreCase("cookingTime")) {
				bindingResult.rejectValue("cookingTime", "err.cookingTime", "Check cookingTime format");
			} else {
				System.out.println("Other error");
			}
		}
		rrepository.save(recipe);
		return "redirect:/recipelist";
	}
}
