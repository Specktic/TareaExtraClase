package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Controller implements Initializable {      //se implementa la interfaz "Initializable" a la clase controlador
                                                        //Las interfaces son una manera además de las clases abstractas de lograr la abstracción en java
    @FXML
    private ListView Archivos;
    @FXML
    private TableView<Estudiante> TablaNotas;
    @FXML
    private TableColumn<Estudiante, String> Carnet;
    @FXML
    private TableColumn<Estudiante, String> Nombre;
    @FXML
    private TableColumn<Estudiante, String> Correo;
    @FXML
    private TableColumn<Estudiante, String> Telefono;
    @FXML
    private TableColumn<Estudiante, String> Nick;
    @FXML
    private TableColumn<Estudiante, String> Tipo;
    @FXML
    private TableColumn<Estudiante, String> Examenes;
    @FXML
    private TableColumn<Estudiante, String> Quices;
    @FXML
    private TableColumn<Estudiante, String> Tareas;
    @FXML
    private TableColumn<Estudiante, String> Proyecto1;
    @FXML
    private TableColumn<Estudiante, String> Proyecto2;
    @FXML
    private TableColumn<Estudiante, String> Proyecto3;
    @FXML
    private TableColumn<Estudiante, String> NotaA;
    @FXML
    private TableColumn<Estudiante, String> NotaB;
    @FXML
    private TableColumn<Estudiante, String> NotaFinal;


    public void SearchButtonEvent(){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\mavic\\Desktop\\Marco\\Datos\\Tarea extra clase\\Archivos CSV"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Archivos CSV", "*.csv"));
        File archivoselec = fc.showOpenDialog(null);

        if (archivoselec != null) {
            Archivos.getItems().add(archivoselec.getName());
            String path = (archivoselec.getAbsolutePath());

            BufferedReader lector = null;
            String linea;
            int numlinea = 0;

            try {

                lector = new BufferedReader(new FileReader(path));
                ObservableList<Estudiante> list = FXCollections.observableArrayList();

                while ((linea = lector.readLine()) != null){

                    if (numlinea == 1){
                        String[] valores = linea.split(";");

                        Estudiante E = new Estudiante(valores[0], valores[1], valores[2], valores[3], valores[4], valores[5], Integer.parseInt(valores[6]), Integer.parseInt(valores[7]), Integer.parseInt(valores[8]), Integer.parseInt(valores[9]), Integer.parseInt(valores[10]), Integer.parseInt(valores[11]));
                        list.add(E.TipoEstudiante(valores[5]));

                        for(String indice : valores) {System.out.printf("%-30s", indice);} // printf es un metodo sobrecargado de la clase PrintStream

                        TablaNotas.setItems(list);
                        System.out.println();
                    }
                    else {numlinea ++;}
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    assert lector != null;  //Evita un error al cerrar el lector en caso de que no exista uno
                    lector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            System.out.println("Archivo Invalido");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Carnet.setCellValueFactory(new PropertyValueFactory<>("Carnet"));
        Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        Correo.setCellValueFactory(new PropertyValueFactory<>("Correo"));
        Telefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        Nick.setCellValueFactory(new PropertyValueFactory<>("Nick"));
        Tipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        Examenes.setCellValueFactory(new PropertyValueFactory<>("Examenes"));
        Quices.setCellValueFactory(new PropertyValueFactory<>("Quices"));
        Tareas.setCellValueFactory(new PropertyValueFactory<>("Tareas"));
        Proyecto1.setCellValueFactory(new PropertyValueFactory<>("Proyecto1"));
        Proyecto2.setCellValueFactory(new PropertyValueFactory<>("Proyecto2"));
        Proyecto3.setCellValueFactory(new PropertyValueFactory<>("Proyecto3"));
        NotaA.setCellValueFactory(new PropertyValueFactory<>("NotaA"));
        NotaB.setCellValueFactory(new PropertyValueFactory<>("NotaB"));
        NotaFinal.setCellValueFactory(new PropertyValueFactory<>("NotaFinal"));
    }
}
