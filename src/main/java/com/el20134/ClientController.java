package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class ClientController implements Initializable{
    
    public BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Model.getInstance().getViewFactory().getClientSelectedMenu().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal){
                case "MyBooks" : 
                    client_parent.setCenter(Model.getInstance().getViewFactory().getMyBooksView());
                    break;
                case "Profile" :
                    client_parent.setCenter(Model.getInstance().getViewFactory().getProfileView());
                    break;
                default:
                    client_parent.setCenter(Model.getInstance().getViewFactory().getHomeView());
                    break;
            }
        });
    }
}
