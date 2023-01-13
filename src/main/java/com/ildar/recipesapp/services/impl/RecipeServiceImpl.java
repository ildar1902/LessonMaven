package com.ildar.recipesapp.services.impl;

import com.ildar.recipesapp.model.Recipe;
import com.ildar.recipesapp.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final Map<Integer, Recipe> recipes = new TreeMap<>();
    private static int recipeId = 0;

    @Override
    public String add(Recipe recipe) {
        recipes.put(++recipeId, recipe);
        return "добавлен рецепт: \"" + recipe.getName() + "\", он будет храниться под номером " + recipeId;
    }

    @Override
    public Optional<Recipe> get(int id) {
        return Optional.ofNullable(recipes.get(id));
    }

    @Override
    public Optional<Recipe> edit(int id, Recipe recipe) {
        return Optional.ofNullable(recipes.replace(id, recipe));
    }

    @Override
    public Optional<Recipe> delete(int id) {
        return Optional.ofNullable(recipes.remove(id));
    }

    @Override
    public Map<Integer, Recipe> getAll() {
        return new TreeMap<>(recipes);
    }
}

