package com.ildar.recipesapp.services.impl;

import com.ildar.recipesapp.services.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service

public class FileServiceImpl implements FileService {
    @Value("${path.to.recipe.data.file}")
    private String recipeFilepath;
    @Value("${path.to.ingredient.data.file}")
    private String ingredientFilePath;

    @Override
    public boolean saveToRecipeFile(String json) {
        try {
            Files.writeString(Path.of(recipeFilepath), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readRecipeFile() {
        try {
            return Files.readString(Path.of(recipeFilepath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cleanRecipeFile() {
        try {
            Files.deleteIfExists(Path.of(recipeFilepath));
            Files.createFile(Path.of(recipeFilepath));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveToIngredientFile(String json) {
        try {
            Files.writeString(Path.of(ingredientFilePath), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readIngredientFile() {
        try {
            return Files.readString(Path.of(ingredientFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cleanIngredientFile() {
        try {
            Files.deleteIfExists(Path.of(ingredientFilePath));
            Files.createFile(Path.of(ingredientFilePath));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
