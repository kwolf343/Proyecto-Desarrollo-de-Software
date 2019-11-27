package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "comidas")
public class Comidas {
     @PrimaryKey
     @AutoIncrement
     private int idcomida;
     private String nombre;
     private double precio;
     private int existencia;
     
    public Comidas(){}

    public Comidas(int idcomida, String nombre, double precio, int existencia) {
        this.idcomida = idcomida;
        this.nombre = nombre;
        this.precio=precio;
        this.existencia = existencia;
    }

    public int getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(int idcomida) {
        this.idcomida = idcomida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
     
    
}
