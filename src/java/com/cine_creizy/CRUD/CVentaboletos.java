
package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.entidad.Ventaboletos;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CVentaboletos {
    public CVentaboletos(){}
    public void InsertarVentacomida(double total, String vendedor){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Ventaboletos vb = new Ventaboletos();
            vb.setTotal(total);
            vb.setIdusuario(vendedor);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            vb = Operaciones.insertar(vb);
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
    public void BorrarVentaboletos(int id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Ventaboletos vb = new Ventaboletos();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            vb = Operaciones.eliminar(id, new Ventaboletos());
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
    public Ventaboletos MostrarVentaboletos(int id){
        Ventaboletos vb = new Ventaboletos();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        vb = Operaciones.get(id, new Ventaboletos());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return vb;
    }
    public void ActualizarVentaboletos(int idventaboleto, String idusuario, double total){
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Ventaboletos vb = new Ventaboletos();
            vb.setIdventaboleto(idventaboleto);
            vb.setTotal(total);
            vb.setIdusuario(idusuario);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            vb = Operaciones.actualizar(idventaboleto, vb);
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
    public List<Ventaboletos> MostrarTodoVentaboletos(){
        ArrayList<Ventaboletos> listado = new ArrayList<Ventaboletos>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Ventaboletos());
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
