package com.ildar.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Recipe {
    private String name;
    private Long cookingTime;
    Set<Ingredient> ingredients;
    Set<String> cookingSteps;
}
