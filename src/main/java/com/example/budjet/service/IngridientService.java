package com.example.budjet.service;

import com.example.budjet.exceptions.ExceptionAuthor;
import com.example.budjet.model.Ingridient;
import com.example.budjet.model.Ricept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class IngridientService {
    private int number = 0;
    @Autowired
    FileService<List<Ingridient>> fileService;
    @Value("${settings.ing.file.path}")
    private String path;
    private HashMap<Integer, Ingridient> allIngridients;

    public Integer addIng(Ingridient ingridient) {
        Ingridient ingridient1 = allIngridients.getOrDefault(number, ingridient);
        allIngridients.put(number++, ingridient1);
        return number;

    }

    public Ingridient getIng(int number) throws ExceptionAuthor {
        if (allIngridients.containsKey(number)) {
            return allIngridients.get(number);
        } else throw new RuntimeException("Error 2");

    }

    public Ingridient editIng(int number, Ingridient newingridient) throws ExceptionAuthor {
        if (allIngridients.containsKey(number)) {
            newingridient = allIngridients.replace(number, newingridient);
        }
        return newingridient;

    }

    public void deliteIng(int number) {
        allIngridients.remove(number);
    }

    public HashMap<Integer, Ingridient>  getAllIng() {
        return allIngridients;
    }
   private  void saveRec() {
        try {

            fileService.saveFile(new ArrayList<>(getAllIng().values()),path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // вызвать метод saverec при любом изменении рецептов



}
