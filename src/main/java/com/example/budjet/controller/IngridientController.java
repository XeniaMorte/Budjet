package com.example.budjet.controller;

import com.example.budjet.model.Ingridient;
import com.example.budjet.model.Ricept;
import com.example.budjet.service.IngridientService;
import com.example.budjet.service.RecipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngridientController {

    public final IngridientService ingridientService;

    public IngridientController( IngridientService ingridientService) {
        this.ingridientService= ingridientService;
    }
    @GetMapping
    public Integer addIng(@RequestBody  Ingridient ingridient) {
            return this.ingridientService.addIng(ingridient);
    }

    @PostMapping
    public Ingridient getIng(int number) {
        return this.ingridientService.getIng(number);
    }
}




