package com.example.budjet.service;

import com.example.budjet.exceptions.ExceptionAuthor;
import com.example.budjet.model.Ricept;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipService {
    @Value("${settings.ricipe.file.path}")
    private String path;
    private Integer number = 0;
    @Autowired
    FileService<Ricept> fileService;
    private HashMap<Integer, Ricept> allRecepts = new HashMap<>();

    public Integer addRecipt(Ricept ricept) {
        allRecepts.put(number++, ricept);
        saveRec();
        return number;

    }

    public Ricept getRicept(int number) throws ExceptionAuthor {
        if (allRecepts.containsKey(number)) {
            return allRecepts.get(number);
        } else throw new ExceptionAuthor();

    }

    public void editRec(int number, Ricept newricept) {
        newricept = allRecepts.get(number);
        allRecepts.replace(number, newricept);
        saveRec();
    }

    public void deliteRec(int number) {
        allRecepts.remove(number);
        saveRec();
    }

    public HashMap<Integer, Ricept> getAllRec() {
        return (HashMap<Integer, Ricept>) allRecepts.values();
    }

    public List<Ricept> getAllRecByIngridientId(String name) {
        return allRecepts.values().stream().filter((rec) -> {
            return rec.getIngredients().stream().filter(ing -> {
                return ing.getNameIng().equals(name);
            }).collect(Collectors.toList()).size() > 0;
        }).collect(Collectors.toList());
        //streamAPI
        // функциональный стиль программирования


    }

    //  Вывод рецептов постранично по 10 штук - получить колво страниц , сравнить с колвом стр и вывести элементы ( итератор)
    public List<Ricept> getAllRecByIngridientNames(List<String> names) {
        return allRecepts.values().stream().filter((rec) -> {
            return rec.getIngredients().stream().filter(ing -> {
                return names.contains(ing.getNameIng());
            }).collect(Collectors.toList()).size() > 0;
        }).collect(Collectors.toList());
        //streamAPI
        // функциональный стиль программирования


    }

    @PostConstruct
    public void init() {


        try {
            //File file = new File(path);
            //  ObjectMapper objectMapper = new ObjectMapper();// считывает содержимое , переводит в объект или из объекта делает например строку

            List<Ricept> riceptsFromFile = fileService.readFromFile(path);
            riceptsFromFile.forEach(this::addRecipt);//== мы вызываем this.addRec и в параметре передаем каждый элем списка
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveRec() {
        try {

            fileService.saveFile(new ArrayList<>(getAllRec().values()), path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




