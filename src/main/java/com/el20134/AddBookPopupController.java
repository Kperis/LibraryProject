package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddBookPopupController implements Initializable{

    public TextField title_fld;
    public TextField author_fld;
    public TextField isbn_fld;
    public TextField publisher_fld;
    public TextField publication_year_fld;
    public TextField copies_fld;
    public ChoiceBox<String> category_fld;
    public Button confirm_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        confirm_btn.setOnAction(event -> addBook());
        ObservableList<String> titles = FXCollections.observableArrayList();
        for(Category cat : Model.getInstance().categories){
            titles.add(cat.getName());
        }
        category_fld.setItems(FXCollections.observableArrayList(titles));
    }

    private void addBook(){
        if(title_fld.getText().trim().isEmpty() || author_fld.getText().trim().isEmpty() || isbn_fld.getText().trim().isEmpty() || publisher_fld.getText().trim().isEmpty() || publication_year_fld.getText().trim().isEmpty() || copies_fld.getText().trim().isEmpty()){
            error_lbl.setText("Fill Everything");
        }
        else{
            Category category;
            for(Category cat : Model.getInstance().categories){
                if(cat.getName().trim().toLowerCase().equals(category_fld.getValue().trim().toLowerCase())){
                    category = cat;
                    Book book = new Book(title_fld.getText().trim(), isbn_fld.getText().trim(), author_fld.getText().trim(), publication_year_fld.getText().trim(), publisher_fld.getText().trim(), category , Integer.parseInt(copies_fld.getText().trim()));
                    Model.getInstance().books.add(book);
                    Model.getInstance().getViewFactory().hidePopup();
                }
            }
        }
    }
}
