package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class BookPageController implements Initializable{

    @FXML
    private Label author_lbl;

    @FXML
    private Label category_lbl;

    @FXML
    private ListView<Comment> comments_list;

    @FXML
    private Label copies_lbl;

    @FXML
    private Label isbn_lbl;

    @FXML
    private Label publication_year_lbl;

    @FXML
    private Label publisher_lbl;

    @FXML
    private Label rating_lbl;

    @FXML
    private Label title_lbl;

    @FXML
    private Label voters_lbl;

    @FXML
    private Button comment_btn;

    @FXML
    private TextField comment_fld;

    @FXML
    private Label error_lbl;

    @FXML
    private Button rate_btn;

    @FXML
    private ToggleGroup rating;

    private ObservableList<Comment> comments_obs;

    private Book book;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.book = Model.getInstance().getCurrentBook();
        this.title_lbl.setText(book.getTitle());
        this.error_lbl.setText("");
        this.author_lbl.setText(book.getAuthor());
        this.isbn_lbl.setText(book.getIsbn());
        this.copies_lbl.setText(Integer.toString(book.getCopies()));
        this.category_lbl.setText(Model.getInstance().getCurrentBook().getCategory().getName());
        this.publisher_lbl.setText(book.getPublisher());
        this.publication_year_lbl.setText(book.getPublication_year());
        this.rating_lbl.setText(Float.toString(book.getRating()));
        this.voters_lbl.setText(Integer.toString(book.getVoteesNumber()));
        System.out.println(book.comments.size());
        this.comments_obs = FXCollections.observableArrayList(book.comments);
        this.comments_list.setItems(comments_obs);
        this.comments_list.setCellFactory(new CommentCellFactory());

        this.rate_btn.setOnAction(event -> onRate());
        this.comment_btn.setOnAction(event -> onComment());
    }


    private void onRate(){
         RadioButton selectedRadioButton = (RadioButton) rating.getSelectedToggle();
        if (selectedRadioButton != null) {
            //temp checks later if client has already reviewed book
            boolean temp = false;
            if(Model.getInstance().getClient().borrowed.size() == 0){
                error_lbl.setText("You are not currently borrowing this book");
            }
            for(Book book : Model.getInstance().getClient().borrowed){
                if(book.getIsbn().equals(this.book.getIsbn())){
                    for(Book book2 : Model.getInstance().getClient().getBooks_rated()){
                        if(book2.getIsbn().equals(this.book.getIsbn())){
                            error_lbl.setText("You have already rated this book");
                            temp = true;
                            break;
                        }
                    }
                    if(!temp){
                        Model.getInstance().getClient().getBooks_rated().add(this.book);
                        this.book.updateRating(Integer.parseInt(selectedRadioButton.getText()));
                        this.rating_lbl.setText(Float.toString(book.getRating()));
                        break;
                    }
                    else{
                        break;
                    }
                }
                error_lbl.setText("You are not currently borrowing this book");
            }
        }
        else{
            error_lbl.setText("No rating selected");
        }
    }

    private void onComment(){
        boolean temp = false;
        if(Model.getInstance().getClient().borrowed.size() == 0){
            error_lbl.setText("You are not currently borrowing this book");
        }
        else{
            if(comment_fld.getText().isEmpty()){
                error_lbl.setText("Nothing typed");
            }
            else{
                for(Book book : Model.getInstance().getClient().borrowed){
                    if(book.getIsbn().equals(this.book.getIsbn())){
                        Comment comment = new Comment(comment_fld.getText(), Model.getInstance().getClient());
                        comments_obs.add(comment);
                        book.comments.add(comment);
                        break;
                    }
                    error_lbl.setText("You are not currently borrowing this book");
                }
            }
        }
    }
}


