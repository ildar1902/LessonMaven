package com.ildar.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CookingTime {
    private int duration;
    private String timeUnit;

    @Override
    public String toString() {
        return duration + " " + timeUnit;
    }
}
