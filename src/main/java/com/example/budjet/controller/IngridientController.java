package com.example.budjet.controller;

import com.example.budjet.model.Ingridient;
import com.example.budjet.model.Ricept;
import com.example.budjet.service.IngridientService;
import com.example.budjet.service.RecipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngridientController {

    public final IngridientService ingridientService;

    public IngridientController( IngridientService ingridientService) {
        this.ingridientService= ingridientService;
    }
    @GetMapping
    public static String addIng(int number, Ingridient ingridient) {
        return "ingridient";
    }

    @PostMapping
    public static String getIng(int number) {
        return "Ксеня Новикова\n9.01.23\nРецепт\nСоздание рецептов";
    }
}




