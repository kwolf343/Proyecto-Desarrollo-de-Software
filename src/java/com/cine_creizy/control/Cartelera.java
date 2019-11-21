package com.cine_creizy.control;

import com.cine_creizy.CRUD.CPeliculas;
import com.cine_creizy.CRUD.CProyecciones;
import com.cine_creizy.CRUD.CSalas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Cartelera extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String accion = request.getParameter("accion");
        CProyecciones p = new CProyecciones();
        if(accion.equals("info")){
            CSalas s = new CSalas();
            CPeliculas peli = new CPeliculas();
            int n = (int)sesion.getAttribute("IdCartelera");
            sesion.setAttribute("IdProyeccion",p.MostrarProyecciones(n).getIdpelicula());
            sesion.setAttribute("HoraInicioProyeccion",p.MostrarProyecciones(n).getHorainicio());
            sesion.setAttribute("HoraFinProyeccion",p.MostrarProyecciones(n).getHorafin());
            sesion.setAttribute("SalaProyeccion",s.MostrarSalas(p.MostrarProyecciones(n).getIdsala()).getSala());
            sesion.setAttribute("PeliculaProyeccion",peli.MostrarPelicula(p.MostrarProyecciones(n).getIdpelicula()).getTitulo());
            response.sendRedirect("Principal?op=13");
        }
        if(accion.equals("BorraCartelera")){
            int n = (int)sesion.getAttribute("IdCartelera");
            p.BorrarProyeccion(n);
            response.sendRedirect("Principal?op=4");
        }
        if(accion.equals("ActualizaCartelera")){
            CSalas s = new CSalas();
            CPeliculas peli = new CPeliculas();
            int idPeli = Integer.parseInt(request.getParameter("Pelicula"));
            String horaInicio = request.getParameter("HoradeInicio");
            String horaFin = request.getParameter("HoradeFin");
            int idSala = Integer.parseInt(request.getParameter("Sala"));
            p.ActualizarProyecciones((int)sesion.getAttribute("IdCartelera"), horaInicio, horaFin, idSala, idPeli);
            sesion.setAttribute("HoraInicioProyeccion",horaInicio);
            sesion.setAttribute("HoraFinProyeccion",horaInicio);
            sesion.setAttribute("PeliculaProyeccion",peli.MostrarPelicula(idPeli).getTitulo());
            sesion.setAttribute("SalaProyeccion",s.MostrarSalas(idSala).getSala());
            response.sendRedirect("Principal?op=13");
        }
        if(accion.equals("AgregarCartelera")){
            int idPeli = Integer.parseInt(request.getParameter("Pelic"));
            String horaInicio = request.getParameter("HoradeInicio");
            String horaFin = request.getParameter("HoradeFin");
            int idSala = Integer.parseInt(request.getParameter("Sala"));
            p.InsertarProyeccion(horaInicio, horaFin, idSala, idPeli);
            response.sendRedirect("Principal?op=4");
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
