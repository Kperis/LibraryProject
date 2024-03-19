package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BookCellController implements Initializable{
    @FXML
    public Label title_lbl;
    
    @FXML
    public Label author_lbl;
    
    @FXML
    public Label isbn_lbl;

    @FXML
    public Label rating_lbl;
    
    @FXML
    public Label rating_count_lbl;
    
    @FXML
    public Button del_btn;

    @FXML
    public Button edit_btn;

    private Book book;

    public BookCellController(Book book){
        this.book = book;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        title_lbl.setText(book.getTitle());
        author_lbl.setText(book.getAuthor());
        isbn_lbl.setText(book.getIsbn());
        rating_lbl.setText(Float.toString(book.getRating()));
        rating_count_lbl.setText(Integer.toString(book.getVoteesNumber()));
        del_btn.setOnAction(event -> onDelete());
        edit_btn.setOnAction(event -> onEdit());
        if(Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT){
            edit_btn.setVisible(false);
            del_btn.setText("Borrow");
            del_btn.setOnAction(event -> onBorrow());
        }
    }

    private void onDelete() {
        for(Client client : Model.getInstance().users){
            for(Book book2 : client.borrowed){
                if(book2.getIsbn().equals(book.getIsbn())){
                    client.borrowed.remove(book2);
                }
            }
        }

        for(Borrow borrow : Model.getInstance().borrows){
            if(borrow.getBook().getIsbn().equals(book.getIsbn())){
                Model.getInstance().borrows.remove(borrow);
            }
        }
        Model.getInstance().books.remove(book);
    }

    private void onEdit(){
        Model.getInstance().onEdit = true;
        Model.getInstance().setCurrentBook(book);
        Model.getInstance().getViewFactory().onAddBook();
    }

    private void onBorrow(){
        Model.getInstance().getClient().BorrowBook(book);
    }
}
