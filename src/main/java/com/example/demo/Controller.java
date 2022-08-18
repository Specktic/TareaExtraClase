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
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
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
    private TableColumn<Estudiante, String> NotaFinalA;
    @FXML
    private TableColumn<Estudiante, String> NotaFinalB;
    @FXML
    private TableColumn<Estudiante, String> NotaFinalP;


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
                    E.setExamenes(Integer.parseInt(valores[6]));
                    E.setQuices(Integer.parseInt(valores[7]));
                    E.setTareas(Integer.parseInt(valores[8]));
                    E.setProyecto1(Integer.parseInt(valores[9]));
                    E.setProyecto2(Integer.parseInt(valores[10]));
                    E.setProyecto3(Integer.parseInt(valores[11]));
                    if (Objects.equals(E.getTipo(), "A")) {
                        E.CalcNotaFinalA(Integer.parseInt(valores[9]), Integer.parseInt(valores[10]), Integer.parseInt(valores[11]));
                    }
                    else {
                        E.CalcNotaFinalA(0,0,0);
                    }
                    if (Objects.equals(E.getTipo(), "B")) {
                        E.CalcNotaFinalB(Integer.parseInt(valores[9]), Integer.parseInt(valores[10]), Integer.parseInt(valores[11]));
                    }
                    else {
                        E.CalcNotaFinalB(0, 0, 0);
                    }
                    E.CalcNotaFinalP(Integer.parseInt(valores[6]), Integer.parseInt(valores[7]), Integer.parseInt(valores[8]), Integer.parseInt(valores[9]), Integer.parseInt(valores[10]), Integer.parseInt(valores[11]));

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
        NotaFinalA.setCellValueFactory(new PropertyValueFactory<>("NotaFinalA"));
        NotaFinalB.setCellValueFactory(new PropertyValueFactory<>("NotaFinalB"));
        NotaFinalP.setCellValueFactory(new PropertyValueFactory<>("NotaFinalP"));
    }
}