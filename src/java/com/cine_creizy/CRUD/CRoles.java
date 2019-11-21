package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.cine_creizy.entidad.Roles;

public class CRoles {
    public CRoles(){}
    
    public void InsertarRoles(String rol){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Roles r = new Roles();
            r.setRol(rol);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            r = Operaciones.insertar(r);
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
    public void BorrarRoles(int id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Roles r = new Roles();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            r = Operaciones.eliminar(id, new Roles());
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
    public Roles MostrarRoles(int id){
        Roles r = new Roles();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        r = Operaciones.get(id, new Roles());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return r;
    }
    public void ActualizarRoles(int id, String role){
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Roles r = new Roles();
            r.setRol(role);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            r = Operaciones.actualizar(id, r);
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
    public List<Roles> MostrarTodoRoles(){
        ArrayList<Roles> listado = new ArrayList<Roles>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Roles());
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
