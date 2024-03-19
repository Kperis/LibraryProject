package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CategoryCellController implements Initializable{
    @FXML
    public Label name_lbl;
    
    @FXML
    public Button del_btn;
    
    @FXML
    public Button edit_btn;

    private Category category;

    public CategoryCellController(Category category){
        this.category = category;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name_lbl.setText(category.getName());
        edit_btn.setOnAction(event -> onEdit());
        del_btn.setOnAction(event -> onDeleteCategory());
    }

    private void onEdit(){
        Model.getInstance().onEdit = true;
        Model.getInstance().setCurrentcategory(category);
        Model.getInstance().getViewFactory().onAddCategory();

    }
    
    private void onDeleteCategory(){
        category.removeCategory();
    }
}
