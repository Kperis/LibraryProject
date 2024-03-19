package com.el20134;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Book implements Serializable{
    private String title;
    private float rating;
    private List<Integer> rating_list;
    private String isbn;
    private String author;
    private String publication_year;
    private String publisher;
    private Category category;
    public List<Comment> comments;
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
        this.rating_list = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getVoteesNumber(){
        return rating_list.size();
    }

    public void updateRating(Integer number){
        rating_list.add(number);
        Integer temp = 0;
        for(Integer num : rating_list){
            temp = temp + num;
        }
        float avg = (float) temp/rating_list.size();
        this.rating = avg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public float getRating() {
        return rating;
    }
}
