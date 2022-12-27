package com.ildar.recipesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/")
    public String hello() {
        return "Приложение запущено!";
    }

    @GetMapping("/info")
    public String info() {
        return "Имя студента, название проекта, дата создания проекта, описание проекта в свободной форме" ;
    }

}
