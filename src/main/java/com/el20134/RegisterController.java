package com.el20134;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class RegisterController implements Initializable{
    public TextField first_name_fld;
    public TextField last_name_fld;
    public TextField username_fld;
    public TextField password_fld;
    public TextField adt_fld;
    public TextField email_fld;
    public Button register_btn;
    public Label error_lbl;
    public Button tologin_btn;
    private boolean allowRegistration;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        allowRegistration = true;
        register_btn.setOnAction(event -> onRegister());
        tologin_btn.setOnAction(event -> ontoLogin());
    }

    private void ontoLogin(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

    private void onRegister(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        allowRegistration = true;
        if(first_name_fld.getText().trim().isEmpty() || last_name_fld.getText().trim().isEmpty() || username_fld.getText().trim().isEmpty() || password_fld.getText().trim().isEmpty() || adt_fld.getText().trim().isEmpty() || email_fld.getText().trim().isEmpty()){
            error_lbl.setText("Fill everything!");
            first_name_fld.setText("");
            last_name_fld.setText("");
            username_fld.setText("");
            password_fld.setText("");
            adt_fld.setText("");
            email_fld.setText("");
            allowRegistration = false;
        }
        else{
            if(Model.getInstance().users != null){
                for(Client client : Model.getInstance().users){
                    
                    if(client.getAdt().toLowerCase().equals(adt_fld.getText().trim().toLowerCase())){
                        error_lbl.setText("adt already in use");
                        allowRegistration = false;
                    }
                    else if(client.getEmail().toLowerCase().equals(email_fld.getText().trim().toLowerCase())){
                        error_lbl.setText("email already in use");
                        allowRegistration = false;
                    }
                }
                if(allowRegistration){
                    Client client = new Client(username_fld.getText().trim(), password_fld.getText().trim(), first_name_fld.getText().trim(), last_name_fld.getText().trim(), email_fld.getText().trim(), adt_fld.getText().trim());
                    Model.getInstance().users.add(client);
                    Model.getInstance().getViewFactory().showLoginWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                }
            }
            else{
                Client client = new Client(username_fld.getText().trim(), password_fld.getText().trim(), first_name_fld.getText().trim(), last_name_fld.getText().trim(), email_fld.getText().trim(), adt_fld.getText().trim());
                Model.getInstance().users.add(client);
                Model.getInstance().getViewFactory().showLoginWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            }
        }
    }
}