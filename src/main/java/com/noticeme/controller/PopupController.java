package com.noticeme.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PopupController /*extends Dialog<Note>*/ implements Initializable {

    public static final String SELF_FXML = "ui/Popup.fxml";
    public static final String SELF = "controller/PopupController";
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfWhere;
    @FXML
    private TextField tfNote;
    @FXML
    private DatePicker dpDate;
    @FXML
    private DatePicker dpDateNotification;
    @FXML
    private CheckBox cbNotify;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dpDate.setValue(LocalDate.now());
    }

    @FXML
    private void onCheckboxClick(ActionEvent event) {
    }

    @FXML
    private void onEnter(ActionEvent event) {
    }

    @FXML
    private void onCancel(ActionEvent event) {
        Stage stage = (Stage) dpDate.getParent().getScene().getWindow();
        stage.close();
    }

}
