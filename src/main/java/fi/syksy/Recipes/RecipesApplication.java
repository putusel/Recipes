package fi.syksy.Recipes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.syksy.Recipes.domain.Category;
import fi.syksy.Recipes.domain.Recipe;
import fi.syksy.Recipes.domain.RecipeCategoryRepository;
import fi.syksy.Recipes.domain.RecipeRepository;
import fi.syksy.Recipes.domain.User;
import fi.syksy.Recipes.domain.UserRepository;

@SpringBootApplication
public class RecipesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesApplication.class, args);
	}
	@Bean
	//adding demo data
	public CommandLineRunner recipeDemoData (RecipeRepository repository, RecipeCategoryRepository crepository, UserRepository urepository) {
		
		
		return (args) -> {
			crepository.save(new Category("Meat"));
			crepository.save(new Category("Veggie"));
			crepository.save(new Category("Fish"));
			crepository.save(new Category("Salad"));
			
			repository.save(new Recipe ("Pasta bolognese", "Minced beef", 30, crepository.findByTitle("Meat").get(0)));
			repository.save(new Recipe ("Greek salad", "Feta cheese", 15, crepository.findByTitle("Salad").get(0)));
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$10$u4Ikwq4tGjpQl44AuPGebuZb8hgE.KIcMrKe9XrHoZHWpACrcA/Ga", "USER");
			User user2 = new User("admin", "$2a$10$KhgYIu9Np/KqyLI4/uZdIO63ywg035DlwQL9OjVpuayklSExojk4S", "ADMIN");
						
			urepository.save(user1);
			urepository.save(user2);
		};
		
	}
}

