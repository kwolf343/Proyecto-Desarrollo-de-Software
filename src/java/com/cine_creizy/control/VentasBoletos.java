package com.cine_creizy.control;

import com.cine_creizy.CRUD.CAsientos;
import com.cine_creizy.CRUD.CBoletos;
import com.cine_creizy.CRUD.CProyecciones;
import com.cine_creizy.CRUD.CTipodeboletos;
import com.cine_creizy.CRUD.CVentaboletos;
import com.cine_creizy.entidad.Asientos;
import com.cine_creizy.entidad.Boletos;
import com.cine_creizy.entidad.Tipodeboletos;
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
        CBoletos bol = new CBoletos();
        CVentaboletos vb = new CVentaboletos();
        CAsientos as = new CAsientos();
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
            ArrayList<Tipodeboletos> b = new ArrayList<Tipodeboletos>();
            ArrayList<Integer> numeros = new ArrayList();
            sesion.setAttribute("ListadoDeLosBoletos", b);
            sesion.setAttribute("ListadoDeLosNumeros",numeros);
            sesion.setAttribute("Ventablts",true);
            sesion.setAttribute("to", 0);
            sesion.setAttribute("canti", 0);
            sesion.setAttribute("resultado",false);
            response.sendRedirect("Principal?op=1");
        }
        if(accion.equals("atras")){
            sesion.setAttribute("HoraBoletos",false);
            sesion.setAttribute("TBoletos",false);
            sesion.removeAttribute("ListadoDeLosBoletos");
            sesion.removeAttribute("ListadoDeLosNumeros");
            sesion.setAttribute("Ventablts", false);
            response.sendRedirect("Principal?op=1");
        }
        if(accion.equals("siguiente")){
            sesion.setAttribute("TBoletos",false);
            sesion.setAttribute("ABoletos",true);
            response.sendRedirect("Principal?op=1");
            
        }
        if(accion.equals("atras2")){
            sesion.setAttribute("TBoletos",true);
            sesion.setAttribute("ABoletos",false);
            response.sendRedirect("Principal?op=1");
        }
        if(accion.equals("agregar")){
            ArrayList<Tipodeboletos> b = (ArrayList<Tipodeboletos>) sesion.getAttribute("ListadoDeLosBoletos");
            ArrayList<Integer> numeros = (ArrayList<Integer>) sesion.getAttribute("ListadoDeLosNumeros");
            boolean repetido=false;
            int id = (int) sesion.getAttribute("IdCompraBoleto");
            int cantidad=0;
            double total=0;
            Integer cant = (Integer) sesion.getAttribute("CantidadBoletos");
            for(int i=0;i<b.size();i++){
                if(b.get(i).getIdtipodeboleto()==id){
                    numeros.set(i,cant);
                    repetido=true;
                }
            }
            if(repetido==false){
                CTipodeboletos Ctb = new CTipodeboletos();
                Tipodeboletos tipoDB = Ctb.MostrarTipodeboletos((int) sesion.getAttribute("IdCompraBoleto"));
                b.add(tipoDB);
                numeros.add(cant);
            }
            for(int i=0;i<numeros.size();i++){
                cantidad = cantidad+numeros.get(i);
                total = total+numeros.get(i)*b.get(i).getPrecio();
            }
            sesion.setAttribute("ListadoDeLosBoletos", b);
            sesion.setAttribute("ListadoDeLosNumeros",numeros);
            sesion.setAttribute("canti", cantidad);
            sesion.setAttribute("to", total);
            response.sendRedirect("Principal?op=1");
        }
        if(accion.equals("vender")){
            ArrayList<Tipodeboletos> b = (ArrayList<Tipodeboletos>) sesion.getAttribute("ListadoDeLosBoletos");
            ArrayList<Integer> numeros = (ArrayList<Integer>) sesion.getAttribute("ListadoDeLosNumeros");
            String[] ventas= request.getParameterValues("check");
            int contador=0;
            String N = (String) sesion.getAttribute("Usuario");
            vb.InsertarVentaboletos((double) sesion.getAttribute("to"), N);
            for(int i=0; i<b.size();i++){
                for(int j=0;j<numeros.get(i);j++){
                    bol.InsertarBoletos(b.get(i).getIdtipodeboleto(), (int) sesion.getAttribute("IdBoleto"),Integer.parseInt(ventas[contador]),vb.MostrarTodoVentaboletos().get((vb.MostrarTodoVentaboletos().size())-1).getIdventaboleto());
                    as.ActualizarAsientos(Integer.parseInt(ventas[contador]), as.MostrarAsientos(Integer.parseInt(ventas[contador])).getAsiento(),as.MostrarAsientos(Integer.parseInt(ventas[contador])).getIdsala(), 0);
                    contador++;
                }
            }
            sesion.setAttribute("resultado",true);
            sesion.setAttribute("HoraBoletos",false);
            sesion.setAttribute("TBoletos",false);
            sesion.setAttribute("ABoletos",false);
            sesion.removeAttribute("ListadoDeLosBoletos");
            sesion.removeAttribute("ListadoDeLosNumeros");
            sesion.setAttribute("Ventablts",false);
            response.sendRedirect("Principal?op=1");
        }
        if(accion.equals("CancelarFinalizar")){
            sesion.setAttribute("HoraBoletos",false);
            sesion.setAttribute("TBoletos",false);
            sesion.setAttribute("ABoletos",false);
            sesion.removeAttribute("ListadoDeLosBoletos");
            sesion.removeAttribute("ListadoDeLosNumeros");
            sesion.setAttribute("Ventablts",false);
            response.sendRedirect("Principal?op=1");
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
