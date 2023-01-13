package com.ildar.recipesapp.controllers;

import com.ildar.recipesapp.model.Recipe;
import com.ildar.recipesapp.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public String add(@RequestBody Recipe recipe) {
        return recipeService.add(recipe);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> get(@PathVariable int id) {
        return ResponseEntity.of(recipeService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> edit(@PathVariable int id, @RequestBody Recipe recipe) {
        return ResponseEntity.of(recipeService.edit(id, recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable int id) {
        return ResponseEntity.of(recipeService.delete(id));
    }

    @GetMapping
    public Map<Integer, Recipe> getAll() {
        return recipeService.getAll();
    }

}

