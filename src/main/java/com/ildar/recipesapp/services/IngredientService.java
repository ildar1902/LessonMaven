package com.ildar.recipesapp.services;

import com.ildar.recipesapp.model.Ingredient;

import java.util.Map;
import java.util.Optional;


public interface IngredientService {
    Ingredient add(Ingredient ingredient);

    Optional<Ingredient> get(int id);

    Optional<Ingredient> edit(int id, Ingredient ingredient);

    Optional<Ingredient> delete(int id);

    Map<Integer, Ingredient> getAll();
}
