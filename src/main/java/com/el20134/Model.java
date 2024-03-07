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
        // Admin temp = new Admin("medialab", "medialab_2024");
        
        String folderName = "medialab";
        
        
        Path folderPath = Paths.get(System.getProperty("user.dir"), folderName);
        
        try{
            
            String filename = "Users.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            users = (List<Client>) objectIn.readObject();
            
            if(users == null){
                users = new ArrayList<>();
                System.out.println("EMPTY");
            }
           

            objectIn.close();
            fileIn.close();

        } catch(Exception e){
            e.printStackTrace();
        }


        try{

            String filename = "Admins.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            admins = (List<Admin>) objectIn.readObject();

            if(admins == null){
                admins = new ArrayList<>();
            }

            objectIn.close();
            fileIn.close();

        }  catch(Exception e){
            e.printStackTrace();
        }

        // admins.add(temp);
        try{

            String filename = "Categories.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            categories = (List<Category>) objectIn.readObject();

            if(categories == null){
                categories = new ArrayList<>();
            }

            objectIn.close();
            fileIn.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }


        try{

            String filename = "Books.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            books = (List<Book>) objectIn.readObject();

            if(books == null){
                books = new ArrayList<>();
            }

            objectIn.close();
            fileIn.close();
            
        }  catch(Exception e){
            e.printStackTrace();
        }


        try{
            String filename = "Borrows.ser";
            Path filePath = folderPath.resolve(filename);
            FileInputStream fileIn = new FileInputStream(filePath.toFile());

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            borrows = (List<Book>) objectIn.readObject();

            if(borrows == null){
                borrows = new ArrayList<>();
            }

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
        String folderName = "medialab";
    
        Path folderPath = Paths.get(System.getProperty("user.dir"), folderName);
    
        try{
            String filename = "Users.ser";
            Path filePath = folderPath.resolve(filename);
            FileOutputStream fileout = new FileOutputStream(filePath.toFile());
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(Model.getInstance().users);
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
            out.writeObject(Model.getInstance().categories);
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
            out.writeObject(Model.getInstance().borrows);
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
            out.writeObject(Model.getInstance().admins);
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
            out.writeObject(Model.getInstance().books);
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
