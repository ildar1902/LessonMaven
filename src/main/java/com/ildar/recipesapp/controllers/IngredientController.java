package com.ildar.recipesapp.controllers;

import com.ildar.recipesapp.model.Ingredient;
import com.ildar.recipesapp.services.IngredientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")

public class IngredientController {
    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/create")
    public void addIngredient(@RequestParam Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
    }

    @GetMapping("/get")
    public Ingredient getIngredient(@RequestParam int ingredientNumber) {
        return ingredientService.getIngredient(ingredientNumber);
    }
}
