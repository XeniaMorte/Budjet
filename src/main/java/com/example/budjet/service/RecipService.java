package com.example.budjet.service;

import com.example.budjet.model.Ricept;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class RecipService {
  private   Integer number = 0;
   private HashMap<Integer, Ricept> allRecepts;

    public Integer addRecipt(Ricept ricept) {

        Ricept riceptA = allRecepts.getOrDefault(number, ricept);
        allRecepts.put(number++, riceptA);
        return number;
    }

    public Ricept getRicept(int number) throws RuntimeException {
        if (allRecepts.containsKey(number)) {
             return  allRecepts.get(number);
        }
        else throw new RuntimeException("Error");

    }
}



