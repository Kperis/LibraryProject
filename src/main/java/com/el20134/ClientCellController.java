package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ClientCellController implements Initializable{
    
    @FXML
    public Label first_name_lbl;
    
    @FXML
    public Label last_name_lbl;
    
    @FXML
    public Label email_lbl;
    
    @FXML
    public Label adt_lbl;
    
    @FXML
    public Label username_lbl;
    
    @FXML
    public Button del_btn;

    private final Client client;

    public ClientCellController(Client client){
        this.client = client;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        first_name_lbl.setText(client.getFirstName());
        last_name_lbl.setText(client.getLastName());
        email_lbl.setText(client.getEmail());
        adt_lbl.setText(client.getAdt());
        username_lbl.setText(client.getUsername());
        del_btn.setOnAction(event -> onDeleteUser());
    }

    private void onDeleteUser(){
        for(Book book : client.borrowed){
            book.setCopies(book.getCopies() + 1);
            for(Borrow b : Model.getInstance().borrows){
                if(b.getClient().getEmail().equals(client.getEmail())){
                    Model.getInstance().borrows.remove(b);
                }
            }
        }
        Model.getInstance().users.remove(client);
    }
}
