package com.cine_creizy.control;

import com.cine_creizy.CRUD.CTipodeboletos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Boleto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("Usuario")!=null){
            String accion = request.getParameter("accion");
            CTipodeboletos tb = new CTipodeboletos();
        if(accion.equals("Modificar")){        
            int id = (int)sesion.getAttribute("IdTipoBoletos");
            sesion.setAttribute("FormatoTipoBoletos",tb.MostrarTipodeboletos(id).getFormato());
            sesion.setAttribute("TipoTipoBoletos",tb.MostrarTipodeboletos(id).getTipo());
            response.sendRedirect("Principal?op=12");
        }
        if(accion.equals("Borrar")){
            int id = (int)sesion.getAttribute("IdTipoBoletos");
            tb.BorrarTipodeboletos(id);
            response.sendRedirect("Principal?op=6");
        }
        if(accion.equals("ActualizaBoleto")){
            int id = (int)sesion.getAttribute("IdTipoBoletos");        
            String precio = request.getParameter("precio");
            double p = Double.parseDouble(precio);
            String f = (String)sesion.getAttribute("FormatoTipoBoletos");
            String t = (String)sesion.getAttribute("TipoTipoBoletos");
            tb.ActualizarTipodeboletos(id,f,t, p);
            response.sendRedirect("Principal?op=12");
        }
        if(accion.equals("AgregaBoleto")){
            String formato = request.getParameter("formato");
            String tipo = request.getParameter("tipo");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            boolean tipoblt = false; 
            for(int i=0;i<tb.MostrarTodoTipodeboletos().size();i++){
                if(tb.MostrarTodoTipodeboletos().get(i).getFormato().toUpperCase().equals(formato.toUpperCase())){
                    if(tb.MostrarTodoTipodeboletos().get(i).getTipo().toUpperCase().equals(tipo.toUpperCase())){
                        tipoblt = true;
                    }
                }
            }
            if(tipoblt==true){
                sesion.setAttribute("tipo123",true);
            }
            else{
                tb.InsertarTipodeboletos(formato, tipo, precio);
                sesion.setAttribute("tipo123",false);
            }
            
            response.sendRedirect("Principal?op=6");
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
