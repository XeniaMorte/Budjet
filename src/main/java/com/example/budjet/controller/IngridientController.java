package com.example.budjet.controller;

import com.example.budjet.model.Ingridient;
import com.example.budjet.model.Ricept;
import com.example.budjet.service.IngridientService;
import com.example.budjet.service.RecipService;
import org.springframework.web.bind.annotation.*;

@RestController("/ingridient")
public class IngridientController {

    public final IngridientService ingridientService;

    public IngridientController(IngridientService ingridientService) {
        this.ingridientService = ingridientService;
    }

    @PostMapping
    public Integer addIng(@RequestBody Ingridient ingridient) {
        return this.ingridientService.addIng(ingridient);
    }

    @GetMapping("/get")
    public Ingridient getIng(@RequestParam("number") int number) {
        return this.ingridientService.getIng(number);
    }

    @PutMapping("/edit")
    public Ingridient editIng(@RequestParam("number") int number, @RequestBody Ingridient newingridient) {
        return this.ingridientService.editIng(number, newingridient);
    }



    @DeleteMapping("/{id}")
    public void deliteIng(@PathVariable int number) {
        this.ingridientService.deliteIng(number);
    }

    @GetMapping
    public String getAllIng() {
        return this.ingridientService.getAllIng();
    }


}




