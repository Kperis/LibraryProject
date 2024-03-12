package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CategoryCellController implements Initializable{

    public Label name_lbl;
    public Button del_btn;
    public Button edit_btn;

    private Category category;

    public CategoryCellController(Category category){
        this.category = category;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name_lbl.setText(category.getName());
    }
}
