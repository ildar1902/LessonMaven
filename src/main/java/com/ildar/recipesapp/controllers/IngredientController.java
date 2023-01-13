package com.ildar.recipesapp.controllers;
import com.ildar.recipesapp.model.Ingredient;
import com.ildar.recipesapp.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
