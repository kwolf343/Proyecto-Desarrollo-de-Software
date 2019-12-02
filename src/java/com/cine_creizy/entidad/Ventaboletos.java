package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "ventaboletos")
public class Ventaboletos {
    @PrimaryKey
    @AutoIncrement
    private int idventaboleto;
    private String idusuario;
    private double total;
    
    public Ventaboletos(){}

    public Ventaboletos(int idventaboleto, String idusuario, double total) {
        this.idventaboleto = idventaboleto;
        this.idusuario = idusuario;
        this.total = total;
    }

    public int getIdventaboleto() {
        return idventaboleto;
    }

    public void setIdventaboleto(int idventaboleto) {
        this.idventaboleto = idventaboleto;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
