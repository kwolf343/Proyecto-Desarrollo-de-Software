package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.entidad.Tipodeboletos;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CTipodeboletos {
     public CTipodeboletos(){}
     public void InsertarTipodeboletos(String F, String T, Double precio){
         DecimalFormat df = new DecimalFormat("#.00");
         String p = String.valueOf(df.format(precio));
         try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Tipodeboletos tb = new Tipodeboletos();
            tb.setFormato(F);
            tb.setTipo(T);
            tb.setPrecio(p);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            tb = Operaciones.insertar(tb);
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
     public void BorrarTipodeboletos(int id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Tipodeboletos tb = new Tipodeboletos();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            tb = Operaciones.eliminar(id, new Tipodeboletos());
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
     public Tipodeboletos MostrarTipodeboletos(int id){
        Tipodeboletos tb = new Tipodeboletos();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        tb = Operaciones.get(id, new Tipodeboletos());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return tb;
    }
     public void ActualizarTipodeboletos(int id, String F, String T, double precio){
        DecimalFormat df = new DecimalFormat("#.00");
        String p = String.valueOf(df.format(precio));
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Tipodeboletos tb = new Tipodeboletos();
            tb.setFormato(F);
            tb.setTipo(T);
            tb.setPrecio(p);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            tb = Operaciones.actualizar(id, tb);
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
     
     public List<Tipodeboletos> MostrarTodoTipodeboletos(){
        ArrayList<Tipodeboletos> listado = new ArrayList<Tipodeboletos>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Tipodeboletos());
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
