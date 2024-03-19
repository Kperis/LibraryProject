package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class AddBookPopupController implements Initializable{
    @FXML
    public TextField title_fld;
    
    @FXML
    public TextField author_fld;
    
    @FXML
    public TextField isbn_fld;
    
    @FXML
    public TextField publisher_fld;
    
    @FXML
    public TextField publication_year_fld;
    
    @FXML
    public TextField copies_fld;
    
    @FXML
    public ChoiceBox<String> category_fld;
    
    @FXML
    public Button confirm_btn;
    
    @FXML
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
                    if(Model.getInstance().onEdit){
                        Book book = Model.getInstance().getCurrentBook();
                        book.getCategory().getBooks().remove(book);
                        book.setAuthor(author_fld.getText().trim());
                        book.setTitle(title_fld.getText().trim());
                        book.setIsbn(isbn_fld.getText().trim());
                        book.setPublication_year(publication_year_fld.getText().trim());
                        book.setPublisher(publisher_fld.getText().trim());
                        book.setCopies(Integer.parseInt(copies_fld.getText().trim()));
                        book.setCategory(category);
                        category.addBookToCategory(book);
                        Model.getInstance().onEdit = false;
                        Model.getInstance().getViewFactory().hidePopup();
                    }
                    else{
                        Book book = new Book(title_fld.getText().trim(), isbn_fld.getText().trim(), author_fld.getText().trim(), publication_year_fld.getText().trim(), publisher_fld.getText().trim(), category , Integer.parseInt(copies_fld.getText().trim()));
                        Model.getInstance().books.add(book);
                        category.addBookToCategory(book);
                        Model.getInstance().getViewFactory().hidePopup();
                    }
                }
            }
        }
        Model.getInstance().onEdit = false;
    }
}
