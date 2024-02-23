package com.el20134;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Basic {

    @FXML
    private Label label;

    public void initialize() {
        // TODO
    }   

    @FXML
    private void handleButtonAction(ActionEvent event) {
        label.setText("Hello World!");
    }

}
