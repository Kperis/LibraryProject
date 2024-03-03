package com.el20134;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.el20134.ViewFactory;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private Client client;
    public List<Client> users;
    public List<Admin> admins;
    public List<Book> books;
    public List<Category> categories;
    public List<Book> borrows;

    private Model(){
        this.viewFactory = new ViewFactory();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            cleanup();
        }));


        this.client = new Client("","","","","","");
        try{
            FileInputStream fileIn = new FileInputStream("medialab/Users.ser");

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            users = (List<Client>) objectIn.readObject();

            objectIn.close();
            fileIn.close();

        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            FileInputStream fileIn = new FileInputStream("medialab/Admins.ser");

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            admins = (List<Admin>) objectIn.readObject();

            objectIn.close();
            fileIn.close();

        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            FileInputStream fileIn = new FileInputStream("medialab/Categories.ser");

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            categories = (List<Category>) objectIn.readObject();

            objectIn.close();
            fileIn.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            FileInputStream fileIn = new FileInputStream("medialab/Books.ser");

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            books = (List<Book>) objectIn.readObject();

            objectIn.close();
            fileIn.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            FileInputStream fileIn = new FileInputStream("medialab/Borrows.ser");

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            borrows = (List<Book>) objectIn.readObject();

            objectIn.close();
            fileIn.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
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

    private static void cleanup(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("medialab/Books.ser"))){
            oos.writeObject(Model.getInstance().books);
        } catch(Exception e){
            e.printStackTrace();
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("medialab/Users.ser"))){
            oos.writeObject(Model.getInstance().users);
        } catch(Exception e){
            e.printStackTrace();
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("medialab/Borrows.ser"))){
            oos.writeObject(Model.getInstance().borrows);
        } catch(Exception e){
            e.printStackTrace();
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("medialab/Categories.ser"))){
            oos.writeObject(Model.getInstance().categories);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
