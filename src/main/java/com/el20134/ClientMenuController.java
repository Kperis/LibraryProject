package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ClientMenuController implements Initializable{
    @FXML
    public Button home_btn;
    
    @FXML
    public Button mybooks_btn;
    
    @FXML
    public Button profile_btn;
    
    @FXML
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        addListeners();
    }

    private void addListeners(){
        home_btn.setOnAction(event -> onHome());
        mybooks_btn.setOnAction(event -> onMyBooks());
        profile_btn.setOnAction(event -> onProfile());
        logout_btn.setOnAction(event -> onLogout());
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

    private void onLogout(){
        Model.getInstance().getViewFactory().getClientSelectedMenu().set("Logout");
    }
}
