package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.cine_creizy.entidad.Salas;

public class CSalas {
    public CSalas(){}
    
    public void InsertarSalas(String sala){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Salas s = new Salas();
            s.setSala(sala);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            s = Operaciones.insertar(s);
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
    public void BorrarSalas(int id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Salas s = new Salas();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            s = Operaciones.eliminar(id, new Salas());
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
    public Salas MostrarSalas(int id){
        Salas s = new Salas();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        s = Operaciones.get(id, new Salas());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return s;
    }
    public void ActualizarSalas(int id, String sala){
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Salas s = new Salas();
            s.setSala(sala);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            s = Operaciones.actualizar(id, s);
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
    public List<Salas> MostrarTodoSalas(){
        ArrayList<Salas> listado = new ArrayList<Salas>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Salas());
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
