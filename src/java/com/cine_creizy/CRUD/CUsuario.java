
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

    public void InsertarUsuario(String id, String nombre, String apellido, String target, String mail, String contra, int pais, int rol){
        Hash h = new Hash();
        try {
            ConexionPool con = new ConexionPool();
            con.conectar();
            Usuario u = new Usuario();
            u.setIdusuario(id);
            u.setNombres(nombre);
            u.setApellidos(apellido);
            u.setTargeta(target);
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
    public void ActualizarUsuario(String id, int numero, String dato){
        Usuario user = new Usuario();
        user = MostrarUsuario(id);
        Hash h = new Hash();
        String n = user.getNombres();
        String a = user.getApellidos();
        String t = user.getTargeta();
        String e = user.getEmail();
        String c = user.getClave();
        int p = user.getIdpais();
        int r = user.getIdrol();
        // 1: Nombre
        // 2: Apellido
        // 3: Targeta
        // 4: Email
        // 5: Clave
            switch(numero){
                case 1:
                    BorrarUsuario(id);
                    InsertarUsuario(id,dato,a,t,e,c,p,r);
                    break;
                case 2:
                    BorrarUsuario(id);
                    InsertarUsuario(id,n,dato,t,e,c,p,r);
                    break;
                case 3:
                    BorrarUsuario(id);
                    InsertarUsuario(id,n,a,dato,e,c,p,r);
                    break;
                case 4:
                    BorrarUsuario(id);
                    InsertarUsuario(id,n,a,t,dato,c,p,r);
                    break;
                case 5:
                    BorrarUsuario(id);
                    InsertarUsuario(id,n,a,t,e,h.generarHash(dato,SHA256),p,r);
                    break;
            }
    }
    public void ActualizarUsuario(String id, int numero, int dato){
        Usuario user = new Usuario();
        user = MostrarUsuario(id);
        String n = user.getNombres();
        String a = user.getApellidos();
        String t = user.getTargeta();
        String e = user.getEmail();
        String c = user.getClave();
        int p = user.getIdpais();
        int r = user.getIdrol();
        // 6: pais
        // 7: rol
            switch(numero){
                case 6:
                    BorrarUsuario(id);
                    InsertarUsuario(id,n,a,t,e,c,dato,r);
                    break;
                case 7:
                    BorrarUsuario(id);
                    InsertarUsuario(id,n,a,t,e,c,p,dato);
                    break;
            }
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
