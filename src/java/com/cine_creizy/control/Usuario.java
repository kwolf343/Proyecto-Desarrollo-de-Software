package com.cine_creizy.control;

import com.cine_creizy.CRUD.CUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Usuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("Usuario")!=null){
        String accion = request.getParameter("accion");
        CUsuario u = new CUsuario();
        if(accion.equals("BorrarUsuario")){
            if(request.getParameterValues("check") == null) {
                sesion.setAttribute("vacio",true);
                response.sendRedirect("Principal?op=7");
            }
            else{
                String[] usuarios = request.getParameterValues("check");
                for(int i=0; i<usuarios.length;i++){
                    if(u.MostrarUsuario(usuarios[i]).getIdusuario().equals((String) sesion.getAttribute("Usuario"))){
                        sesion.setAttribute("restriccionU", true);
                    }
                    else{
                        u.BorrarUsuario(usuarios[i]);
                    }
                }
                sesion.setAttribute("vacio",false);
                response.sendRedirect("Principal?op=7");
            }
            }
        if(accion.equals("nuevo")){
            sesion.setAttribute("InsertarBoleto",true);
            response.sendRedirect("Principal?op=7");
        }
        if(accion.equals("cancelar")){
            sesion.setAttribute("vacio",false);
            sesion.setAttribute("InsertarBoleto",false);
            response.sendRedirect("Principal?op=7");
        }
        }
        else{
            request.getRequestDispatcher("sesion.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
