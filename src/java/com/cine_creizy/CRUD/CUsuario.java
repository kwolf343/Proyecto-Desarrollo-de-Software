
package com.cine_creizy.CRUD;

import com.cine_creizy.conexion.ConexionPool;
import com.cine_creizy.control.Principal;
import com.cine_creizy.entidad.Usuario;
import com.cine_creizy.operaciones.Operaciones;
import com.cine_creizy.utilerias.Hash;
import static com.cine_creizy.utilerias.Hash.SHA256;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CUsuario {
    public CUsuario(){}

    public void InsertarUsuario(String id, String nombre, String apellido, String mail, String contra, int pais, int rol){
        Hash h = new Hash();
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Usuario u = new Usuario();
            u.setIdusuario(id);
            u.setNombres(nombre);
            u.setApellidos(apellido);
            u.setEmail(mail);
            u.setClave(h.generarHash(contra,SHA256));
            u.setIdpais(pais);
            u.setIdrol(rol);
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            u = Operaciones.insertar(u);
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
    public void BorrarUsuario(String id){
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Usuario u = new Usuario();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            u = Operaciones.eliminar(id, new Usuario());
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
    public Usuario MostrarUsuario(String id){
        Usuario u = new Usuario();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        u = Operaciones.get(id, new Usuario());
        } catch(Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
        Operaciones.cerrarConexion();
        } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return u;
    }
    public void ActualizarUsuario(String id, String nombre, String apellido, String mail, String contra, int pais, int rol){
        BorrarUsuario(id);
        InsertarUsuario(id, nombre, apellido, mail, contra, pais, rol);
    }
    public List<Usuario> MostrarTodoUsuario(){
        ArrayList<Usuario> listado = new ArrayList<Usuario>();
        try {
        ConexionPool con = new ConexionPool();
        con.conectar();
        Operaciones.abrirConexion(con);
        listado = Operaciones.getTodos(new Usuario());
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
