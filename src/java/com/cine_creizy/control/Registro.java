
package com.cine_creizy.control;

import com.cine_creizy.CRUD.CUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienbenido "+nombre+" "+apellido+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
