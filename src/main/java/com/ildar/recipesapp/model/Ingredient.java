package com.ildar.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ingredient {
    String name;
    Integer quantity;
    String measureUnit;

}
