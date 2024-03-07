package com.el20134;

import java.util.ArrayList;
import java.util.List;

public class Client extends User{
    private final String first_name;
    private final String last_name;
    private final String adt;
    private final String email;
    private List<Book> borrowed;

    public Client (String username, String password, String first_name, String last_name, String email, String adt){
        super(username,password);

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.adt = adt;
        this.borrowed = new ArrayList<>();
    }

    public String getFirstName(){
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public String getAdt() {
        return this.adt;
    }

    public String getEmail() {
        return this.email;
    }
}
