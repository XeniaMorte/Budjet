package com.example.budjet.service;

import com.example.budjet.exceptions.ExceptionAuthor;
import com.example.budjet.model.Ricept;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
    FileService<List<Ricept>> fileService;
    private HashMap<Integer, Ricept> allRecepts = new HashMap<>();


    private Integer _addRecipt(Ricept ricept) {
        allRecepts.put(number++, ricept);
        return number;
    }

    public Integer addRecipt(Ricept ricept) {
        Integer id = _addRecipt(ricept);
        saveRec();
        return id;
    }

    public Ricept getRicept(int number) throws ExceptionAuthor {
        if (allRecepts.containsKey(number)) {
            return allRecepts.get(number);
        }

        throw new ExceptionAuthor();

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

    public List<Ricept> getAllRec() {
        return new ArrayList<>(allRecepts.values());
    }

    public List<Ricept> getAllRecByIngridientId(String name) {
        return allRecepts.values().stream().filter((rec) -> {
            return rec.getIngredients().stream().filter(ing -> {
                return ing.getName().equals(name);
            }).collect(Collectors.toList()).size() > 0;
        }).collect(Collectors.toList());
        //streamAPI
        // функциональный стиль программирования


    }

    //  Вывод рецептов постранично по 10 штук - получить колво страниц , сравнить с колвом стр и вывести элементы ( итератор)
    public List<Ricept> getAllRecByIngridientNames(List<String> names) {
        return allRecepts.values().stream().filter((rec) -> {
            return rec.getIngredients().stream().filter(ing -> {
                return names.contains(ing.getName());
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

            ArrayList<Ricept> riceptsFromFile = (ArrayList<Ricept>) fileService.readFromFile(path, new TypeReference<List<Ricept>>() {
            });
            riceptsFromFile.forEach(this::addRecipt);//== мы вызываем this.addRec и в параметре передаем каждый элем списка
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveRec() {
        try {

            fileService.saveFile(new ArrayList<>(getAllRec()), path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




