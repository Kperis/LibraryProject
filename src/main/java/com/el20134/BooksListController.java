package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;



public class BooksListController implements Initializable{
    @FXML
    public ListView<Book> books_list;
    
    @FXML
    public Button add_book_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        books_list.setItems(Model.getInstance().books);
        books_list.setCellFactory(new BookCellFactory());
        
        add_book_btn.setOnAction(event -> Model.getInstance().getViewFactory().onAddBook());
    }

    
}
