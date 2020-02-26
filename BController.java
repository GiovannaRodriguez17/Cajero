package com.mycompany.app;


import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.List;

public class BController {

    @FXML private Button B_Libros;
    @FXML private Button B_Tesis;
    @FXML private Button B_Revista;
    @FXML private Button B_Prestamo;
    @FXML private Button B_AdminUsuario;
    @FXML private Button B_Archivos;

     @FXML void initialize(){
    }

    public void BLibros() throws IOException {
        Stage op = FXMLLoader.load(getClass().getResource("/V_Libro.fxml"));
        op.setTitle("Administrar Libros");
        op.show();
        Stage stage = (Stage) B_Libros.getScene().getWindow();
        stage.close();
    }

    public void BTesis() throws IOException {
        Stage op = FXMLLoader.load(getClass().getResource("/V_Tesis.fxml"));
        op.setTitle("Administrar Tesis");
        op.show();
        Stage stage = (Stage) B_Tesis.getScene().getWindow();
        stage.close();
    }

    public void BRevista() throws IOException{
        Stage op = FXMLLoader.load(getClass().getResource("/V_Revista.fxml"));
        op.setTitle("Administrar Revista");
        op.show();
        Stage stage = (Stage) B_Revista.getScene().getWindow();
        stage.close();
    }

    public void BPrestamo()throws IOException {
        Stage op = FXMLLoader.load(getClass().getResource("/V_Prestamo.fxml"));
        op.setTitle("Administrar Prestamos");
        op.show();
        Stage stage = (Stage) B_Prestamo.getScene().getWindow();
        stage.close();
    }

    public void BUsuario() throws IOException{
        Stage op = FXMLLoader.load(getClass().getResource("/V_Usuario.fxml"));
        op.setTitle("Administrar Usuarios");
        op.show();
        Stage stage = (Stage) B_AdminUsuario.getScene().getWindow();
        stage.close();
    }

    public void BArchivos() throws IOException{
        Stage op = FXMLLoader.load(getClass().getResource("/V_ArchivosXLXS.fxml"));
        op.setTitle("Administrar Archivos");
        op.show();
        Stage stage = (Stage) B_Archivos.getScene().getWindow();
        stage.close();
    }

}
