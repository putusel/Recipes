package fi.syksy.Recipes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.syksy.Recipes.domain.Category;
import fi.syksy.Recipes.domain.Recipe;
import fi.syksy.Recipes.domain.RecipeCategoryRepository;
import fi.syksy.Recipes.domain.RecipeRepository;

@SpringBootApplication
public class RecipesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesApplication.class, args);
	}
	@Bean
	//adding demo data
	public CommandLineRunner recipeDemoData (RecipeRepository repository, RecipeCategoryRepository crepository) {
		
		
		return (args) -> {
			crepository.save(new Category("Meat"));
			crepository.save(new Category("Veggie"));
			crepository.save(new Category("Fish"));
			crepository.save(new Category("Salad"));
			
			repository.save(new Recipe ("Pasta bolognese", "Minced beef", 30, crepository.findByTitle("Meat").get(0)));
			repository.save(new Recipe ("Greek salad", "Feta cheese", 15, crepository.findByTitle("Salad").get(0)));
		};
		
	}
}

