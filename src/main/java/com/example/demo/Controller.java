package com.example.demo;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button SearchButton;

    @FXML
    private ListView Archivos;

    @FXML
    private TextArea Notas;

    @FXML
    private TableView<Estudiante> TablaNotas;

    @FXML
    private TableColumn<Estudiante, Integer> Carnet;

    @FXML
    private TableColumn<Estudiante, String> Nombre;

    @FXML
    private TableColumn<Estudiante, String> Correo;

    @FXML
    private TableColumn<Estudiante, Integer> Telefono;

    @FXML
    private TableColumn<Estudiante, String> Nick;

    @FXML
    private TableColumn<Estudiante, Character> Tipo;

    @FXML
    private TableColumn<Estudiante, Byte> Examenes;

    @FXML
    private TableColumn<Estudiante, Byte> Quices;

    @FXML
    private TableColumn<Estudiante, Byte> Tareas;

    @FXML
    private TableColumn<Estudiante, Byte> Proyecto1;

    @FXML
    private TableColumn<Estudiante, Byte> Proyecto2;

    @FXML
    private TableColumn<Estudiante, Byte> Proyecto3;


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
                        System.out.printf("%s", indice); // printf es un metodo sobrecargado de la clase PrintStream

                    }
                    System.out.println();

                    Notas.appendText(linea);
                    Notas.appendText("\n");
                    TablaNotas.setItems(list);
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

    ObservableList<Estudiante> list = FXCollections.observableArrayList(
            new Estudiante(8, "Isa", "correo@", 9, "Sam", 'A', (byte) 100,
                    (byte) 100, (byte) 100, (byte) 100, (byte) 100, (byte) 100)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Carnet.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("Carnet"));
        Nombre.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("Nombre"));
        Correo.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("Correo"));
        Telefono.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("Carnet"));
        Nick.setCellValueFactory(new PropertyValueFactory<Estudiante, String >("Nick"));
        Tipo.setCellValueFactory(new PropertyValueFactory<Estudiante, Character>("Tipo"));
        Examenes.setCellValueFactory(new PropertyValueFactory<Estudiante, Byte>("Examenes"));
        Quices.setCellValueFactory(new PropertyValueFactory<Estudiante, Byte>("Quices"));
        Tareas.setCellValueFactory(new PropertyValueFactory<Estudiante, Byte>("Tareas"));
        Proyecto1.setCellValueFactory(new PropertyValueFactory<Estudiante, Byte>("Proyecto1"));
        Proyecto2.setCellValueFactory(new PropertyValueFactory<Estudiante, Byte>("Proyecto2"));
        Proyecto3.setCellValueFactory(new PropertyValueFactory<Estudiante, Byte>("Proyecto3"));

    }
}