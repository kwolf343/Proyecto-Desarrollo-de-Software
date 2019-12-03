package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "ventacomida")
public class Ventacomida {
    @PrimaryKey
    @AutoIncrement
    private int idventacomida;
    private String idusuario;
    private double total;
    public Ventacomida(){}

    public Ventacomida(int idventacomida, double total, String idusuario) {
        this.idventacomida = idventacomida;
        this.total = total;
        this.idusuario=idusuario;
    }

    public int getIdventacomida() {
        return idventacomida;
    }

    public void setIdventacomida(int idventacomida) {
        this.idventacomida = idventacomida;
    }

    public String getVendedor() {
        return idusuario;
    }

    public void setVendedor(String idusuario) {
        this.idusuario = idusuario;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
