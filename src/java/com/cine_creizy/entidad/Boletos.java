package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "boletos")
public class Boletos {
    @PrimaryKey
    @AutoIncrement
    private int idboleto;
    private int idtipodeboleto;
    private int idproyeccion;
    private int idasiento;
    private int idventaboleto;
    
    public Boletos(){}

    public Boletos(int idboleto, int idtipodeboleto, int idproyeccion, int idasiento, int idventaboleto) {
        this.idboleto = idboleto;
        this.idtipodeboleto = idtipodeboleto;
        this.idproyeccion = idproyeccion;
        this.idasiento = idasiento;
        this.idventaboleto = idventaboleto;
    }
    public int getIdboleto() {
        return idboleto;
    }

    public void setIdboleto(int idboleto) {
        this.idboleto = idboleto;
    }

    public int getIdtipodeboleto() {
        return idtipodeboleto;
    }

    public void setIdtipodeboleto(int idtipodeboleto) {
        this.idtipodeboleto = idtipodeboleto;
    }

    public int getIdproyeccion() {
        return idproyeccion;
    }

    public void setIdproyeccion(int idproyecion) {
        this.idproyeccion = idproyecion;
    }

    public int getIdasiento() {
        return idasiento;
    }

    public void setIdasiento(int idasiento) {
        this.idasiento = idasiento;
    }

    public int getIdventaboleto() {
        return idventaboleto;
    }

    public void setIdventaboleto(int idventaboleto) {
        this.idventaboleto = idventaboleto;
    }

}
