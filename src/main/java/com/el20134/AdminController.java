package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdminController implements Initializable{
    @FXML
    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Model.getInstance().getViewFactory().getAdminSelectedMenu().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal){
                case "Books": 
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getBooksView());
                    break;
                case "Users":
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getUsersView());
                    break;
                case "Categories":
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getCategoriesView());
                    break;
                case "Borrows":
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getBorrowsView());
                    break;
                case "Logout":
                    Stage stage = (Stage) admin_parent.getScene().getWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                    Model.getInstance().getViewFactory().showLoginWindow();
                    break;
                default:
                    admin_parent.setCenter(Model.getInstance().getViewFactory().getBooksView());
                    break;
            }
        });
    }
}
