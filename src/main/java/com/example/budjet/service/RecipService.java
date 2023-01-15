package com.example.budjet.service;

import com.example.budjet.model.Ricept;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class RecipService {
  private   int number = 0;
   private HashMap<Integer, Ricept> allRecepts;

    private void addRecipt(int number, Ricept ricept) {

        Ricept riceptA = allRecepts.getOrDefault(number, ricept);
        allRecepts.put(number++, riceptA);
    }

    private Ricept getRicept(int number) throws RuntimeException {
        if (allRecepts.containsKey(number)) {
             return  allRecepts.get(number);
        }
        else throw new RuntimeException("Error");

    }
}



