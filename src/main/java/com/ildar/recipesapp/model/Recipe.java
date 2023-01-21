package com.ildar.recipesapp.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.LinkedHashSet;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private String name;
    private CookingTime cookingTime;
    private LinkedHashSet<Ingredient> ingredients;
    private LinkedHashSet<String> steps;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    ").append(name)
                .append(":\n")
                .append("\n")
                .append("   Время приготовления: ").append(cookingTime)
                .append("\n")
                .append("\n")
                .append("   Ингредиенты:").append("\n");
        for (Ingredient ingredient : ingredients) {
            sb.append(" • ").append(ingredient).append("\n");
        }
        sb.append("\n");
        sb.append("    Инструкция приготовления: ").append("\n");
        int counter = 1;
        for (String step : steps) {
            sb.append(" ").append(counter++).append(". ").append(step).append("\n");
        }
        return sb.toString();
    }
}
