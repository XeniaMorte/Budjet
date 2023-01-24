package com.example.budjet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Ricept {
 private    String name;
     private int timeCook;
   private ArrayList<Ingridient> ingredients;
  private   ArrayList<String> steps;

}
