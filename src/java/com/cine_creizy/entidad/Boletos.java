package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "boletos")
public class Boletos {
    @PrimaryKey
    @AutoIncrement
    private String codigoboleto;
    private int idtipodeboleto;
    private int idproyecion;
    
    public Boletos(){}

    public Boletos(String codigoboleto, int idtipodeboleto, int idproyecion) {
        this.codigoboleto = codigoboleto;
        this.idtipodeboleto = idtipodeboleto;
        this.idproyecion = idproyecion;
    }

    public String getCodigoboleto() {
        return codigoboleto;
    }

    public void setCodigoboleto(String codigoboleto) {
        this.codigoboleto = codigoboleto;
    }

    public int getIdtipodeboleto() {
        return idtipodeboleto;
    }

    public void setIdtipodeboleto(int idtipodeboleto) {
        this.idtipodeboleto = idtipodeboleto;
    }

    public int getIdproyecion() {
        return idproyecion;
    }

    public void setIdproyecion(int idproyecion) {
        this.idproyecion = idproyecion;
    }
    
    
}
