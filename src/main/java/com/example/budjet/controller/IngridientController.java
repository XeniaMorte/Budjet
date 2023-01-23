package com.example.budjet.controller;

import com.example.budjet.model.Ingridient;
import com.example.budjet.model.Ricept;
import com.example.budjet.service.IngridientService;
import com.example.budjet.service.RecipService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Ingridient getIng(int number) {
        return this.ingridientService.getIng(number);
    }
    @PutMapping
    public Ingridient editIng(int number,Ingridient newingridient){
        return  this.ingridientService.editIng(number,newingridient);
    }
    @DeleteMapping
    public void deliteIng (int number){
        this.ingridientService.deliteIng(number);

    }
    @GetMapping
    public String getAllIng(){
     return    this.ingridientService.getAllIng();
    }


}




