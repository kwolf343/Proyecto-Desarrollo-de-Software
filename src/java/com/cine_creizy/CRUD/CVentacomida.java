package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.entidad.Ventacomida;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CVentacomida {
    public CVentacomida(){}
    public void InsertarVentacomida(String total, String vendedor){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Ventacomida vc = new Ventacomida();
            vc.setTotal(total);
            vc.setVendedor(vendedor);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            vc = Operaciones.insertar(vc);
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
    public void BorrarVentacomida(int id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Ventacomida vc = new Ventacomida();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            vc = Operaciones.eliminar(id, new Ventacomida());
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
    public Ventacomida MostrarVentacomida(int id){
        Ventacomida vc = new Ventacomida();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        vc = Operaciones.get(id, new Ventacomida());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return vc;
    }
    public void ActualizarVentacomida(int id, String total, String vendedor){
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Ventacomida vc = new Ventacomida();
            vc.setTotal(total);
            vc.setVendedor(vendedor);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            vc = Operaciones.actualizar(id, vc);
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
    public List<Ventacomida> MostrarTodoVentacomida(){
        ArrayList<Ventacomida> listado = new ArrayList<Ventacomida>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Ventacomida());
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
