package se.lexicon.recipedb.entity;

import java.util.List;
import java.util.Set;

public class Recipe {

    private int id;
    private String recipeName;
    List<RecipeIngredient> recipeIngredients;
    private RecipeInstruction instruction;
    Set<RecipeCategory> categories;

}
