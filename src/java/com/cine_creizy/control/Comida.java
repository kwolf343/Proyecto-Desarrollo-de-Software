package com.cine_creizy.control;

import com.cine_creizy.CRUD.CComidas;
import com.cine_creizy.entidad.Comidas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Comida extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("Usuario")!=null){
        String accion = request.getParameter("accion");
        CComidas c = new CComidas();
        if(accion.equals("ActualizaComida")){
            String nombre = request.getParameter("nombre");
            String precio = request.getParameter("precio");
            String existencias = request.getParameter("existencias");
            boolean nombrecom = false;
            for(int i=0;i<c.MostrarTodoComidas().size();i++){
                if(c.MostrarTodoComidas().get(i).getNombre().toUpperCase().equals(nombre.toUpperCase())){
                    nombrecom = true;
                }
            }
            if(nombrecom==true){
                sesion.setAttribute("nombrecom",true);
            }
            else{
                c.ActualizarComidas((int)sesion.getAttribute("IdComida"),nombre,Double.parseDouble(precio), Integer.parseInt(existencias));
                sesion.setAttribute("nombrecom",false);
            } 
            response.sendRedirect("Principal?op=5");
        }
        else if(accion.equals("Modificar")){
            int id = (int)sesion.getAttribute("IdComida");
            Comidas comer = new Comidas();
            comer = c.MostrarComidas(id);
            sesion.setAttribute("comida",comer.getNombre());
            sesion.setAttribute("IdComida",comer.getIdcomida());
            response.sendRedirect("Principal?op=8");
        }
        else if(accion.equals("agregar")){
            int num = 1;
            for(int i=0; i<c.MostrarTodoComidas().size();i++){
                if(num==c.MostrarTodoComidas().get(i).getIdcomida()){
                    num++;
                }
            }
            String nombre = request.getParameter("checkNombre");
            String precio = request.getParameter("checkPrecio");
            String existencias = request.getParameter("checkExistencias");
            boolean nombrecom = false;
            for(int i=0;i<c.MostrarTodoComidas().size();i++){
                if(c.MostrarTodoComidas().get(i).getNombre().toUpperCase().equals(nombre.toUpperCase())){
                    nombrecom = true;
                }
            }
            if(nombrecom==true){
                sesion.setAttribute("nombrecom",true);
            }
            else{
                c.InsertarComida(nombre, Double.parseDouble(precio),Integer.parseInt(existencias));
                sesion.setAttribute("nombrecom",false);
            }
            response.sendRedirect("Principal?op=5");
        }
        else if(accion.equals("Borrar")){
            int id = (int)sesion.getAttribute("IdComida");
            c.BorrarComidas(id);
            response.sendRedirect("Principal?op=5");
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
