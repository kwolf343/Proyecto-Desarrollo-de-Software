package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "salas")
public class Salas {
    @PrimaryKey
    @AutoIncrement
    private int idsala;
    private String sala;
    public Salas (){}

    public Salas(int idsala, String sala) {
        this.idsala = idsala;
        this.sala = sala;
    }

    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    
    
}
