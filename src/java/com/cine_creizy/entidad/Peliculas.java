package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "peliculas")
public class Peliculas {
 @PrimaryKey
 @AutoIncrement
 private int idpelicula;
 private String titulo;
 private String duracion;
 private String sinopsis;
 private String clasificacion;
 private String generos;
 private String fecha_De_Llegada;
 private String fecha_De_Salida;
 
 public Peliculas(){}

    public Peliculas(int idpelicula, String titulo, String duracion, String sinopsis, String clasificacion, String generos, String fecha_De_Llegada, String fecha_De_Salida) {
        this.idpelicula = idpelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.clasificacion = clasificacion;
        this.generos = generos;
        this.fecha_De_Llegada = fecha_De_Llegada;
        this.fecha_De_Salida = fecha_De_Salida;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return generos;
    }

    public void setGenero(String generos) {
        this.generos = generos;
    }

    public String getFecha_De_Llegada() {
        return fecha_De_Llegada;
    }

    public void setFecha_De_Llegada(String fecha_De_Llegada) {
        this.fecha_De_Llegada = fecha_De_Llegada;
    }

    public String getFecha_De_Salida() {
        return fecha_De_Salida;
    }

    public void setFecha_De_Salida(String fecha_De_Salida) {
        this.fecha_De_Salida = fecha_De_Salida;
    }
}
