package com.ildar.recipesapp.services;

public interface FileService {
    boolean saveToRecipeFile(String json);

    String readRecipeFile();

    boolean cleanRecipeFile();

    boolean saveToIngredientFile(String json);

    String readIngredientFile();

    boolean cleanIngredientFile();
}
