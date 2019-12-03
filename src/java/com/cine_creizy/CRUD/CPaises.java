package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.cine_creizy.entidad.Paises;
import java.util.ArrayList;
import java.util.List;

public class CPaises {
    private int idpais;
    private String pais;
    
    public CPaises(){}
    
    public void InsertarPaises(String paise){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Paises p = new Paises();
            p.setPais(paise);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            p = Operaciones.insertar(p);
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
    public void BorrarPaises(int id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Paises p = new Paises();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            p = Operaciones.eliminar(id, new Paises());
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
    public Paises MostrarPaises(int id){
        Paises p = new Paises();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        p = Operaciones.get(id, new Paises());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return p;
    }
    public void ActualizarPaises(int id, String paise){
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Paises p = new Paises();
            p.setPais(paise);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            p = Operaciones.actualizar(id, p);
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
    public List<Paises> MostrarTodoPaises(){
        ArrayList<Paises> listado = new ArrayList<Paises>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Paises());
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
