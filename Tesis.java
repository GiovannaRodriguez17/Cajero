package com.mycompany.app;

import javafx.beans.property.SimpleStringProperty;

public class Tesis {
    public SimpleStringProperty TID,TTitulo,TAutor,TAño,TInst,TLugar;

    public Tesis(){
         this.TID= new SimpleStringProperty();
         this.TTitulo= new SimpleStringProperty();
         this.TAutor = new SimpleStringProperty();
         this.TAño = new SimpleStringProperty();
         this.TInst = new SimpleStringProperty();
         this.TLugar = new SimpleStringProperty();
    }
    public Tesis(String ID,String TTitulo, String TAutor, String TAño, String TInst, String TLugar) {
        this.TTitulo = new SimpleStringProperty(TTitulo);
        this.TAutor = new SimpleStringProperty(TAutor);
        this.TAño = new SimpleStringProperty(TAño);
        this.TInst = new SimpleStringProperty(TInst);
        this.TLugar = new SimpleStringProperty(TLugar);
        this.TID = new SimpleStringProperty(ID);
    }

    public String getTID() {
        return TID.get();
    }

    public SimpleStringProperty TIDProperty() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID= new SimpleStringProperty(TID);
    }

    public String getTTitulo() {
        return TTitulo.get();
    }

    public SimpleStringProperty TTituloProperty() {
        return TTitulo;
    }

    public void setTTitulo(String TTitulo) {
        this.TTitulo=new SimpleStringProperty(TTitulo);
    }

    public String getTAutor() {
        return TAutor.get();
    }

    public SimpleStringProperty TAutorProperty() {
        return TAutor;
    }

    public void setTAutor(String TAutor) {
        this.TAutor=new SimpleStringProperty(TAutor);
    }

    public String getTAño() {
        return TAño.get();
    }

    public SimpleStringProperty TAñoProperty() {
        return TAño;
    }

    public void setTAño(String TAño) {
        this.TAño=new SimpleStringProperty(TAño);
    }

    public String getTInst() {
        return TInst.get();
    }

    public SimpleStringProperty TInstProperty() {
        return TInst;
    }

    public void setTInst(String TInst) {
        this.TInst=new SimpleStringProperty(TInst);
    }

    public String getTLugar() {
        return TLugar.get();
    }

    public SimpleStringProperty TLugarProperty() {
        return TLugar;
    }

    public void setTLugar(String TLugar) {
        this.TLugar=new SimpleStringProperty(TLugar);
    }
}
