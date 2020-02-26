package com.mycompany.app;

import javafx.beans.property.SimpleStringProperty;

public class Libro {
    public SimpleStringProperty LISBN,LTitulo,LAutor,LAnio,LEditorial,LPais;

    public Libro(){
        this.LISBN = new SimpleStringProperty();
        this.LTitulo = new SimpleStringProperty();
        this.LAutor = new SimpleStringProperty();
        this.LAnio = new SimpleStringProperty();
        this.LEditorial = new SimpleStringProperty();
        this.LPais = new SimpleStringProperty();
    }

    public Libro(String LISBN, String LTitulo, String LAutor, String LAnio, String LEditorial, String LPais) {
        this.LISBN = new SimpleStringProperty(LISBN);
        this.LTitulo = new SimpleStringProperty(LTitulo);
        this.LAutor = new SimpleStringProperty(LAutor);
        this.LAnio = new SimpleStringProperty(LAnio);
        this.LEditorial = new SimpleStringProperty(LEditorial);
        this.LPais = new SimpleStringProperty(LPais);
    }

    public String getLISBN() {
        return LISBN.get();
    }

    public SimpleStringProperty LISBNProperty() {
        return LISBN;
    }

    public void setLISBN(String LISBN) {
        this.LISBN= new SimpleStringProperty(LISBN);
    }

    public String getLTitulo() {
        return LTitulo.get();
    }

    public SimpleStringProperty LTituloProperty() {
        return LTitulo;
    }

    public void setLTitulo(String LTitulo) {
        this.LTitulo= new SimpleStringProperty(LTitulo);
    }

    public String getLAutor() {
        return LAutor.get();
    }

    public SimpleStringProperty LAutorProperty() {
        return LAutor;
    }

    public void setLAutor(String LAutor) {
        this.LAutor= new SimpleStringProperty(LAutor);
    }

    public String getLAnio() {
        return LAnio.get();
    }

    public SimpleStringProperty LAnioProperty() {
        return LAnio;
    }

    public void setLAnio(String LAnio) {
        this.LAnio= new SimpleStringProperty(LAnio);
    }

    public String getLEditorial() {
        return LEditorial.get();
    }

    public SimpleStringProperty LEditorialProperty() {
        return LEditorial;
    }

    public void setLEditorial(String LEditorial) {
        this.LEditorial= new SimpleStringProperty(LEditorial);
    }

    public String getLPais() {
        return LPais.get();
    }

    public SimpleStringProperty LPaisProperty() {
        return LPais;
    }

    public void setLPais(String LPais) {
        this.LPais= new SimpleStringProperty(LPais);
    }
}
