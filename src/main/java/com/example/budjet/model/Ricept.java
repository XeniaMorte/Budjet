package com.example.budjet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Ricept {
    String name;
    int timeCook;
    ArrayList<String> ingredients;
    StringBuilder steps;

}
