package com.ildar.recipesapp.services;

import com.ildar.recipesapp.model.Ingredient;
import org.springframework.stereotype.Service;

@Service

public interface IngredientService {
    void addIngredient(Ingredient ingredient);

    Ingredient getIngredient(int number);
}
