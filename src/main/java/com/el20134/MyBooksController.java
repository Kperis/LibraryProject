package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class MyBooksController implements Initializable{
    @FXML
    public ListView<Borrow> borrowed_list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        borrowed_list.setItems(Model.getInstance().getBorrowed_store());
        borrowed_list.setCellFactory(new BorrowedCellFactory());

    }
}