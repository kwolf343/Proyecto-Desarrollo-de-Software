
package com.cine_creizy.control;

import com.cine_creizy.CRUD.CUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Registro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("Usuario")!=null){
        String usuario = request.getParameter("usuario");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String targeta = request.getParameter("targeta");
        String email = request.getParameter("correo");
        String clave = request.getParameter("contra");
        String pais = request.getParameter("pais");
        int idpais = Integer.parseInt(pais);
        CUsuario u = new CUsuario();
        u.InsertarUsuario(usuario, nombre, apellido, email, clave, idpais, 2);
        sesion.setAttribute("InsertarBoleto",false);
        sesion.setAttribute("vacio",false);
        response.sendRedirect("Principal?op=7");
        }
        else{
            request.getRequestDispatcher("sesion.jsp").forward(request, response);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
