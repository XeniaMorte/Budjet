package com.example.budjet.service;

import com.example.budjet.exceptions.ExceptionAuthor;
import com.example.budjet.model.Ingridient;
import com.example.budjet.model.Ricept;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
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

    private Integer _addIng(Ingridient ingridient) {
        Ingridient ingridient1 = allIngridients.getOrDefault(number, ingridient);
        allIngridients.put(number++, ingridient1);
        return number;
    }

    public Integer addIng(Ingridient ingridient) {
        Integer id = _addIng(ingridient);
        saveRec();
        return id;
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
        saveRec();
        return newingridient;


    }

    public void deliteIng(int number) {
        allIngridients.remove(number);
        saveRec();
    }

    public HashMap<Integer, Ingridient> getAllIng() {
        return allIngridients;
    }

    @PostConstruct
    public void init() {
        try {
            ArrayList<Ingridient> ingridientArrayList = (ArrayList<Ingridient>) fileService.readFromFile(path, new TypeReference<List<Ingridient>>() {
            });

            ingridientArrayList.forEach(this::_addIng);

//            for (var ing : ingridientArrayList) {
//                this.addIng(ing)
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void saveRec() {
        try {

            fileService.saveFile(new ArrayList<>(getAllIng().values()), path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // вызвать метод saverec при любом изменении рецептов


}
