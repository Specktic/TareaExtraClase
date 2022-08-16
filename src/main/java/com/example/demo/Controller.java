package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
            String path = (archivoselec.getAbsolutePath());

            BufferedReader lector = null;
            String linea = " ";
            byte NumLinea = -1;

            try {
                lector = new BufferedReader(new FileReader(path));
                while ((linea = lector.readLine()) != null) {

                    NumLinea += 1;

                    String[] fila = linea.split(",");

                    for(String indice : fila) {
                        System.out.printf("%-20s", indice);

                    }
                    System.out.println();

                    Notas.appendText(linea);
                    Notas.appendText("\n");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    lector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Archivo Invalido");
        }

        }

        public void TextAreaDisplay() {

        }
}