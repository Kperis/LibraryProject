package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ClientMenuController implements Initializable{
    public Button home_btn;
    public Button mybooks_btn;
    public Button profile_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        addListeners();
    }

    private void addListeners(){
        home_btn.setOnAction(event -> onHome());
        mybooks_btn.setOnAction(event -> onMyBooks());
        profile_btn.setOnAction(event -> onProfile());
    }

    private void onHome(){
        Model.getInstance().getViewFactory().getClientSelectedMenu().set("Home");
    }

    private void onMyBooks(){
        Model.getInstance().getViewFactory().getClientSelectedMenu().set("MyBooks");
    }

    private void onProfile(){
        Model.getInstance().getViewFactory().getClientSelectedMenu().set("Profile");
    }
}
