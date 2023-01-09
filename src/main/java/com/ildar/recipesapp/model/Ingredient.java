package com.ildar.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Ingredient {
    String name;
    Integer count;
    String measureUnit;

}
