package com.el20134;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    //Client Views
    private AnchorPane homeView;
    
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

    public void closeStage(Stage stage){
        stage.close();
    }
}
