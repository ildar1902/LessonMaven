package com.ildar.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Recipe {
    private String name;
    private CookingTime cookingTime;
    Set<Ingredient> ingredients;
    Set<String> steps;
}
