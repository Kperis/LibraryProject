package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientController implements Initializable{
    @FXML
    public BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Model.getInstance().getViewFactory().getClientSelectedMenu().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal){
                case "Home":
                    client_parent.setCenter(Model.getInstance().getViewFactory().getHomeView());
                    break;
                case "BookPage":
                    client_parent.setCenter(Model.getInstance().getViewFactory().getBookPageView());
                    break;
                case "MyBooks" : 
                    client_parent.setCenter(Model.getInstance().getViewFactory().getMyBooksView());
                    break;
                case "Profile" :
                    client_parent.setCenter(Model.getInstance().getViewFactory().getProfileView());
                    break;
                case "Logout":
                    Stage stage = (Stage) client_parent.getScene().getWindow();
                    Model.getInstance().getViewFactory().showLoginWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                    break;
                default:
                    client_parent.setCenter(Model.getInstance().getViewFactory().getHomeView());
                    break;
            }
        });
    }

}
