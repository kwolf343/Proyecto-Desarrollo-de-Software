package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.entidad.Detalleventacomida;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CDetalleventacomida {
    public CDetalleventacomida(){}
    public void InsertarDetalleventacomida(int idcomida, int cantidadcomida, int idventacomida, String total){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Detalleventacomida dc = new Detalleventacomida();
            dc.setIdcomida(idcomida);
            dc.setCantidadcomida(cantidadcomida);
            dc.setIdventacomida(idventacomida);
            dc.setTotal(total);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            dc = Operaciones.insertar(dc);
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
    public void BorrarDetalleventacomida(int id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Detalleventacomida dc = new Detalleventacomida();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            dc = Operaciones.eliminar(id, new Detalleventacomida());
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
    public Detalleventacomida MostrarDetalleventacomida(int id){
        Detalleventacomida dc = new Detalleventacomida();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        dc = Operaciones.get(id, new Detalleventacomida());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return dc;
    }
    public void ActualizarDetalleventacomida(int id, int idcomida, int cantidadcomida, int idventacomida, String total){
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Detalleventacomida dc = new Detalleventacomida();
            dc.setIdcomida(idcomida);
            dc.setCantidadcomida(cantidadcomida);
            dc.setIdventacomida(idventacomida);
            dc.setTotal(total);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            dc = Operaciones.actualizar(id, dc);
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
    public List<Detalleventacomida> MostrarTodoDetalleventacomida(){
        ArrayList<Detalleventacomida> listado = new ArrayList<Detalleventacomida>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Detalleventacomida());
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
