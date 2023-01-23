package com.example.budjet.controller;

import com.example.budjet.model.Ricept;
import com.example.budjet.service.RecipService;
import org.springframework.web.bind.annotation.*;

@RestController
public class RiceptController {

    private RecipService recipService;

    public RiceptController(RecipService recipService) {
        this.recipService = recipService;
    }

    @PostMapping
    public Integer addRicepr(@RequestBody Ricept ricept) {
        return this.recipService.addRecipt(ricept);
    }

    @GetMapping
    public Ricept getRicept(int number) {
        return this.recipService.getRicept(number);
    }

    @GetMapping
    public void editRec(int number, Ricept newricept) {
        this.recipService.editRec(number, newricept);
    }

    @DeleteMapping
    public void deliteRec(int number) {
        this.recipService.deliteRec(number);
    }
    @GetMapping
    public String getAllRec(){
       return this.recipService.getAllRec();
    }

}





