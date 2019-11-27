package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "roles")
public class Roles {
    @PrimaryKey
    @AutoIncrement
    private int idrol;
    private String rol;
    public Roles(){}

    public Roles(int idrol, String rol) {
        this.idrol = idrol;
        this.rol = rol;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
