package com.ildar.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FirstController {
    @GetMapping
    public String hello() {
        return "Приложение запущено!";
    }

    @GetMapping("/info")
    public String info() {
        return "Ильдар Амерханов, RecipeApp, 27.12.2022, описание проекта в свободной форме" ;
    }

}
