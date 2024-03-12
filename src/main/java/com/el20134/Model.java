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
    public ObservableList<Book> borrows;

    private Model(){
        this.viewFactory = new ViewFactory();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            cleanup();
        }));

        this.client = new Client("","","","","","");
        Admin temp = new Admin("medialab", "medialab_2024");
        
        String folderName = "medialab";
        
        
        Path folderPath = Paths.get(System.getProperty("user.dir"), folderName);
        
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
            }
            else{
                categories = FXCollections.observableArrayList(temp2);
            }

            objectIn.close();
            fileIn.close();
            
        } catch(Exception e){
            e.printStackTrace();
            categories = FXCollections.observableArrayList();
        }


        try{

            String filename = "Books.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<Book> temp2 = (List<Book>) objectIn.readObject();

            if(temp2 == null){
                books = FXCollections.observableArrayList();
            }
            else{
                books =  FXCollections.observableArrayList(temp2);
            }

            objectIn.close();
            fileIn.close();
            
        }  catch(Exception e){
            e.printStackTrace();
            books = FXCollections.observableArrayList();
        }


        try{
            String filename = "Borrows.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<Book> temp2 = (List<Book>) objectIn.readObject();

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

    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory(){
        return viewFactory;
    }

    public void setupClient(Client client){
        this.client = client;
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
            List<Book> temp3 = new ArrayList<>(Model.getInstance().borrows);
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
