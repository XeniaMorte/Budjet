package com.example.budjet.service;

import com.example.budjet.exceptions.ExceptionAuthor;
import com.example.budjet.model.Ricept;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipService {
    private Integer number = 0;
    private HashMap<Integer, Ricept> allRecepts;

    public Integer addRecipt(Ricept ricept) {

        Ricept riceptA = allRecepts.getOrDefault(number, ricept);
        allRecepts.put(number++, riceptA);
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
    }

    public void deliteRec(int number) {
        allRecepts.remove(number);
    }

    public String getAllRec() {
        return allRecepts.values().toString();
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
}




