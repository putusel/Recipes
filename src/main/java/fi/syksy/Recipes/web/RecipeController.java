package fi.syksy.Recipes.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class RecipeController {
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
    @ResponseBody
    public String recipeExample() {
        return "XXXX";
     
    }

}
