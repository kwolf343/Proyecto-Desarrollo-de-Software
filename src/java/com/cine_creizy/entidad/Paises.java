package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "paises")
public class Paises {
    @PrimaryKey
    @AutoIncrement
    private int idpais;
    private String pais;
    
    public Paises(){}

    public Paises(int idpais, String pais) {
        this.idpais = idpais;
        this.pais = pais;
    }

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}