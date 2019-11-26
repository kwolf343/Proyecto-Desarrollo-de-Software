package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.entidad.Boletos;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CBoletos {
    private String codigoboleto;
    private int idtipodeboleto;
    private int idproyecion;
    public CBoletos(){}
    
    public void InsertarBoletos(String codigo, int tipo, int proyeccion){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Boletos b = new Boletos();
            b.setCodigoboleto(codigo);
            b.setIdtipodeboleto(tipo);
            b.setIdproyecion(proyeccion);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            b = Operaciones.insertar(b);
            Operaciones.commit();
            } catch(Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null,ex);
            } finally {
            try {
            Operaciones.cerrarConexion();
            } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
    
}
