package com.ildar.recipesapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ildar.recipesapp.model.Recipe;
import com.ildar.recipesapp.services.FileService;
import com.ildar.recipesapp.services.RecipeService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static Map<Integer, Recipe> recipes = new TreeMap<>();
    private final FileService recipeFileService;
    private static int recipeId = 0;

    public RecipeServiceImpl(FileService recipeFileService) {
        this.recipeFileService = recipeFileService;
    }

    @Override
    public String add(Recipe recipe) {
        recipes.put(++recipeId, recipe);
        saveFile();
        return "добавлен рецепт: \"" + recipe.getName() + "\", он будет храниться под номером " + recipeId;
    }

    @Override
    public Optional<Recipe> get(int id) {
        return Optional.ofNullable(recipes.get(id));
    }

    @Override
    public Optional<Recipe> edit(int id, Recipe recipe) {
        Optional<Recipe> optional = Optional.ofNullable(recipes.replace(id, recipe));
        saveFile();
        return optional;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public Optional<Recipe> delete(int id) {
        return Optional.ofNullable(recipes.remove(id));
    }

    @Override
    public Map<Integer, Recipe> getAll() {
        return new TreeMap<>(recipes);
    }

    private void saveFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            recipeFileService.saveToRecipeFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        String json = recipeFileService.readRecipeFile();
        try {
           recipes = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

