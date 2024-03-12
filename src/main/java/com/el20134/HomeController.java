package com.el20134;

import java.util.ResourceBundle;
import java.net.URL;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HomeController implements Initializable {
    public ListView<Book> books_listview;
    public TextField title_fld;
    public TextField author_fld;
    public TextField publication_fld;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        books_listview.setItems(Model.getInstance().books);
    }
}
