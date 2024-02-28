package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AdminMenuController implements Initializable {
    public Button users_btn;
    public Button categories_btn;
    public Button borrows_btn;
    public Button logout_btn;
    public Button books_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        addListeners();
    }

    private void addListeners(){
        users_btn.setOnAction(event -> onUsersList());
        categories_btn.setOnAction(event -> onCategories());
        borrows_btn.setOnAction(event -> onBorrows());
        books_btn.setOnAction(event -> onBooks());
    }

    private void onBooks(){
        Model.getInstance().getViewFactory().getAdminSelectedMenu().set("Books");
    }

    private void onCategories(){
        Model.getInstance().getViewFactory().getAdminSelectedMenu().set("Categories");
    }

    private void onUsersList(){
        Model.getInstance().getViewFactory().getAdminSelectedMenu().set("UsersList");
    }

    private void onBorrows(){
        Model.getInstance().getViewFactory().getAdminSelectedMenu().set("Borrows");
    }
}
