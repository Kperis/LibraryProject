package com.el20134;

import java.util.ResourceBundle;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable {
    
    public ChoiceBox<AccountType> acc_selector;
    
    public TextField username_fld;
    
    public TextField password_fld;
    public Label error_lbl;

    
    public Button login_btn;
    public Button register_now_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue()));
        login_btn.setOnAction(event -> onLogin());
        register_now_btn.setOnAction(event -> ontoRegistration());
    }

    private void onLogin(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        if(Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT){
            for(Client user : Model.getInstance().users){
                if(user.getUsername().equals(username_fld.getText().trim()) && user.getPassword().equals(password_fld.getText().trim())){
                    Model.getInstance().setupClient(user);
                    Model.getInstance().getViewFactory().showClientWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                    break;
                }
            } 
            username_fld.setText("");
            password_fld.setText("");
            error_lbl.setText("Invalid username/password");     
        }
        else{
            for(Admin admin : Model.getInstance().admins){
                if(admin.getUsername().equals(username_fld.getText().trim()) && admin.getPassword().equals(password_fld.getText().trim())){
                    Model.getInstance().setupAdmin(admin);
                    Model.getInstance().getViewFactory().showAdminWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                    break;
                }
            }
            username_fld.setText("");
            password_fld.setText("");
            error_lbl.setText("Invalid username/password");
        }
    }

    private void ontoRegistration(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().showRegisterWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}

