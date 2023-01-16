package com.ildar.recipesapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ildar.recipesapp.model.Ingredient;
import com.ildar.recipesapp.services.FileService;
import com.ildar.recipesapp.services.IngredientService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final FileService ingredientFileService;
    private static Map<Integer, Ingredient> ingredients = new TreeMap<>();
    private static int idCounter = 1;

    public IngredientServiceImpl(FileService ingredientFileService) {
        this.ingredientFileService = ingredientFileService;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public Ingredient add(Ingredient ingredient) {
        ingredients.put(idCounter++, ingredient);
        saveFile();
        return ingredient;
    }

    @Override
    public Optional<Ingredient> get(int id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    @Override
    public Optional<Ingredient> edit(int id, Ingredient ingredient) {
        Optional<Ingredient> optional = Optional.ofNullable(ingredients.replace(id, ingredient));
        saveFile();
        return optional;
    }

    @Override
    public Optional<Ingredient> delete(int id) {
        return Optional.ofNullable(ingredients.remove(id));
    }

    @Override
    public Map<Integer, Ingredient> getAll() {
        return new TreeMap<>(ingredients);
    }

    private void saveFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            ingredientFileService.saveToIngredientFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        String json = ingredientFileService.readIngredientFile();
        try {
            ingredients = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}