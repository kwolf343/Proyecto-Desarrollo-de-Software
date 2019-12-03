package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.entidad.Boletos;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CBoletos {
    public CBoletos(){}
    
    public void InsertarBoletos(int idtipodeboleto, int idproyeccion, int idasiento, int idventaboleto){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Boletos b = new Boletos();
            b.setIdtipodeboleto(idtipodeboleto);
            b.setIdproyeccion(idproyeccion);
            b.setIdasiento(idasiento);
            b.setIdventaboleto(idventaboleto);
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
    public void BorrarBoletos(int id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Boletos b = new Boletos();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            b = Operaciones.eliminar(id, new Boletos());
            Operaciones.commit();
            } catch(Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            try {
            Operaciones.cerrarConexion();
            } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null, ex);
            }
            }
    }
    public Boletos MostrarBoletos(int id){
        Boletos b = new Boletos();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        b = Operaciones.get(id, new Boletos());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return b;
    }
    public void ActualizarBoletos(int idboleto, int idtipodeboleto, int idproyeccion, int idasiento, int idventaboleto){
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Boletos b = new Boletos();
            b.setIdboleto(idboleto);
            b.setIdtipodeboleto(idtipodeboleto);
            b.setIdproyeccion(idproyeccion);
            b.setIdasiento(idasiento);
            b.setIdventaboleto(idventaboleto);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            b = Operaciones.actualizar(idboleto, b);
            Operaciones.commit();
            } catch(Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null,ex);
            } finally {
            try {
            Operaciones.cerrarConexion();
            } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null, ex);
            }
            }
    }
    public List<Boletos> MostrarTodoBoletos(){
        ArrayList<Boletos> listado = new ArrayList<Boletos>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Boletos());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return listado;
    }
}
