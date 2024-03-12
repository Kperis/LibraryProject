package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCategoryPopupController implements Initializable{
    public TextField name_fld;
    public Button confirm_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        confirm_btn.setOnAction(event -> addCategory());
        error_lbl.setText("");
    }

    private void addCategory(){
        if(name_fld.getText().trim().isEmpty()){
            error_lbl.setText("Fill Everything");
        }
        else{
            boolean temp = false;
            for(Category category : Model.getInstance().categories){
                if(category.getName().trim().toLowerCase().equals(name_fld.getText().trim().toLowerCase())){
                    temp = true;
                }
            }
            if(temp){
                error_lbl.setText("Category already exists");
            }
            else{
                Category category = new Category(name_fld.getText().trim());
                Model.getInstance().categories.add(category);
                Model.getInstance().getViewFactory().hidePopup();
            }
        }
    }
}
