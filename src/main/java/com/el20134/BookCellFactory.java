package com.el20134;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class BookCellFactory implements Callback<ListView<Book>, ListCell<Book>> {
    @Override
    public ListCell<Book> call(ListView<Book> param){
        return new ListCell<>(){
        @Override
        public void updateItem(Book book, boolean empty) {
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
    };
}
}
