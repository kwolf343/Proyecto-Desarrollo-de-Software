package com.cine_creizy.entidad;

import com.cine_creizy.anotaciones.AutoIncrement;
import com.cine_creizy.anotaciones.Entity;
import com.cine_creizy.anotaciones.FieldName;
import com.cine_creizy.anotaciones.NotNull;
import com.cine_creizy.anotaciones.PrimaryKey;

@Entity(table = "permiso")
public class Permiso {
    @PrimaryKey
    @AutoIncrement
    @FieldName(name = "idpermiso")
    private int idpermiso;
    @NotNull
    private int idmenu;
    @NotNull
    private int idrol;
    public Permiso() {
    }

    public Permiso(int idpermiso, int idmenu, int idrol) {
        this.idpermiso = idpermiso;
        this.idmenu = idmenu;
        this.idrol = idrol;
    }

    public int getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(int idpermiso) {
        this.idpermiso = idpermiso;
    }

    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }
    
}
