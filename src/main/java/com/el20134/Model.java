package com.el20134;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.el20134.ViewFactory;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private Client client;
    private Admin admin;
    public ObservableList<Client> users;
    public ObservableList<Admin> admins;
    public ObservableList<Book> books;
    public ObservableList<Category> categories;
    public ObservableList<Borrow> borrows;
    private Book currentBook;
    private Category currentcategory;
    private ObservableList<Borrow> borrowed_store;
    public boolean onEdit;


    private Model(){
        this.viewFactory = new ViewFactory();
        currentBook = new Book(null, null, null, null, null, null, 0);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            cleanup();
        }));

        Admin temp = new Admin("medialab", "medialab_2024");
        
        String folderName = "medialab";
        
        
        Path folderPath = Paths.get(System.getProperty("user.dir"), folderName);
        
        onEdit = false;

        try{
            
            String filename = "Users.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<Client> temp2 = (List<Client>) objectIn.readObject();
            

            if(temp2 == null){
                users = FXCollections.observableArrayList();
            }
            else{
                users = FXCollections.observableArrayList(temp2);
            }
           

            objectIn.close();
            fileIn.close();

        } catch(Exception e){
            e.printStackTrace();
            users = FXCollections.observableArrayList();
        }


        try{

            String filename = "Admins.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<Admin> temp2 = (List<Admin>) objectIn.readObject();

            if(temp2 == null){
                admins = FXCollections.observableArrayList();
                admins.add(temp);
            }
            else{
                admins = FXCollections.observableArrayList(temp2);
            }


            objectIn.close();
            fileIn.close();

        }  catch(Exception e){
            e.printStackTrace();
            admins = FXCollections.observableArrayList();
            admins.add(temp);
        }

        try{

            String filename = "Categories.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<Category> temp2 = (List<Category>) objectIn.readObject();

            if(temp2 == null){
                categories = FXCollections.observableArrayList();
                categories.add(new Category("Fantasy"));
                categories.add(new Category("Science Fiction"));
            }
            else{
                categories = FXCollections.observableArrayList(temp2);
            }

            objectIn.close();
            fileIn.close();
            
        } catch(Exception e){
            e.printStackTrace();
            categories = FXCollections.observableArrayList();
            categories.add(new Category("Fantasy"));
            categories.add(new Category("Science Fiction"));
        }


        try{

            String filename = "Books.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<Book> temp2 = (List<Book>) objectIn.readObject();

            if(temp2 == null){
                books = FXCollections.observableArrayList();
                Book book1 = new Book("The Hunger Games", "9780439023481", "Suzanne Collins", "2008", "Scholastic Press", categories.get(0), 1);
                Book book2 = new Book("Harry Potter and the Sorcerer's Stone", "9780590353427", "J.K. Rowling", "1997", "Scholastic", categories.get(0), 4);
                Book book3 = new Book("Eragon", "9780375826696", "Christopher Paolini", "2002", "Knopf Books for Young Readers", categories.get(0), 2);
                Book book4 = new Book("Dune", "9780441172719", "Frank Herbert", "1965", "Ace Books", categories.get(1), 3);
                Book book5 = new Book("Mistborn: The Final Empire", "9780765311788", "Brandon Sanderson", "2006", "Tor Books", categories.get(0), 1);
                Book book6 = new Book("The Name of the Wind", "9780756404741", "Patrick Rothfuss", "2007", "DAW Books", categories.get(0), 1);
                Book book7 = new Book("Ready Player One", "9780307887443", "Ernest Cline", "2011", "Crown Publishers", categories.get(1), 1);
                Book book8 = new Book("The Martian", "9780804139021", "Andy Weir", "2011", "Crown Publishers", categories.get(1), 2);
                Book book9 = new Book("Red Rising", "9780345539786", "Pierce Brown", "2014", "Del Rey Books", categories.get(1), 5);
                Book book10 = new Book("Leviathan Wakes", "9780316129084", "James S.A. Corey", "2011", "Orbit Books", categories.get(1), 2);
                
                books.add(book1);
                books.add(book2);
                books.add(book3);
                books.add(book4);
                books.add(book5);
                books.add(book6);
                books.add(book7);
                books.add(book8);
                books.add(book9);
                books.add(book10);

                categories.get(0).addBookToCategory(book1);
                categories.get(0).addBookToCategory(book2);
                categories.get(0).addBookToCategory(book3);
                categories.get(1).addBookToCategory(book4);
                categories.get(0).addBookToCategory(book5);
                categories.get(0).addBookToCategory(book6);
                categories.get(1).addBookToCategory(book7);
                categories.get(1).addBookToCategory(book8);
                categories.get(1).addBookToCategory(book9);
                categories.get(1).addBookToCategory(book10);
            }
            else{
                books =  FXCollections.observableArrayList(temp2);
            }

            objectIn.close();
            fileIn.close();
            
        }  catch(Exception e){
            e.printStackTrace();

            books = FXCollections.observableArrayList();
            Book book1 = new Book("The Hunger Games", "9780439023481", "Suzanne Collins", "2008", "Scholastic Press", categories.get(0), 1);
            Book book2 = new Book("Harry Potter and the Sorcerer's Stone", "9780590353427", "J.K. Rowling", "1997", "Scholastic", categories.get(0), 4);
            Book book3 = new Book("Eragon", "9780375826696", "Christopher Paolini", "2002", "Knopf Books for Young Readers", categories.get(0), 2);
            Book book4 = new Book("Dune", "9780441172719", "Frank Herbert", "1965", "Ace Books", categories.get(1), 3);
            Book book5 = new Book("Mistborn: The Final Empire", "9780765311788", "Brandon Sanderson", "2006", "Tor Books", categories.get(0), 1);
            Book book6 = new Book("The Name of the Wind", "9780756404741", "Patrick Rothfuss", "2007", "DAW Books", categories.get(0), 1);
            Book book7 = new Book("Ready Player One", "9780307887443", "Ernest Cline", "2011", "Crown Publishers", categories.get(1), 1);
            Book book8 = new Book("The Martian", "9780804139021", "Andy Weir", "2011", "Crown Publishers", categories.get(1), 2);
            Book book9 = new Book("Red Rising", "9780345539786", "Pierce Brown", "2014", "Del Rey Books", categories.get(1), 5);
            Book book10 = new Book("Leviathan Wakes", "9780316129084", "James S.A. Corey", "2011", "Orbit Books", categories.get(1), 2);
            
            books.add(book1);
            books.add(book2);
            books.add(book3);
            books.add(book4);
            books.add(book5);
            books.add(book6);
            books.add(book7);
            books.add(book8);
            books.add(book9);
            books.add(book10);

            categories.get(0).addBookToCategory(book1);
            categories.get(0).addBookToCategory(book2);
            categories.get(0).addBookToCategory(book3);
            categories.get(1).addBookToCategory(book4);
            categories.get(0).addBookToCategory(book5);
            categories.get(0).addBookToCategory(book6);
            categories.get(1).addBookToCategory(book7);
            categories.get(1).addBookToCategory(book8);
            categories.get(1).addBookToCategory(book9);
            categories.get(1).addBookToCategory(book10);
        }


        try{
            String filename = "Borrows.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<Borrow> temp2 = (List<Borrow>) objectIn.readObject();

            if(temp2 == null){
                borrows = FXCollections.observableArrayList();
            }
            else{
                borrows = FXCollections.observableArrayList(temp2);
            }

            objectIn.close();
            fileIn.close();
            
        } catch(Exception e){
            e.printStackTrace();
            borrows = FXCollections.observableArrayList();
        }
    }

    public Book getCurrentBook() {
        return currentBook;
    }

    public Category getCurrentcategory() {
        return currentcategory;
    }

    public void setCurrentcategory(Category currentcategory) {
        this.currentcategory = currentcategory;
    }

    public ObservableList<Borrow> getBorrowed_store() {
        return this.borrowed_store;
    }

    public Client getClient() {
        return client;
    }

    public void setupClient(Client client){
        this.client = null;
        this.client = client;
        if(borrowed_store == null){
            borrowed_store = FXCollections.observableArrayList();
        }
        else{
            borrowed_store.clear();
        }
        for(Borrow borrow : borrows){
           if(borrow.getClient().getEmail().equals(client.getEmail())){
                borrowed_store.add(borrow);
           }
        }
    }

    public void setCurrentBook(Book currentBook) {
        this.currentBook = currentBook;
    }

    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory(){
        return viewFactory;
    }


    public void setupAdmin(Admin admin){
        this.admin = admin;
    }


    private static void cleanup(){
        String folderName = "medialab";
    
        Path folderPath = Paths.get(System.getProperty("user.dir"), folderName);
    
        try{
            String filename = "Users.ser";
            Path filePath = folderPath.resolve(filename);
            FileOutputStream fileout = new FileOutputStream(filePath.toFile());
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            List<Client> temp3 = new ArrayList<>(Model.getInstance().users);
            out.writeObject(temp3);
            out.close();
            fileout.close();
            System.out.println("SERIALIZED USERS");
        } catch(IOException e){
            e.printStackTrace();
        }

        try{
            String filename = "Categories.ser";
            Path filePath = folderPath.resolve(filename);
            FileOutputStream fileout = new FileOutputStream(filePath.toFile());
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            List<Category> temp3 = new ArrayList<>(Model.getInstance().categories);
            out.writeObject(temp3);
            out.close();
            fileout.close();
            System.out.println("SERIALIZED Categories");
        } catch(IOException e){
            e.printStackTrace();
        }


        try{
            String filename = "Borrows.ser";
            Path filePath = folderPath.resolve(filename);
            FileOutputStream fileout = new FileOutputStream(filePath.toFile());
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            List<Borrow> temp3 = new ArrayList<>(Model.getInstance().borrows);
            out.writeObject(temp3);
            out.close();
            fileout.close();
            System.out.println("SERIALIZED Borrows");
        } catch(IOException e){
            e.printStackTrace();
        }

        try{
            String filename = "Admins.ser";
            Path filePath = folderPath.resolve(filename);
            FileOutputStream fileout = new FileOutputStream(filePath.toFile());
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            List<Admin> temp3 = new ArrayList<>(Model.getInstance().admins);
            out.writeObject(temp3);
            out.close();
            fileout.close();
            System.out.println("SERIALIZED Admins");
        } catch(IOException e){
            e.printStackTrace();
        }

        try{
            String filename = "Books.ser";
            Path filePath = folderPath.resolve(filename);
            FileOutputStream fileout = new FileOutputStream(filePath.toFile());
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            List<Book> temp3 = new ArrayList<>(Model.getInstance().books);
            out.writeObject(temp3);
            out.close();
            fileout.close();
            System.out.println("SERIALIZED Books");
        } catch(IOException e){
            e.printStackTrace();
        }


        // try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("medialab/Books.ser"))){
        //     oos.writeObject(Model.getInstance().books);
        // } catch(Exception e){
        //     e.printStackTrace();
        // }
        // try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("medialab/Users.ser"))){
        //     oos.writeObject(Model.getInstance().users);
        // } catch(Exception e){
        //     e.printStackTrace();
        // }
        // try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("medialab/Borrows.ser"))){
        //     oos.writeObject(Model.getInstance().borrows);
        // } catch(Exception e){
        //     e.printStackTrace();
        // }
        // try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("medialab/Categories.ser"))){
        //     oos.writeObject(Model.getInstance().categories);
        // } catch(Exception e){
        //     e.printStackTrace();
        // }
    }
}
