package com.cine_creizy.control;

import com.cine_creizy.CRUD.CComidas;
import com.cine_creizy.CRUD.CDetalleventacomida;
import com.cine_creizy.CRUD.CVentacomida;
import com.cine_creizy.entidad.Detalleventacomida;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Ventas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String accion = request.getParameter("accion");
        CComidas c = new CComidas();
        CDetalleventacomida dvc = new CDetalleventacomida();
        CVentacomida vc = new CVentacomida();
        if(accion.equals("Vender")){
            if(sesion.getAttribute("MostrarCompra")!=null){
                if(sesion.getAttribute("MostrarCompra").equals(true)){
                    int id = (int)sesion.getAttribute("IdCompraComida");
                    int cantidad = (int)sesion.getAttribute("CantidadComida");
                    double precio = c.MostrarComidas(id).getPrecio();  
                    sesion.setAttribute("Mostrar",true);
                    ArrayList<Detalleventacomida> listado = (ArrayList<Detalleventacomida>) sesion.getAttribute("listadoN1");
                    Detalleventacomida d = new Detalleventacomida(0,id,cantidad,0, cantidad*precio);
                    listado.add(d);
                    double j=0;
                    for(int i=0;i<listado.size();i++){
                        j=j+listado.get(i).getTotal();
                    }
                    sesion.setAttribute("TotalPrecioComida", j);
                    sesion.setAttribute("listadoN1",listado);
                    response.sendRedirect("Principal?op=2");
                }
                else{
                    response.sendRedirect("Principal?op=2");
                }
            }
            else{
                response.sendRedirect("Principal?op=2");
            }
        }
        if(accion.equals("IniciarVenta")){
            sesion.setAttribute("MostrarCompra", true);
            ArrayList<Detalleventacomida> listado = new ArrayList<Detalleventacomida>();
            sesion.setAttribute("listadoN1",listado);
            sesion.setAttribute("TotalPrecioComida", 0);
            response.sendRedirect("Principal?op=2");
        }
        if(accion.equals("CancelarVenta")){
            sesion.removeAttribute("Mostrar");
            sesion.setAttribute("MostrarCompra", false);
            response.sendRedirect("Principal?op=2");
        }
        if(accion.equals("VenderComida")){
            sesion.setAttribute("finalComida",true);
            sesion.removeAttribute("Mostrar");
            sesion.setAttribute("MostrarCompra", false);
            sesion.setAttribute("ventaF", true);
            String N = (String) sesion.getAttribute("Usuario");
            vc.InsertarVentacomida(0, N);
            ArrayList<Detalleventacomida> listado = (ArrayList<Detalleventacomida>) sesion.getAttribute("listadoN1");
            for(int i=0; i<listado.size();i++){
                dvc.InsertarDetalleventacomida(listado.get(i).getIdcomida(), listado.get(i).getCantidadcomida(),
                        vc.MostrarTodoVentacomida().get(vc.MostrarTodoVentacomida().size()-1).getIdventacomida(),
                        c.MostrarComidas(listado.get(i).getIdcomida()).getPrecio()*listado.get(i).getCantidadcomida());
            }
            vc.ActualizarVentacomida(vc.MostrarTodoVentacomida().get(vc.MostrarTodoVentacomida().size()-1).getIdventacomida(), (double) sesion.getAttribute("TotalPrecioComida"), N);
            response.sendRedirect("Principal?op=2");
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
