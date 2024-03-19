package com.el20134;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class CommentCellFactory implements Callback<ListView<Comment>, ListCell<Comment>> {
    @Override
    public ListCell<Comment> call(ListView<Comment> param){
        return new ListCell<>(){
            @Override
            public void updateItem(Comment comment, boolean empty) {
                super.updateItem(comment, empty);
                if(empty){
                    setText(null);
                    setGraphic(null);
                }
                else{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("CommentCell.fxml"));
                    CommentCellController controller = new CommentCellController(comment);
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