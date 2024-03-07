package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BookCellController implements Initializable{
    public Label title_lbl;
    public Label author_lbl;
    public Label isbn_lbl;
    public Label rating_lbl;
    public Label rating_count_lbl;
    public Button delete_btn;

    private final Book book;

    public BookCellController(Book book){
        this.book = book;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

}
