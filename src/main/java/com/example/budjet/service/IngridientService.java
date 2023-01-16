package com.example.budjet.service;

import com.example.budjet.model.Ingridient;
import com.example.budjet.model.Ricept;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class IngridientService {
    private int number = 0;
    private HashMap<Integer, Ingridient> allIngridients;

    private void addIng(int number, Ingridient ingridient) {
        Ingridient ingridient1 = allIngridients.getOrDefault(number, ingridient);
        allIngridients.put(number++, ingridient1);

    }

    private Ingridient getIng(int number) throws RuntimeException {
        if (allIngridients.containsKey(number)) {
            return allIngridients.get(number);
        } else throw new RuntimeException("Error 2");

    }

}
