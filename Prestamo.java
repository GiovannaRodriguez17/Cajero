package com.mycompany.app;

import javafx.beans.property.SimpleStringProperty;

public class Prestamo {
    public SimpleStringProperty PID,PTipo,PUsuario,PFecha,PRetardo;

    public Prestamo(){
        this.PID=new SimpleStringProperty();
        this.PTipo=new SimpleStringProperty();
        this.PUsuario=new SimpleStringProperty();
        this.PFecha=new SimpleStringProperty();
        this.PRetardo=new SimpleStringProperty();
    }

    public Prestamo(String PID, String PTipo, String PUsuario, String PFecha, String PRetardo) {
        this.PID =new SimpleStringProperty(PID);
        this.PTipo =new SimpleStringProperty( PTipo);
        this.PUsuario =new SimpleStringProperty( PUsuario);
        this.PFecha =new SimpleStringProperty( PFecha);
        this.PRetardo =new SimpleStringProperty( PRetardo);
    }

    public String getPID() {
        return PID.get();
    }

    public SimpleStringProperty PIDProperty() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID=new SimpleStringProperty(PID);
    }

    public String getPTipo() {
        return PTipo.get();
    }

    public SimpleStringProperty PTipoProperty() {
        return PTipo;
    }

    public void setPTipo(String PTipo) {
        this.PTipo=new SimpleStringProperty(PTipo);
    }

    public String getPUsuario() {
        return PUsuario.get();
    }

    public SimpleStringProperty PUsuarioProperty() {
        return PUsuario;
    }

    public void setPUsuario(String PUsuario) {
        this.PUsuario=new SimpleStringProperty(PUsuario);
    }

    public String getPFecha() {
        return PFecha.get();
    }

    public SimpleStringProperty PFechaProperty() {
        return PFecha;
    }

    public void setPFecha(String PFecha) {
        this.PFecha=new SimpleStringProperty(PFecha);
    }

    public String getPRetardo() {
        return PRetardo.get();
    }

    public SimpleStringProperty PRetardoProperty() {
        return PRetardo;
    }

    public void setPRetardo(String PRetardo) {
        this.PRetardo=new SimpleStringProperty(PRetardo);
    }
}
