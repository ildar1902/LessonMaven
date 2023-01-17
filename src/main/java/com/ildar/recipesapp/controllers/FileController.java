package com.ildar.recipesapp.controllers;


import com.ildar.recipesapp.services.FileService;
import com.ildar.recipesapp.services.IngredientService;
import com.ildar.recipesapp.services.RecipeService;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;
    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public FileController(FileService fileService, RecipeService recipeService, IngredientService ingredientService) {
        this.fileService = fileService;
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }


    @GetMapping("/export/recipe")
    public ResponseEntity<InputStreamResource> downloadRecipeDataFile() throws FileNotFoundException {

        File file = fileService.getDataFile(recipeService.getFilePath());
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"RecipesLog.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/export/ingredient")
    public ResponseEntity<InputStreamResource> downloadIngredientDataFile() throws FileNotFoundException {

        File file = fileService.getDataFile(ingredientService.getFilePath());
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping(value = "/import/recipe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadRecipeDataFile(@RequestParam MultipartFile file) {
        fileService.cleanFile(recipeService.getFilePath());
        File dataFile = fileService.getDataFile(recipeService.getFilePath());
        try (FileOutputStream fos = new FileOutputStream(dataFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping(value = "/import/ingredient", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadIngredientDataFile(@RequestParam MultipartFile file) {
    fileService.cleanFile(ingredientService.getFilePath());
        File dataFile = fileService.getDataFile(ingredientService.getFilePath());
        try (FileOutputStream fos = new FileOutputStream(dataFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}