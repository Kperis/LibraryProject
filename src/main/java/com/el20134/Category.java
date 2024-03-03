package com.el20134;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable{
    private String name;
    private List<Book> books;

    public Category(String name){
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void removeCategory(String name){

    }

    public void addCategory(String name){
        
    }
}
