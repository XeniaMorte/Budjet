package com.example.budjet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Ingridient {
    private String name;
    private int weight;
    private String meraIzmerenia;


    public Ingridient(){

    }
}
