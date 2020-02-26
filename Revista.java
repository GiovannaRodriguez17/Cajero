package com.mycompany.app;

import javafx.beans.property.SimpleStringProperty;

public class Revista {
    public SimpleStringProperty RID,RTitulo,RRevista,RFecha,REdic,RPag;

    public Revista(){
        this.RID = new SimpleStringProperty();
        this.RTitulo = new SimpleStringProperty();
        this.RRevista = new SimpleStringProperty();
        this.RFecha = new SimpleStringProperty();
        this.REdic = new SimpleStringProperty();
        this.RPag = new SimpleStringProperty();
    }
    public Revista(String RID, String RTitulo, String RRevista, String RFecha, String REdic, String RPag) {
        this.RID = new SimpleStringProperty(RID);
        this.RTitulo = new SimpleStringProperty( RTitulo);
        this.RRevista =  new SimpleStringProperty(RRevista);
        this.RFecha =  new SimpleStringProperty(RFecha);
        this.REdic =  new SimpleStringProperty(REdic);
        this.RPag =  new SimpleStringProperty(RPag);
    }

    public String getRID() {
        return RID.get();
    }

    public SimpleStringProperty RIDProperty() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID= new SimpleStringProperty(RID);
    }

    public String getRTitulo() {
        return RTitulo.get();
    }

    public SimpleStringProperty RTituloProperty() {
        return RTitulo;
    }

    public void setRTitulo(String RTitulo) {
        this.RTitulo= new SimpleStringProperty(RTitulo);
    }

    public String getRRevista() {
        return RRevista.get();
    }

    public SimpleStringProperty RRevistaProperty() {
        return RRevista;
    }

    public void setRRevista(String RRevista) {
        this.RRevista= new SimpleStringProperty(RRevista);
    }

    public String getRFecha() {
        return RFecha.get();
    }

    public SimpleStringProperty RFechaProperty() {
        return RFecha;
    }

    public void setRFecha(String RFecha) {
        this.RFecha= new SimpleStringProperty(RFecha);
    }

    public String getREdic() {
        return REdic.get();
    }

    public SimpleStringProperty REdicProperty() {
        return REdic;
    }

    public void setREdic(String REdic) {
        this.REdic= new SimpleStringProperty(REdic);
    }

    public String getRPag() {
        return RPag.get();
    }

    public SimpleStringProperty RPagProperty() {
        return RPag;
    }

    public void setRPag(String RPag) {
        this.RPag= new SimpleStringProperty(RPag);
    }
}
