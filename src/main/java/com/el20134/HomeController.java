package com.el20134;

import java.util.ResourceBundle;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HomeController implements Initializable {
    @FXML
    public ListView<Book> books_listview;

    @FXML
    public TextField title_fld;

    @FXML
    public TextField author_fld;

    @FXML
    public TextField publication_fld;
    
    // private ObservableList<Book> filteredList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        title_fld.setPromptText("Search by title");
        author_fld.setPromptText("Search by author");
        publication_fld.setPromptText("Search by publication year");
        books_listview.setItems(Model.getInstance().books);
        books_listview.setCellFactory(new BookCellFactory());

        title_fld.textProperty().addListener((observable, oldValue, newValue) -> {
            filterBooks(newValue, author_fld.getText(), publication_fld.getText());
        });

        author_fld.textProperty().addListener((observable, oldValue, newValue) -> {
            filterBooks(title_fld.getText(), newValue, publication_fld.getText());
        });

        publication_fld.textProperty().addListener((observable, oldValue, newValue) -> {
            filterBooks(title_fld.getText(), author_fld.getText(), newValue);
        });

        books_listview.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && !books_listview.getSelectionModel().isEmpty()) {
                Book selectedItem = books_listview.getSelectionModel().getSelectedItem();
                Model.getInstance().setCurrentBook(selectedItem);
                Model.getInstance().getViewFactory().getClientSelectedMenu().set("BookPage");
            }
        });
    }

    private void filterBooks(String title, String author, String publish){
        ObservableList<Book> filteredList = FXCollections.observableArrayList();
        for (Book book : Model.getInstance().books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())
                    && book.getAuthor().toLowerCase().contains(author.toLowerCase()) && book.getPublication_year().toLowerCase().contains(publish.toLowerCase())) {
                filteredList.add(book);
            }
        }
        books_listview.setItems(filteredList);
    }

}
