package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.entidad.Comidas;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CComidas {
    public CComidas(){}
    public void InsertarComida(String nombre, Double cantidad, int existencias){
        DecimalFormat df = new DecimalFormat("#.00");
        String precio = String.valueOf(df.format(cantidad));
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Comidas c = new Comidas();
            c.setNombre(nombre);
            c.setPrecio(precio);
            c.setExistencia(existencias);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            c = Operaciones.insertar(c);
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
    public void BorrarComidas(int id){
        try {
                ConexionPool con = new ConexionPool();
                con.conectar();
                Comidas c = new Comidas();
                Operaciones.abrirConexion(con);
                Operaciones.iniciarTransaccion();
                c = Operaciones.eliminar(id, new Comidas());
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
    public Comidas MostrarComidas(int id){
        Comidas c = new Comidas();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        c = Operaciones.get(id, new Comidas());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return c;
    }
    public void ActualizarComidas(int id, String nombre, Double cantidad, int existencias){
        DecimalFormat df = new DecimalFormat("#.00");
        String precio = String.valueOf(df.format(cantidad));
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Comidas c = new Comidas();
            c.setNombre(nombre);
            c.setPrecio(precio);
            c.setExistencia(existencias);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            c = Operaciones.actualizar(id, c);
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
    public List<Comidas> MostrarTodoComidas(){
        ArrayList<Comidas> listado = new ArrayList<Comidas>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Comidas());
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
