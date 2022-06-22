package se.lexicon.recipedb.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Recipe {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(nullable = false)
    private String recipeName;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "recipe",
            orphanRemoval = true
    )
    List<RecipeIngredient> recipeIngredients;
    @OneToOne
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "recipe_category"
            ,joinColumns = {@JoinColumn(name = "recipe_id", referencedColumnName = "id")}
            ,inverseJoinColumns = {@JoinColumn(name = "recipe_category_id", referencedColumnName = "id")})
    Set<RecipeCategory> categories;

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
    }

    public Recipe(int id, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, Set<RecipeCategory> categories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<RecipeCategory> categories) {
        this.categories = categories;
    }


    public void addRecipeIngredient(RecipeIngredient recipeIngredient)
    {
        if(recipeIngredient == null) throw new IllegalArgumentException("recipeIngredient data is null");
        if(recipeIngredients == null) recipeIngredients = new ArrayList<>();
        if(recipeIngredient.getRecipe() == null) recipeIngredient.setRecipe(new Recipe());

        if(!recipeIngredients.contains(recipeIngredient) && recipeIngredient.getRecipe() != this)
        {
            recipeIngredients.add(recipeIngredient);
            recipeIngredient.setRecipe(this);
        }
    }

    public void removeRecipeIngredient(RecipeIngredient recipeIngredient)
    {
        if(recipeIngredient == null) throw new IllegalArgumentException("recipeIngredient data is null");
        if(recipeIngredients == null) recipeIngredients = new ArrayList<>();
        if(recipeIngredient.getRecipe() == null) recipeIngredient.setRecipe(new Recipe());

        if(recipeIngredients.contains(recipeIngredient) && recipeIngredient.getRecipe() == this)
        {
            recipeIngredient.setRecipe(null);
            recipeIngredients.add(recipeIngredient);
        }
    }

    public void addCategory(RecipeCategory category)
    {
        if(category == null) throw new IllegalArgumentException("category data is null");
        if(categories == null) categories = new HashSet<>();
        if(category.getRecipe() == null) category.setRecipe(new HashSet<>());

        if(!categories.contains(category))
        {
            categories.add(category);
        }
    }

    public void removeCategory(RecipeCategory category)
    {
        if(category == null) throw new IllegalArgumentException("category data is null");
        if(categories == null) categories = new HashSet<>();
        if(category.getRecipe() == null) category.setRecipe(new HashSet<>());

        if(!categories.contains(category))
        {
            categories.add(category);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && Objects.equals(recipeName, recipe.recipeName) && Objects.equals(recipeIngredients, recipe.recipeIngredients) && Objects.equals(instruction, recipe.instruction) && Objects.equals(categories, recipe.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeName, recipeIngredients, instruction, categories);
    }


}
