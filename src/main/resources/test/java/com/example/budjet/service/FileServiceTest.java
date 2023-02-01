package com.example.budjet.service;

import com.example.budjet.model.Ingridient;
import com.example.budjet.model.Ricept;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {
    String path = "111.json";


    void readFromFile() throws IOException {
        FileService<Ricept> fileService = new FileService<Ricept>();
         List<Ricept> listRec= fileService.readFromFile(path);
         assertEquals(listRec.size(),1);// выдает Exception
        Ricept ricept = listRec.get(0);
        System.out.println(ricept);
        assertEquals(ricept.getName(),"Tst");
assertEquals(ricept.getIngredients().size(),1);
    }

    @Test
    void saveFile() throws IOException {
        FileService<Ricept> fileService = new FileService<Ricept>();
        ArrayList<Ingridient> list = new ArrayList<>();
        list.add(new Ingridient("t", 1, "wqa"));
        ArrayList<String> steps = new ArrayList<>();
        steps.add("1234567889");
        Ricept testRic = new Ricept("Tst", 12, list, steps);
        fileService.saveFile(List.of(testRic), path);
        readFromFile();
    }
}