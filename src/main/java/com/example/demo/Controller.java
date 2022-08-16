package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.io.File;

public class Controller {
    @FXML
    private Button SearchButton;

    @FXML
    private ListView Archivos;

    @FXML
    private TextArea Notas;

    public void SearchButtonEvent(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\mavic\\Desktop\\Marco\\Datos\\Tarea extra clase\\Archivos CSV"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Archivos CSV", "*.csv"));
        File archivoselec = fc.showOpenDialog(null);

        if (archivoselec != null) {
            Archivos.getItems().add(archivoselec.getName());
        } else {
            System.out.println("Archivo Invalido");
        }

        }
}