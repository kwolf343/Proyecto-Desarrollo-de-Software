package com.cine_creizy.control;

import com.cine_creizy.CRUD.CComidas;
import com.cine_creizy.CRUD.CPeliculas;
import com.cine_creizy.entidad.Comidas;
import com.cine_creizy.entidad.Peliculas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class redirecciona extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String accion = request.getParameter("accion");
        int num = Integer.parseInt(accion);
        if(num<2000){
            sesion.setAttribute("IdComida",num-1000);     
            response.sendRedirect("Comida?accion=Borrar");
        }
        if(num>2000&&num<3000){
            sesion.setAttribute("IdComida",num-2000);     
            response.sendRedirect("Comida?accion=Modificar");
        }
        if(num>3000&&num<4000){
            sesion.setAttribute("IdPelicula",num-3000);
            response.sendRedirect("Pelis?accion=Actualiza");
        }
        if(num>4000&&num<5000){
            sesion.setAttribute("IdTipoBoletos",num-4000);
            response.sendRedirect("Boleto?accion=Modificar");
        }
        if(num>5000&&num<6000){
            sesion.setAttribute("IdTipoBoletos",num-5000);
            response.sendRedirect("Boleto?accion=Borrar");
        }
        if(num>6000&&num<7000){
            sesion.setAttribute("IdCartelera",num-6000);
            response.sendRedirect("Cartelera?accion=info");
        }
        if(num>7000&&num<8000){
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            sesion.setAttribute("IdCompraComida", num-7000);
            sesion.setAttribute("CantidadComida",cantidad);
            response.sendRedirect("Ventas?accion=Vender");
        }
        if(num>8000&&num<9000){
            sesion.setAttribute("IdBoleto", num-8000);
            response.sendRedirect("VentasBoletos?accion=Horario");
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
