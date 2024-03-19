package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BorrowedCellController implements Initializable{
    @FXML
    private Label date_lbl;

    @FXML
    private Label isbn_lbl;

    @FXML
    private Label return_date_lbl;

    @FXML
    private Label title_lbl;

    private Borrow borrow;

    public BorrowedCellController(Borrow borrow){
        this.borrow = borrow;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        title_lbl.setText(borrow.getBook().getTitle());
        isbn_lbl.setText(borrow.getBook().getIsbn());
        // for(Borrow borrow2 : Model.getInstance().borrows){
            
        // }
        date_lbl.setText(borrow.getDate().toString());
        return_date_lbl.setText(borrow.getDate().plusDays(5).toString());
    }

}
