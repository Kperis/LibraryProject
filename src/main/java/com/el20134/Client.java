package com.el20134;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Client extends User{
    private final String first_name;
    private final String last_name;
    private final String adt;
    private final String email;
    private List<Book> books_rated;
    public List<Book> borrowed;
  

    public Client (String username, String password, String first_name, String last_name, String email, String adt){
        super(username,password);

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.adt = adt;
        this.books_rated = new ArrayList<>();
        this.borrowed = new ArrayList<>();
    }


    public String getFirstName(){
        return this.first_name;
    }

    public List<Book> getBooks_rated() {
        return books_rated;
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

    // public List<Book> getBorrowed(){
    //     return borrowed;
    // }

    public void BorrowBook(Book book){
        for(Book b : borrowed){
            System.out.println(b.getTitle());
        }
        if(book.getCopies() > 0){
            if(borrowed.size() == 2){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Cannot Borrow");
                alert.setHeaderText(null);
                alert.setContentText("You cannot borrow more than 2 books");

                alert.showAndWait(); 
            }
            else{
                Borrow borrowRecord = new Borrow(this, book, LocalDate.now());
                borrowed.add(book);
                Model.getInstance().getBorrowed_store().add(borrowRecord);
                Model.getInstance().borrows.add(borrowRecord);
                book.setCopies(book.getCopies() - 1);
            }
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Cannot Borrow");
            alert.setHeaderText(null);
            alert.setContentText("No available copies. Check back later!");

            alert.showAndWait(); 
        }
        System.out.println(borrowed.size());
    }
}
