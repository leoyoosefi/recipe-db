package se.lexicon.recipedb.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class RecipeCategory {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(nullable = false)
    private String category;
@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "categories")
    Set<Recipe> recipe;

    public RecipeCategory() {
    }

    public RecipeCategory(String category, Set<Recipe> recipe) {
        this.category = category;
        this.recipe = recipe;
    }

    public RecipeCategory(int id, String category, Set<Recipe> recipe) {
        this.id = id;
        this.category = category;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipe = recipe;
    }

    public void addRecipe(Recipe recipe)
    {
        if(recipe == null) throw new IllegalArgumentException("recipe data is null");
        HashSet<Object> recipes = null;
        if(recipes == null) recipes = new HashSet<>();
        if(recipe.getCategories() == null) recipe.setCategories(new HashSet<>());

        if(!recipes.contains(recipe))
        {
            recipes.add(recipe);
        }
    }

    public void removeRecipe(Recipe recipe)
    {
        if(category == null) throw new IllegalArgumentException("recipe data is null");
        HashSet<Object> recipes = null;
        if(recipes == null) recipes = new HashSet<>();
        if(recipe.getCategories() == null) recipe.setCategories(new HashSet<>());

        if(!recipes.contains(recipe))
        {
            recipes.add(recipe);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return id == that.id && Objects.equals(category, that.category) && Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, recipe);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
