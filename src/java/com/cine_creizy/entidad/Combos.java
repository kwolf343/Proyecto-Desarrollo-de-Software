package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "combos")
public class Combos {
    @PrimaryKey
    private int idcombo;
    private String nombrecombo;
    private String descripcioncombo;
    private double precio;
    public Combos(){}

    public Combos(int idcombo, String nombrecombo, String descripcioncombo, double precio) {
        this.idcombo = idcombo;
        this.nombrecombo = nombrecombo;
        this.descripcioncombo = descripcioncombo;
        this.precio = precio;
    }

    public int getIdcombo() {
        return idcombo;
    }

    public void setIdcombo(int idcombo) {
        this.idcombo = idcombo;
    }

    public String getNombrecombo() {
        return nombrecombo;
    }

    public void setNombrecombo(String nombrecombo) {
        this.nombrecombo = nombrecombo;
    }

    public String getDescripcioncombo() {
        return descripcioncombo;
    }

    public void setDescripcioncombo(String descripcioncombo) {
        this.descripcioncombo = descripcioncombo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    
}
