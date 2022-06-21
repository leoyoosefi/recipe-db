package se.lexicon.recipedb.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.recipedb.entity.RecipeCategory;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
}
