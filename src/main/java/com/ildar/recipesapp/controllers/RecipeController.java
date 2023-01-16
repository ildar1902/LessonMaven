package com.ildar.recipesapp.controllers;

import com.ildar.recipesapp.model.Recipe;
import com.ildar.recipesapp.services.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "Рецепт controller", description = "API для работы с рецептами")
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Operation(summary = "Добавить рецепт", description = "Здесь выполняется добавление нового рецепта")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Добавление рецепта прошло успешно"),
            @ApiResponse(responseCode = "400", description = "Некорректные параметры рецепта")
    })
    @PostMapping
    public String add(@RequestBody Recipe recipe) {
        return recipeService.add(recipe);
    }

    @Operation(summary = "Получить рецепт по id", description = "Здесь выполняется вывод рецепта по id на экран")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Операция получения рецепта выполнена успешно"),
            @ApiResponse(responseCode = "400", description = "Некорректные параметры ")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> get(@PathVariable int id) {
        return ResponseEntity.of(recipeService.get(id));
    }

    @Operation(summary = "Изменить рецепт", description = "Здесь выполняется редактирование существующего рецепта")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Операция изменения рецепта выполнена успешно"),
            @ApiResponse(responseCode = "400", description = "Некорректные параметры ")
    })

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> edit(@PathVariable int id, @RequestBody Recipe recipe) {
        return ResponseEntity.of(recipeService.edit(id, recipe));
    }

    @Operation(summary = "Удалить рецепт", description = "Здесь выполняется удаление рецепта по id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Операция удаления рецепта выполнена успешно"),
            @ApiResponse(responseCode = "400", description = "Некорректные параметры ")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable int id) {
        return ResponseEntity.of(recipeService.delete(id));
    }

    @Operation(summary = "Показать все рецепты", description = "Здесь выполняется вывод всех рецептов на экран")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Операция получения рецептов выполнена успешно"),
            @ApiResponse(responseCode = "400", description = "Некорректные параметры ")
    })
    @GetMapping
    public Map<Integer, Recipe> getAll() {
        return recipeService.getAll();
    }

}

