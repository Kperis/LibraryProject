package com.el20134;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class AdminBorrowsCellFactory implements Callback<ListView<Borrow>, ListCell<Borrow>> {
    @Override
    public ListCell<Borrow> call(ListView<Borrow> param){
        return new ListCell<>(){
        @Override
        public void updateItem(Borrow borrow, boolean empty) {
            super.updateItem(borrow, empty);
            if(empty){
                setText(null);
                setGraphic(null);
            }
            else{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BorrowCell.fxml"));
                AdminBorrowsCellController controller = new AdminBorrowsCellController(borrow);
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