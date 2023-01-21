package com.ildar.recipesapp.services;

import com.ildar.recipesapp.model.Recipe;

import java.util.Map;
import java.util.Optional;


public interface RecipeService {
    String getFilePath();

    String add(Recipe recipe);

    Optional<Recipe> get(int number);

    Optional<Recipe> edit(int id, Recipe recipe);

    Optional<Recipe> delete(int id);

    Map<Integer, Recipe> getAll();

    byte[] downloadFile();
}
