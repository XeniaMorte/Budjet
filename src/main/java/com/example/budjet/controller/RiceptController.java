package com.example.budjet.controller;

import com.example.budjet.model.Ricept;
import com.example.budjet.service.RecipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RiceptController {

    private RecipService recipService ;

    public RiceptController(RecipService recipService) {
        this.recipService = recipService;
    }
    @PostMapping
    public  String addRicepr(@RequestBody Ricept ricept) {
        return this.recipService.addRecipt(ricept).toString();
    }

    @GetMapping
    public  String getRicept(int number) {
        return this.recipService.getRicept(number).toString();
    }
}





