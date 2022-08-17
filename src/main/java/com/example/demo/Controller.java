package com.example.demo;

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
    private TableColumn<Estudiante, String> Tipo;
    @FXML
    private TableColumn<Estudiante, Integer> Examenes;
    @FXML
    private TableColumn<Estudiante, Integer> Quices;
    @FXML
    private TableColumn<Estudiante, Integer> Tareas;
    @FXML
    private TableColumn<Estudiante, Integer> Proyecto1;
    @FXML
    private TableColumn<Estudiante, Integer> Proyecto2;
    @FXML
    private TableColumn<Estudiante, Integer> Proyecto3;
    @FXML
    private TableColumn<Estudiante, Integer> NotaFinalA;
    @FXML
    private TableColumn<Estudiante, Integer> NotaFinalB;
    @FXML
    private TableColumn<Estudiante, Integer> NotaFinalP;


    public void SearchButtonEvent(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\mavic\\Desktop\\Marco\\Datos\\Tarea extra clase\\Archivos CSV"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Archivos CSV", "*.csv"));
        File archivoselec = fc.showOpenDialog(null);

        if (archivoselec != null) {
            Archivos.getItems().add(archivoselec.getName());
            String path = (archivoselec.getAbsolutePath());

            BufferedReader lector = null;
            String linea = "";

            try {

                lector = new BufferedReader(new FileReader(path));
                ObservableList<Estudiante> list = FXCollections.observableArrayList();

                while ((linea = lector.readLine()) != null) {

                    String[] valores = linea.split(";");

                    Estudiante E = new Estudiante();
                    E.setCarnet(valores[0]);
                    E.setNombre(valores[1]);
                    E.setCorreo(valores[2]);
                    E.setTelefono(valores[3]);
                    E.setNick(valores[4]);
                    E.setTipo(valores[5]);
                    E.setExamenes(valores[6]);
                    E.setQuices(valores[7]);
                    E.setTareas(valores[8]);
                    E.setProyecto1(valores[9]);
                    E.setProyecto2(valores[10]);
                    E.setProyecto3(valores[11]);
                    E.setNotaFinalA(valores[6], valores[7], valores[8]);
                    E.setNotaFinalB(valores[9], valores[10], valores[11]);
                    E.setNotaFinalP(valores[6], valores[7], valores[8], valores[9], valores[10], valores[3]);

                    for(String indice : valores) {
                        System.out.printf("%-30s", indice); // printf es un metodo sobrecargado de la clase PrintStream
                        }

                    list.add(E);
                    TablaNotas.setItems(list);

                    System.out.println();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Carnet.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("Carnet"));
        Nombre.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("Nombre"));
        Correo.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("Correo"));
        Telefono.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("Telefono"));
        Nick.setCellValueFactory(new PropertyValueFactory<Estudiante, String >("Nick"));
        Tipo.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("Tipo"));
        Examenes.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("Examenes"));
        Quices.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("Quices"));
        Tareas.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("Tareas"));
        Proyecto1.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("Proyecto1"));
        Proyecto2.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("Proyecto2"));
        Proyecto3.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("Proyecto3"));
        NotaFinalA.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("NotaFinalA"));
        NotaFinalB.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("NotaFinalB"));
        NotaFinalP.setCellValueFactory(new PropertyValueFactory<Estudiante, Integer>("NotaFinalP"));
    }
}