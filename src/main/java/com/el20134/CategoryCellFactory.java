package com.el20134;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class CategoryCellFactory implements Callback<ListView<Category>, ListCell<Category>> {
    @Override
    public ListCell<Category> call(ListView<Category> param){
        return new ListCell<>(){
            @Override
            public void updateItem(Category category, boolean empty) {
                super.updateItem(category, empty);
                if(empty){
                    setText(null);
                    setGraphic(null);
                }
                else{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("CategoryCell.fxml"));
                    CategoryCellController controller = new CategoryCellController(category);
                    loader.setController(controller);
                    setText(null);
                    try{
                        setGraphic(loader.load());
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };

    }
}
