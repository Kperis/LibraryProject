package com.el20134;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class ClientCellFactory implements Callback<ListView<Client>, ListCell<Client>> {
    @Override
    public ListCell<Client> call(ListView<Client> param){
        return new ListCell<>(){
            @Override
            public void updateItem(Client user, boolean empty) {
                super.updateItem(user, empty);
                if(empty){
                    setText(null);
                    setGraphic(null);
                }
                else{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientCell.fxml"));
                    ClientCellController controller = new ClientCellController(user);
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
