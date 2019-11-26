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
                    int idventa = (int)sesion.getAttribute("esteid");
                    double precio = Double.parseDouble(c.MostrarComidas(id).getPrecio());
                    dvc.InsertarDetalleventacomida(id, cantidad, idventa,cantidad*precio+"");
                    sesion.setAttribute("Mostrar",true);
                    ArrayList<Detalleventacomida> listado = new ArrayList<Detalleventacomida>();
                    for(int i=0;i<dvc.MostrarTodoDetalleventacomida().size();i++){
                        if(dvc.MostrarTodoDetalleventacomida().get(i).getIdventacomida()==idventa){
                            listado.add(dvc.MostrarTodoDetalleventacomida().get(i));
                        }
                    }
                    sesion.setAttribute("listadodecompra", listado);
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
            String N = (String) sesion.getAttribute("Nombres");
            vc.InsertarVentacomida("0",N);
            int n=0;
            for(int i=0; i<vc.MostrarTodoVentacomida().size();i++){
                n=vc.MostrarTodoVentacomida().get(i).getIdventacomida();
            }
            sesion.setAttribute("esteid",n);
            response.sendRedirect("Principal?op=2");
        }
        if(accion.equals("CancelarVenta")){
            int idventa = (int)sesion.getAttribute("esteid");
            sesion.removeAttribute("Mostrar");
            sesion.setAttribute("MostrarCompra", false);
            ArrayList<Detalleventacomida> listado = new ArrayList<Detalleventacomida>();
            for(int i=0;i<dvc.MostrarTodoDetalleventacomida().size();i++){
                if(dvc.MostrarTodoDetalleventacomida().get(i).getIdventacomida()==idventa){
                    listado.add(dvc.MostrarTodoDetalleventacomida().get(i));
                }
            }
            for(int i=0;i<listado.size();i++){
                dvc.BorrarDetalleventacomida(listado.get(i).getIddetallecomida());
            }
            vc.BorrarVentacomida(idventa);
            response.sendRedirect("Principal?op=2");
        }
        if(accion.equals("VenderComida")){
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
