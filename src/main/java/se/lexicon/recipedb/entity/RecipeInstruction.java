package se.lexicon.recipedb.entity;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class RecipeInstruction {
@Id
    private String id;

    private String instructions;

    public RecipeInstruction() {
    }

    public RecipeInstruction(String id, String instructions) {
        this(instructions);
        this.id = id;

    }

    public RecipeInstruction(String instructions) {
        setInstructions(instructions);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(id, that.id) && Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instructions);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "id='" + id + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
