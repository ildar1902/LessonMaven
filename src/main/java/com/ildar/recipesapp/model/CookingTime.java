package com.ildar.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CookingTime {
    private int duration;
    private String timeUnit;
}
