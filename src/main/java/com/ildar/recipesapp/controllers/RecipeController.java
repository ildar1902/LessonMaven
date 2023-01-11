package com.ildar.recipesapp.controllers;

import com.ildar.recipesapp.model.Recipe;
import com.ildar.recipesapp.services.RecipeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/create")
    public void addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

    @GetMapping("/info")
    public Recipe getRecipe(@RequestParam int recipeNumber) {
        return recipeService.getRecipe(recipeNumber);
    }




}

