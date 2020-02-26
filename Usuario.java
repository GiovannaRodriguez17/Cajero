package com.mycompany.app;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class Usuario extends Controller {
    public SimpleStringProperty UID, UNombre, UApellido, UCorreo, UTel;

    public Usuario() {
        this.UID = new SimpleStringProperty();
        this.UNombre = new SimpleStringProperty();
        this.UApellido = new SimpleStringProperty();
        this.UCorreo = new SimpleStringProperty();
        this.UTel = new SimpleStringProperty();
    }

    public Usuario(String UID, String UNombre, String UApellido, String UCorreo, String UTel) {
        this.UID = new SimpleStringProperty(UID);
        this.UNombre = new SimpleStringProperty(UNombre);
        this.UApellido = new SimpleStringProperty(UApellido);
        this.UCorreo = new SimpleStringProperty(UCorreo);
        this.UTel = new SimpleStringProperty(UTel);
    }

    public String getUID() {
        return UID.get();
    }

    public SimpleStringProperty UIDProperty() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = new SimpleStringProperty(UID);
    }

    public String getUNombre() {
        return UNombre.get();
    }

    public SimpleStringProperty UNombreProperty() {
        return UNombre;
    }

    public void setUNombre(String UNombre) {
        this.UNombre = new SimpleStringProperty(UNombre);
    }

    public String getUApellido() {
        return UApellido.get();
    }

    public SimpleStringProperty UApellidoProperty() {
        return UApellido;
    }

    public void setUApellido(String UApellido) {
        this.UApellido = new SimpleStringProperty(UApellido);
    }

    public String getUCorreo() {
        return UCorreo.get();
    }

    public SimpleStringProperty UCorreoProperty() {
        return UCorreo;
    }

    public void setUCorreo(String UCorreo) {
        this.UCorreo = new SimpleStringProperty(UCorreo);
    }

    public String getUTel() {
        return UTel.get();
    }

    public SimpleStringProperty UTelProperty() {
        return UTel;
    }

    public void setUTel(String UTel) {
        this.UTel = new SimpleStringProperty(UTel);
    }

}
