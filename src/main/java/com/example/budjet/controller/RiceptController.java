package com.example.budjet.controller;

import com.example.budjet.model.Ingridient;
import com.example.budjet.model.Ricept;
import com.example.budjet.service.RecipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @Operation(summary = "получение всех рецептов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "рецепты были найдены",
                    content = {
                            @Content(mediaType = "json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ricept.class)))
                    })
    })
    public List< Ricept> getAllRec() {
        return this.recipService.getAllRec();
    }

}





