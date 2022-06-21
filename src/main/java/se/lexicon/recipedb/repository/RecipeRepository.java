package se.lexicon.recipedb.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.recipedb.entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
