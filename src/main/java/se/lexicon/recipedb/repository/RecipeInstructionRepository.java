package se.lexicon.recipedb.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.recipedb.entity.RecipeInstruction;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
}
