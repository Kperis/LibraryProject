package com.el20134;

import java.io.Serializable;


public class Book implements Serializable{
    private String title;
    private float rating;
    private String isbn;
    private String author;
    private String publication_year;
    private String publisher;
    private Category category;
    private int copies;
    

    public Book(String title, String isbn, String author, String publication_year, String publisher, Category category, int copies){
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.category = category;
        this.publication_year = publication_year;
        this.publisher = publisher;
        this.copies = copies;
        this.rating = 0.0f;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public String getPublisher() {
        return publisher;
    }

    public Category getCategory() {
        return category;
    }


    public int getCopies() {
        return copies;
    }

    public float getRating() {
        return rating;
    }
}
