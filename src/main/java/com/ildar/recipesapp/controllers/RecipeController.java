package com.ildar.recipesapp.controllers;

import com.ildar.recipesapp.model.Recipe;
import com.ildar.recipesapp.services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/create")
    public void addRecipe(@RequestParam Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

    @GetMapping("/get")
    public Recipe getRecipe(@RequestParam int recipeNumber) {
        return recipeService.getRecipe(recipeNumber);
    }




}

