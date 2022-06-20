package se.lexicon.recipedb.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.recipedb.entity.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {



}
