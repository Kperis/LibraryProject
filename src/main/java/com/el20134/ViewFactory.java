package com.el20134;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {

    private AccountType loginAccountType;
    //Client Views
    private final StringProperty clientSelectedMenuItem;
    private AnchorPane homeView;
    private AnchorPane myBooksView;
    private AnchorPane profileView;

    //AdminViews

    private final StringProperty adminSelectedMenuItem;
    private AnchorPane booksView;
    private AnchorPane usersView;
    private AnchorPane categoriesView;
    private AnchorPane borrowsView;


    private void createStage(FXMLLoader loader){
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        } catch(Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("LibNtua");
        stage.show();
    }

    public ViewFactory(){
        this.loginAccountType = AccountType.CLIENT;
        this.clientSelectedMenuItem = new SimpleStringProperty("");
        this.adminSelectedMenuItem = new SimpleStringProperty("");
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public StringProperty getClientSelectedMenu(){
        return clientSelectedMenuItem;
    }

    public StringProperty getAdminSelectedMenu(){
        return adminSelectedMenuItem;
    }

    public AnchorPane getHomeView(){
        if(homeView == null){
            try{
                homeView = new FXMLLoader(getClass().getResource("Home.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return homeView;
    }

    public AnchorPane getMyBooksView(){
        if(myBooksView == null){
            try{
                myBooksView = new FXMLLoader(getClass().getResource("MyBooks.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return myBooksView;
    }

    public AnchorPane getProfileView(){
        if(profileView == null){
            try{
                profileView = new FXMLLoader(getClass().getResource("Profile.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return profileView;
    }


    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        createStage(loader);
    }

    public void showClientWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }

    public void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
        AdminController controller = new AdminController();
        loader.setController(controller);
        createStage(loader);
    }

    public AnchorPane getBooksView(){
        if(booksView == null){
            try{
                booksView = new FXMLLoader(getClass().getResource("Books.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return booksView;
    }

    public AnchorPane getUsersView(){
        if(usersView == null){
            try{
                usersView = new FXMLLoader(getClass().getResource("UserList.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return usersView;
    }

    public AnchorPane getBorrowsView(){
        if(borrowsView == null){
            try{
                borrowsView = new FXMLLoader(getClass().getResource("Borrows.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return borrowsView;
    }

    public AnchorPane getCategoriesView(){
        if(categoriesView == null){
            try{
                categoriesView = new FXMLLoader(getClass().getResource("Categories.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return categoriesView;
    }

    public void closeStage(Stage stage){
        stage.close();
    }
}
