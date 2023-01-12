package com.example.budjet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ricept {
    String name;
    int timeCook;
    Ingridient[] ingredients;
    StringBuilder steps;

}
