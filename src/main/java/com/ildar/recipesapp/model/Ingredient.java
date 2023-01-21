package com.ildar.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ingredient {
    private String name;
    private Integer quantity;
    private String measureUnit;

    @Override
    public String toString() {
        return name + " - " + quantity + " " + measureUnit;
    }
}
