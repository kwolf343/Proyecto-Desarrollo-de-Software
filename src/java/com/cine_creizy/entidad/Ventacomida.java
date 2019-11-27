package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "ventacomida")
public class Ventacomida {
    @PrimaryKey
    @AutoIncrement
    private int idventacomida;
    private String vendedor;
    private double total;
    public Ventacomida(){}

    public Ventacomida(int idventacomida, double total) {
        this.idventacomida = idventacomida;
        this.total = total;
    }

    public int getIdventacomida() {
        return idventacomida;
    }

    public void setIdventacomida(int idventacomida) {
        this.idventacomida = idventacomida;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
