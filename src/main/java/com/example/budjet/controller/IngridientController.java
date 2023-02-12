package com.example.budjet.controller;

import com.example.budjet.model.Ingridient;
import com.example.budjet.model.Ricept;
import com.example.budjet.service.IngridientService;
import com.example.budjet.service.RecipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("/ingridients/")
@Tag(name = "ингридиент",description = "операции с ингридидиентами, CRUD")
public class IngridientController {

    public final IngridientService ingridientService;

    public IngridientController(IngridientService ingridientService) {
        this.ingridientService = ingridientService;
    }

//    @PostMapping
//    public Integer addIng(@RequestBody Ingridient ingridient) {
//        return this.ingridientService.addIng(ingridient);
//    }

    @GetMapping("/get")
    public Ingridient getIng(@RequestParam("number") int number) {
        return this.ingridientService.getIng(number);
    }

 //   @PutMapping("/edit")
  //  public Ingridient editIng(@RequestParam("number") int number, @RequestBody Ingridient newingridient) {
 //       return this.ingridientService.editIng(number, newingridient);
  //  }



//    @DeleteMapping("/{number}")
//    public void deliteIng(@PathVariable int number) {
//        this.ingridientService.deliteIng(number);
//    }

    @GetMapping
    @Operation(summary = "получение всех ингридиентов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "ингридиетны были найдены",
            content = {
                    @Content(mediaType = "json",
                    array = @ArraySchema(schema = @Schema(implementation = Ingridient.class)))
            })
    })
    public HashMap<Integer, Ingridient> getAllIng() {
        return this.ingridientService.getAllIng();
    }


}




