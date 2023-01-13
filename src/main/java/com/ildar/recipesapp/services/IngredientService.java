package com.ildar.recipesapp.services;

import com.ildar.recipesapp.model.Ingredient;

import java.util.Optional;


public interface IngredientService {
    Ingredient add(Ingredient ingredient);

    Optional<Ingredient> get(int id);
}
