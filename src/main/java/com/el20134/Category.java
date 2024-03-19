package com.el20134;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Category implements Serializable{
    private String name;
    private List<Book> books;


    /**Constructor of Category. Gets called when a new instance of Category is created
     * <p>
     * Constructor also initializes the books List to an empty List
     * 
     *@param name the name of the category created
     *@return A Category object
     */
    public Category(String name){
        this.name = name;
        this.books = new ArrayList<>();
    }

    /**Method that gets the name of the Category object
     * 
     * @return name of Category
     */
    public String getName() {
        return name;
    }


    /**Sets the name of the Category. Used for editing existing Category object
     * 
     * @param name
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }


    /**Returns the list of books with this category.
     * 
     * @return The list of books included in this Category
     */
    public List<Book> getBooks() {
        return books;
    }

    /**This method is used to remove the category. By removing it, the method
     * also makes sure every book contained in this category is also removed along with related 
     * borrows
     * @return void
     */
    public void removeCategory(){
        for(Book book : books){
            List<Book> stuff = new ArrayList<>();
            for(Client client : Model.getInstance().users){
                for(Book book2 : client.borrowed){
                    if(book.getIsbn().equals(book2.getIsbn())){
                        stuff.add(book2);
                    }
                }
                client.borrowed.removeAll(stuff);
            }

            List<Borrow> stuff2 = new ArrayList<>();
            for(Borrow borrow : Model.getInstance().borrows){
                if(borrow.getBook().getIsbn().equals(book.getIsbn())){
                    stuff2.add(borrow);
                }
            }
            Model.getInstance().borrows.removeAll(stuff2);

            stuff.clear();
            for(Book book2 : Model.getInstance().books){
                if(book.getIsbn().equals(book2.getIsbn())){
                    stuff.add(book2);
                }
            }
            Model.getInstance().books.removeAll(stuff);
        }

        Model.getInstance().categories.remove(this);
    }

    /**Adds a book to this Category, in the list book
     * 
     * @param book Book to be added to this Category
     * @return void
     */
    public void addBookToCategory(Book book){
        books.add(book);
    }

    
}
