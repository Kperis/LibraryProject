package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ClientCellController implements Initializable{
    public Label first_name_lbl;
    public Label last_name_lbl;
    public Label email_lbl;
    public Label adt_lbl;
    public Label username_fld;
    public Button del_btn;

    private final Client client;

    public ClientCellController(Client client){
        this.client = client;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }
}
