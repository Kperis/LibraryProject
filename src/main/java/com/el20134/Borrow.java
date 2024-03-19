package com.el20134;

import java.io.Serializable;
import java.time.LocalDate;

public class Borrow implements Serializable{

    private Client client;
    private Book book;
    private LocalDate date;


    public Borrow(Client client, Book book, LocalDate date){
        this.client = client;
        this.book = book;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    
    public Book getBook() {
        return book;
    }

    public Client getClient() {
        return client;
    }

}
