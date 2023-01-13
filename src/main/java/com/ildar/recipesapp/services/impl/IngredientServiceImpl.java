package com.ildar.recipesapp.services.impl;

import com.ildar.recipesapp.model.Ingredient;
import com.ildar.recipesapp.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
@Service
public class IngredientServiceImpl implements IngredientService {
    private final Map<Integer, Ingredient> ingredients = new TreeMap<>();
    private static int idCounter = 1;
    @Override
    public Ingredient add (Ingredient ingredient) {
        ingredients.put(idCounter++, ingredient);
        return ingredient;
    }

    @Override
    public Optional<Ingredient> get(int id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    @Override
    public Optional<Ingredient> edit(int id, Ingredient ingredient) {
        return Optional.ofNullable(ingredients.replace(id, ingredient));
    }

    @Override
    public Optional<Ingredient> delete(int id) {
        return Optional.ofNullable(ingredients.remove(id));
    }

    @Override
    public Map<Integer, Ingredient> getAll() {
        return new TreeMap<>(ingredients);
    }


}
