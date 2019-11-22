package com.cine_creizy.entidad;
import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "compraboletos")
public class Compraboletos {
     @PrimaryKey
     @AutoIncrement
     private int idcompraboletos;
     private String codigoboletos;
     private int cantidadboletos;
     private String String;
     
     public Compraboletos(){}

    public Compraboletos(int idcompraboletos, String codigoboletos, int cantidadboletos, String String) {
        this.idcompraboletos = idcompraboletos;
        this.codigoboletos = codigoboletos;
        this.cantidadboletos = cantidadboletos;
        this.String = String;
    }

    public int getIdcompraboletos() {
        return idcompraboletos;
    }

    public void setIdcompraboletos(int idcompraboletos) {
        this.idcompraboletos = idcompraboletos;
    }

    public String getCodigoboletos() {
        return codigoboletos;
    }

    public void setCodigoboletos(String codigoboletos) {
        this.codigoboletos = codigoboletos;
    }

    public int getCantidadboletos() {
        return cantidadboletos;
    }

    public void setCantidadboletos(int cantidadboletos) {
        this.cantidadboletos = cantidadboletos;
    }

    public String getString() {
        return String;
    }

    public void setString(String String) {
        this.String = String;
    }
     
    
}
