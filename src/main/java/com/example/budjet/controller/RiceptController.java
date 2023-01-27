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


    @GetMapping("/{number}")
    public Ricept getRicept(@PathVariable int number) {
        return this.recipService.getRicept(number);
    }

    @PutMapping
    public void editRec(@PathVariable int number, @RequestBody Ricept newricept) {
        this.recipService.editRec(number, newricept);
    }

    @DeleteMapping("/{number}")
    public void deliteRec(@PathVariable int number) {
        this.recipService.deliteRec(number);
    }

    @GetMapping
    public String getAllRec() {
        return this.recipService.getAllRec();
    }

}





