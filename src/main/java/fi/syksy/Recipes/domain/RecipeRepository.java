package fi.syksy.Recipes.domain;

import java.awt.print.Book;

import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Book, Long> {

	void save(Recipe recipe);
	


}
