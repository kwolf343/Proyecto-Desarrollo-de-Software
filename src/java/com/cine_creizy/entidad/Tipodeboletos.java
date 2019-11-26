package com.cine_creizy.entidad;
import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "tipodeboletos")
public class Tipodeboletos {
    @PrimaryKey
    @AutoIncrement
    private int idtipodeboleto;
    private String formato;
    private String tipo;
    private String precio;
    
    public Tipodeboletos(){}

    public Tipodeboletos(int idtipodeboleto, String formato, String tipo, String precio) {
        this.idtipodeboleto = idtipodeboleto;
        this.formato = formato;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getIdtipodeboleto() {
        return idtipodeboleto;
    }

    public void setIdtipodeboleto(int idtipodeboleto) {
        this.idtipodeboleto = idtipodeboleto;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    
}
