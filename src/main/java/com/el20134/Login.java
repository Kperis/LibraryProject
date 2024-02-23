package com.el20134;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Login {
    
    @FXML
    public ChoiceBox acc_selector;
    
    public TextField username_fld;
    
    public TextField password_fld;
    public Label error_lbl;
    
    public Button login_btn;
    public void initialize() {
        // TODO
    }  
}

