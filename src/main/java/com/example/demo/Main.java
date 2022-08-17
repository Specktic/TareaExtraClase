
package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application { // clase main con el constructor de la aplicacion
    public void start(Stage stage) throws IOException { // el start inicializa el stage de scenebuilder, es decir la ventana
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml")); // la funcion lee la configuracion de la ventana
        Scene scene = new Scene(fxmlLoader.load(), 1300, 750); // crea un nuevo objeto scene
        stage.setTitle(" ");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}