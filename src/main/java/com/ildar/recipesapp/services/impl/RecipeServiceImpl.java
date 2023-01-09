package com.ildar.recipesapp.services.impl;

import com.ildar.recipesapp.model.Recipe;
import com.ildar.recipesapp.services.RecipeService;

import java.util.Map;
import java.util.TreeMap;

public class RecipeServiceImpl implements RecipeService {
   private static Map<Integer, Recipe> recipes = new TreeMap<>();
    private static int recipeNumber = 0;
    @Override
    public void addRecipe(Recipe recipe) {
        recipes.put(recipeNumber++, recipe);
    }

    @Override
    public Recipe getRecipe(int recipeNumber) {
        return recipes.get(recipeNumber);
            }
}
