package com.noticeme;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class NoticeMeApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NoticeMeApplication.class.getResource("ui/Base.fxml")));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("NoticeMe");
        stage.getIcons().add(new Image("media/nadeko.jpg"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}