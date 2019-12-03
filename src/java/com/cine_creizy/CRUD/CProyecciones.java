package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.entidad.Proyecciones;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CProyecciones {
    public CProyecciones(){}
    
    public void InsertarProyeccion(String HoraI, String HoraF, int idS, int idPe){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Proyecciones p = new Proyecciones();
            p.setHorainicio(HoraI);
            p.setHorafin(HoraF);
            p.setIdsala(idS);
            p.setIdpelicula(idPe);
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
    public void BorrarProyeccion(int id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Proyecciones p = new Proyecciones();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            p = Operaciones.eliminar(id, new Proyecciones());
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
    public Proyecciones MostrarProyecciones(int id){
        Proyecciones p = new Proyecciones();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        p = Operaciones.get(id, new Proyecciones());
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
    public void ActualizarProyecciones(int idP, String HoraI, String HoraF, int idS, int idPe){
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Proyecciones p = new Proyecciones();
            p.setHorainicio(HoraI);
            p.setHorafin(HoraF);
            p.setIdsala(idS);
            p.setIdpelicula(idPe);; 
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            p = Operaciones.actualizar(idP, p);
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
    public List<Proyecciones> MostrarTodoProyecciones(){
        ArrayList<Proyecciones> listado = new ArrayList<Proyecciones>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Proyecciones());
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
