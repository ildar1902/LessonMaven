package com.ildar.recipesapp.controllers;
import com.ildar.recipesapp.model.Ingredient;
import com.ildar.recipesapp.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")

public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public Ingredient add(@RequestBody Ingredient ingredient) {
        ingredientService.add(ingredient);
        return ingredient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient>  get(@PathVariable int id) {
        return ResponseEntity.of(ingredientService.get(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> edit(@PathVariable int id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.of(ingredientService.edit(id, ingredient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredient> delete(@PathVariable int id) {
        return ResponseEntity.of(ingredientService.delete(id));
    }

    @GetMapping
    public Map<Integer, Ingredient> getAll() {
        return ingredientService.getAll();
    }
}
