package com.ildar.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private CookingTime cookingTime;
    Set<Ingredient> ingredients;
    Set<String> steps;
}
