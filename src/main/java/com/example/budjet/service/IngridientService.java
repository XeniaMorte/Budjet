package com.example.budjet.service;

import com.example.budjet.exceptions.ExceptionAuthor;
import com.example.budjet.model.Ingridient;
import com.example.budjet.model.Ricept;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class IngridientService {
    private int number = 0;
    private HashMap<Integer, Ingridient> allIngridients;

    public Integer addIng( Ingridient ingridient) {
        Ingridient ingridient1 = allIngridients.getOrDefault(number, ingridient);
        allIngridients.put(number++, ingridient1);
        return number;

    }

    public Ingridient getIng(int number) throws ExceptionAuthor {
        if (allIngridients.containsKey(number)) {
            return allIngridients.get(number);
        } else throw new RuntimeException("Error 2");

    }
    public Ingridient editIng(int number,Ingridient newingridient)throws ExceptionAuthor{
       newingridient= allIngridients.get(number);
      return  newingridient;

    }
    public void deliteIng (int number){
        allIngridients.remove(number);
    }
    public String getAllIng(){
        return allIngridients.toString();
    }




}
