package com.cine_creizy.entidad;
import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "asientos")
public class Asientos {
    @PrimaryKey
    @AutoIncrement
    private int idasiento;
    private String asiento;
    private int idsala;
    private int disponible;
     public Asientos(){}
    
    public Asientos(int idasiento, String asiento, int idsala, int disponible) {
        this.idasiento = idasiento;
        this.asiento = asiento;
        this.idsala = idsala;
        this.disponible = disponible;
    }

    public int getIdasiento() {
        return idasiento;
    }

    public void setIdasiento(int idasiento) {
        this.idasiento = idasiento;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }
}
