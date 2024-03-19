package com.el20134;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AdminBorrowsCellController implements Initializable{
    
    @FXML
    public Label title_lbl;

    @FXML
    public Label user_lbl;

    @FXML
    public Button return_btn;

    @FXML 
    private Label warning_lbl;

    private Borrow borrow;

    public AdminBorrowsCellController(Borrow borrow){
        this.borrow = borrow;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        title_lbl.setText(this.borrow.getBook().getTitle());
        user_lbl.setText(this.borrow.getClient().getFirstName() + " " + this.borrow.getClient().getLastName());
        if(ChronoUnit.DAYS.between(borrow.getDate(), LocalDate.now()) > 5){
            warning_lbl.setText("DELAYED");
        }
        else{
            warning_lbl.setText("");
        }
        return_btn.setOnAction(event -> onReturn());
    }

    private void onReturn(){
        this.borrow.getBook().setCopies(this.borrow.getBook().getCopies() + 1);
        this.borrow.getClient().borrowed.remove(this.borrow.getBook());
        for(Book book : this.borrow.getClient().borrowed){
            System.out.println(book.getTitle());
        }
        Model.getInstance().borrows.remove(this.borrow);
    }
}
