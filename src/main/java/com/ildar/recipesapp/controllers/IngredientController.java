package com.ildar.recipesapp.controllers;
import com.ildar.recipesapp.model.Ingredient;
import com.ildar.recipesapp.services.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@Tag(name="Ингредиент controller", description = "API для работы с ингредиентами")
@RestController
@RequestMapping("/ingredient")

public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
@Operation(summary = "Добавить ингредиент", description = "Здесь выполняется добавление нового ингредиента")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Добавление ингредиента прошло успешно"),
        @ApiResponse(responseCode = "400", description = "Некорректные параметры ингредиента")
})
    @PostMapping
    public Ingredient add(@RequestBody Ingredient ingredient) {
        ingredientService.add(ingredient);
        return ingredient;
    }
@Operation(summary = "Получить ингредиент по id", description = "Здесь выполняется вывод ингредиентов по id")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Операция получения ингредиента выполнена успешно"),
        @ApiResponse(responseCode = "400", description = "Некорректные параметры")
})
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient>  get(@PathVariable int id) {
        return ResponseEntity.of(ingredientService.get(id));
    }
    @Operation(summary = "Изменить ингредиент", description = "Здесь выполняется редактирование ингредиентов")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Операция редактиовани ингредиента выполнена успешно"),
            @ApiResponse(responseCode = "400", description = "Некорректные параметры")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> edit(@PathVariable int id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.of(ingredientService.edit(id, ingredient));
    }
@Operation(summary = "Удалить ингредиент", description = "ЗДесь выполняется удаление ингредиента по id")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Операция удаления ингредиента выполнена успешно"),
        @ApiResponse(responseCode = "400", description = "Некорректные параметры")
})
    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredient> delete(@PathVariable int id) {
        return ResponseEntity.of(ingredientService.delete(id));
    }
@Operation(summary = "Показать весь список ингредиентов")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Операция получения ингредиентов выполнена успешно"),
        @ApiResponse(responseCode = "400", description = "Некорректные параметры")
})
    @GetMapping
    public Map<Integer, Ingredient> getAll() {
        return ingredientService.getAll();
    }
}
