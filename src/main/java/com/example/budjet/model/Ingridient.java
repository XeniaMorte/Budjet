package com.example.budjet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Ingridient {
    private String nameIng;
    private int countIng;
    private String typeIzm;
    public Ingridient(){

    }
}
