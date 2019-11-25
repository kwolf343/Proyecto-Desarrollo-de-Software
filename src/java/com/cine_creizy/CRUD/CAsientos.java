package com.cine_creizy.CRUD;
import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.cine_creizy.entidad.Asientos;

public class CAsientos {
    public CAsientos(){}
    
    public void InsertarAsientos(String asiento, int idsala, int disponible){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Asientos a = new Asientos();
            a.setAsiento(asiento);
            a.setIdsala(idsala);
            a.setDisponible(disponible);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            a = Operaciones.insertar(a);
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
    public void BorrarAsientos(int id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Asientos a = new Asientos();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            a = Operaciones.eliminar(id, new Asientos());
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
    
    public Asientos MostrarAsientos(int id){
        Asientos a = new Asientos();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        a = Operaciones.get(id, new Asientos());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return a;
    }
    
    public void ActualizarAsientos(int id, String asiento, int idsala, int disponible){
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Asientos a = new Asientos();
            a.setAsiento(asiento);
            a.setIdsala(idsala);
            a.setDisponible(disponible);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            a = Operaciones.actualizar(id, a);
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
    
    
    public List<Asientos> MostrarTodoAsientos(){
        ArrayList<Asientos> listado = new ArrayList<Asientos>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Asientos());
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