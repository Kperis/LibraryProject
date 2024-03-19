package com.el20134;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class CommentCellController implements Initializable{
     @FXML
    private Text comment_txt;

    @FXML
    private Label username_lbl;

    private Comment comment;

    public CommentCellController(Comment comment){
        this.comment = comment;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username_lbl.setText(comment.getClient().getUsername());
        comment_txt.setText(comment.getComment());
    }
}
