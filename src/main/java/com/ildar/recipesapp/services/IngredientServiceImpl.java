package com.ildar.recipesapp.services;

import com.ildar.recipesapp.model.Ingredient;

import java.util.Map;
import java.util.TreeMap;

public class IngredientServiceImpl implements IngredientService {
    private static Map<Integer, Ingredient> ingredients = new TreeMap<>();
    private static int ingredientNumber = 0;
    @Override
    public void addIngredient (Ingredient ingredient) {
        ingredients.put(ingredientNumber++, ingredient);
    }

    @Override
    public Ingredient getIngredient(int ingredientNumber) {
        return ingredients.get(ingredientNumber);
    }
}
