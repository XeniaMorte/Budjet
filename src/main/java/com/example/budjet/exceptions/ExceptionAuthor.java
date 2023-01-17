package com.example.budjet.exceptions;

public class ExceptionAuthor extends  RuntimeException{
    private int number;
    public int getNumber(){return number;}
    public ExceptionAuthor(){

        super("Error");
        number=getNumber();
    }

}
