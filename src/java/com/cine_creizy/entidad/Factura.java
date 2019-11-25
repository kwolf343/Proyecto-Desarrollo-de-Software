package com.cine_creizy.entidad;
import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "factura")
public class Factura {
    @PrimaryKey
    @AutoIncrement
    private int idfactura;
    private int iddetallecompra;
    private int idcompraboletos;
    private String idusuario;
    
    public Factura(){}

    public Factura(int idfactura, int iddetallecompra, int idcompraboletos, String idusuario) {
        this.idfactura = idfactura;
        this.iddetallecompra = iddetallecompra;
        this.idcompraboletos = idcompraboletos;
        this.idusuario = idusuario;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getIddetallecompra() {
        return iddetallecompra;
    }

    public void setIddetallecompra(int iddetallecompra) {
        this.iddetallecompra = iddetallecompra;
    }

    public int getIdcompraboletos() {
        return idcompraboletos;
    }

    public void setIdcompraboletos(int idcompraboletos) {
        this.idcompraboletos = idcompraboletos;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }
    
    
}
