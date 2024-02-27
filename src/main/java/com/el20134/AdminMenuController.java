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
}
