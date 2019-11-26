package com.cine_creizy.control;

import com.cine_creizy.CRUD.CAsientos;
import com.cine_creizy.CRUD.CProyecciones;
import com.cine_creizy.entidad.Asientos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VentasBoletos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String accion = request.getParameter("accion");
        if(accion.equals("Horario")){
            sesion.setAttribute("HoraBoletos",true);
            sesion.setAttribute("TBoletos",true);
            CProyecciones p = new CProyecciones();
            int number = p.MostrarProyecciones((int) sesion.getAttribute("IdBoleto")).getIdsala();
            ArrayList<Asientos> a = new ArrayList<Asientos>();
            CAsientos asi = new CAsientos();
            for(int i=0;i<asi.MostrarTodoAsientos().size();i++){
                if(asi.MostrarTodoAsientos().get(i).getIdsala() == number){
                    a.add(asi.MostrarTodoAsientos().get(i));
                }
            }
            sesion.setAttribute("Listado3",a);
            response.sendRedirect("Principal?op=1");
        }
        if(accion.equals("cancelar")){
            sesion.setAttribute("HoraBoletos",false);
            sesion.setAttribute("TBoletos",false);
            response.sendRedirect("Principal?op=1");
        }
        if(accion.equals("siguiente")){
            sesion.setAttribute("TBoletos",false);
            sesion.setAttribute("ABoletos",true);
            response.sendRedirect("Principal?op=1");
            
        }
        if(accion.equals("cancelar2")){
            
        }
        if(accion.equals("siguiente2")){}
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
