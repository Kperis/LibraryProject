package com.el20134;

import java.io.Serializable;

public class Comment implements Serializable{
    private String comment;
    private Client client;

    public Comment(String comment, Client client){
        this.client = client;
        this.comment = comment;
    }

    public Client getClient() {
        return client;
    }

    public String getComment() {
        return comment;
    }
}
