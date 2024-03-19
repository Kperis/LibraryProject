package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class UsersListController implements Initializable{
    
    @FXML
    public ListView<Client> users_list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        users_list.setItems(Model.getInstance().users);
        users_list.setCellFactory(new ClientCellFactory());
    }
}
