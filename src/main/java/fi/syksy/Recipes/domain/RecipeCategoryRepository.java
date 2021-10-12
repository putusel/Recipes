package fi.syksy.Recipes.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface RecipeCategoryRepository extends CrudRepository <Category, Long>  {
	List<Category> findByTitle(String title);

}
