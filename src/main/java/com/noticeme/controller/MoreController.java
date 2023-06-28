package com.noticeme.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author SvenHaaa
 */
public class MoreController implements Initializable {

    public static final String SELF_FXML = "ui/More.fxml";

    @FXML
    private ImageView ivImage;
    @FXML
    private VBox vbBackground;
    @FXML
    private Button btOk;

    private Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ivImage.setImage(new Image("media/neigschaut.jpg"));

    }


    @FXML
    private void onOk(ActionEvent event) {
        Stage stage = (Stage) btOk.getParent().getScene().getWindow();
        stage.close();

    }

}
