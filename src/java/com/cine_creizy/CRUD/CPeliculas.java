package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.entidad.Peliculas;
import com.cine_creizy.operaciones.Operaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CPeliculas {
    public CPeliculas(){}
    public void InsertarPelicula(String titul, String durac, String sinop, String clasif, String gene, String fechaLlegada, String fechaSalida){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Peliculas p = new Peliculas();
            p.setTitulo(titul);
            p.setDuracion(durac);
            p.setSinopsis(sinop);
            p.setClasificacion(clasif);
            p.setGenero(gene);
            p.setFecha_De_Llegada(fechaLlegada);
            p.setFecha_De_Salida(fechaSalida);
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
 
    public void BorrarPelicula(int id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Peliculas p = new Peliculas();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            p = Operaciones.eliminar(id, new Peliculas());
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
 
    public Peliculas MostrarPelicula(int id){
        Peliculas p = new Peliculas();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        p = Operaciones.get(id, new Peliculas());
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
    public void ActualizarPelicula(int idpeli, String titul, String durac, String sinop, String clasif, String gene, String fechaLlegada, String fechaSalida){
        try {
            ConexionPool con = new ConexionPool(); 
            con.conectar();
            Peliculas p = new Peliculas();
            p.setTitulo(titul);
            p.setDuracion(durac);
            p.setSinopsis(sinop);
            p.setClasificacion(clasif);
            p.setGenero(gene);
            p.setFecha_De_Llegada(fechaLlegada);
            p.setFecha_De_Salida(fechaSalida);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            p = Operaciones.actualizar(idpeli, p);
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
 
    public List<Peliculas> MostrarTodoPeliculas(){
        ArrayList<Peliculas> listado = new ArrayList<Peliculas>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Peliculas());
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
