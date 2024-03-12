package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;


public class CategoriesListController implements Initializable{

    public ListView<Category> categories_list;
    public Button add_category_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categories_list.setItems(Model.getInstance().categories);
        categories_list.setCellFactory(new CategoryCellFactory());
        add_category_btn.setOnAction(event -> Model.getInstance().getViewFactory().onAddCategory());
    }

}
