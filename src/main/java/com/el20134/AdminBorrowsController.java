package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AdminBorrowsController implements Initializable{
    
    @FXML
    public ListView<Borrow> borrows_list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        borrows_list.setItems(Model.getInstance().borrows);
        borrows_list.setCellFactory(new AdminBorrowsCellFactory());
    }
}
