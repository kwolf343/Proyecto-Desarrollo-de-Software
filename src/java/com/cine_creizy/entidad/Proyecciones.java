package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "proyecciones")
public class Proyecciones {
    @PrimaryKey
    @AutoIncrement
    private int idproyeccion;
    private String horainicio;
    private String horafin;
    private int idsala;
    private int idpelicula;
    public Proyecciones(){}

    public Proyecciones(int idproyeccion, String horainicio, String horafin, int idsala, int idpelicula) {
        this.idproyeccion = idproyeccion;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.idsala = idsala;
        this.idpelicula = idpelicula;
    }

    public int getIdproyeccion() {
        return idproyeccion;
    }

    public void setIdproyeccion(int idproyeccion) {
        this.idproyeccion = idproyeccion;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }
    
}
