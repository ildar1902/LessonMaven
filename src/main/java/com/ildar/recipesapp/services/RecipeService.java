package com.ildar.recipesapp.services;

import com.ildar.recipesapp.model.Recipe;
import org.springframework.stereotype.Service;

@Service

public interface RecipeService {
    void addRecipe(Recipe recipe);

    Recipe getRecipe(int number);

}
