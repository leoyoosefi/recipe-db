package se.lexicon.recipedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.recipedb.entity.Ingredient;
import se.lexicon.recipedb.repository.IngredientRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    IngredientRepository ingredientRepository;


@Autowired
    public MyCommandLineRunner(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Ingredient ingredient = new Ingredient("Rice");
        Ingredient insertedIngredient1 = ingredientRepository.save(ingredient);
        System.out.println(insertedIngredient1.getId());
        System.out.println(insertedIngredient1.getIngredientName());
    }
}
