package com.ildar.recipesapp.controllers;

import com.ildar.recipesapp.model.Ingredient;
import com.ildar.recipesapp.services.IngredientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")

public class IngredientController {
    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/create")
    public void addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
    }

    @GetMapping("/info")
    public Ingredient getIngredient(@RequestParam int ingredientNumber) {
        return ingredientService.getIngredient(ingredientNumber);
    }
}
