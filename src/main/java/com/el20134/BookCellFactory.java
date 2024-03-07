package com.el20134;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class BookCellFactory extends ListCell<Book>{

    @Override
    protected void updateItem(Book book, boolean empty) {
        super.updateItem(book, empty);
        if(empty){
            setText(null);
            setGraphic(null);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Book.fxml"));
            BookCellController controller = new BookCellController(book);
            loader.setController(controller);
            setText(null);
            try{
                setGraphic(loader.load());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
