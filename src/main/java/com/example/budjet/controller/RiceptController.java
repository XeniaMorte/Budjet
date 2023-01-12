package com.example.budjet.controller;

import com.example.budjet.model.Ricept;
import com.example.budjet.service.RecipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RiceptController {
    public final RecipService recipService;

    public RiceptController(RecipService recipService) {
        this.recipService = recipService;
    }
    @GetMapping
    public static String addRicepr(int number, Ricept ricept) {
        return "Receeept";
    }

    @GetMapping
    public static String getRicept(int number) {
        return "Ксеня Новикова\n9.01.23\nРецепт\nСоздание рецептов";
    }
}





