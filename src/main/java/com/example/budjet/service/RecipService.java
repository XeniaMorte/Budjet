package com.example.budjet.service;

import com.example.budjet.model.Ricept;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class RecipService {
    int number = 0;
    HashMap<Integer, Ricept> allRecepts;

    public void addRecipt(int number, Ricept ricept) {

        Ricept riceptA = allRecepts.getOrDefault(number, ricept);
        allRecepts.put(number++, riceptA);
    }

    public Ricept getRicept(int number) {
        if (allRecepts.containsKey(number)) {
             return  allRecepts.get(1);
        }
        else return null;

    }
}



