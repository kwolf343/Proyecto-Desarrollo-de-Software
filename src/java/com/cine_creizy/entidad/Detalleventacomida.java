
package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "detalleventacomida")
public class Detalleventacomida {
    @PrimaryKey
    @AutoIncrement
    private int iddetallecomida;
    private int idcomida;
    private int cantidadcomida;
    private int idventacomida;
    private double total;
    public Detalleventacomida(){}

    public Detalleventacomida(int iddetallecomida, int idcomida, int cantidadcomida, int idventacomida, double total) {
        this.iddetallecomida = iddetallecomida;
        this.idcomida = idcomida;
        this.cantidadcomida = cantidadcomida;
        this.idventacomida = idventacomida;
        this.total = total;
    }

    public int getIddetallecomida() {
        return iddetallecomida;
    }

    public void setIddetallecomida(int iddetallecomida) {
        this.iddetallecomida = iddetallecomida;
    }

    public int getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(int idcomida) {
        this.idcomida = idcomida;
    }

    public int getCantidadcomida() {
        return cantidadcomida;
    }

    public void setCantidadcomida(int cantidadcomida) {
        this.cantidadcomida = cantidadcomida;
    }

    public int getIdventacomida() {
        return idventacomida;
    }

    public void setIdventacomida(int idventacomida) {
        this.idventacomida = idventacomida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
