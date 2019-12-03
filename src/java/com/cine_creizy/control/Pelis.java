package com.cine_creizy.control;

import com.cine_creizy.CRUD.CPeliculas;
import com.cine_creizy.CRUD.CProyecciones;
import com.cine_creizy.entidad.Peliculas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Pelis extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("Usuario")!=null){
        String accion = request.getParameter("accion");
        Peliculas peli = new Peliculas();
        CPeliculas p = new CPeliculas();
        CProyecciones proyeccion = new CProyecciones();
        if(accion.equals("BorraPelicula")){
            int n = (int)sesion.getAttribute("IdPelicula");
            boolean proyecomp = false;
            for(int i=0;i<proyeccion.MostrarTodoProyecciones().size();i++){
                if(proyeccion.MostrarTodoProyecciones().get(i).getIdpelicula()==n){
                    proyecomp = true;
                }
            }
            if(proyecomp==true){
                sesion.setAttribute("proyecomp",true);
            }
            p.BorrarPelicula(n);
            response.sendRedirect("Principal?op=3");
        }        
        else if(accion.equals("Actualiza")){
            int num = (int)sesion.getAttribute("IdPelicula");
            peli = p.MostrarPelicula(num);
            sesion.setAttribute("TituloPeli",peli.getTitulo());
            sesion.setAttribute("DuracionPeli",peli.getDuracion());
            sesion.setAttribute("SinopsisPeli",peli.getSinopsis());
            sesion.setAttribute("ClasificacionPeli",peli.getClasificacion());
            sesion.setAttribute("GenerosPeli",peli.getGenero());
            sesion.setAttribute("FechaLlegadaPeli",peli.getFecha_De_Llegada());
            sesion.setAttribute("FechaSalidaPeli",peli.getFecha_De_Salida());
            response.sendRedirect("Principal?op=9");
        }
        else if(accion.equals("ActualizarPelicula")){
            int n = (int)sesion.getAttribute("IdPelicula");
            String titulo = request.getParameter("tituloP");
            String hora = request.getParameter("hora");
            String minuto = request.getParameter("minuto");
            String segundo = request.getParameter("segundo");
            String clasificacion = request.getParameter("clasificacion"); 
            String generos = request.getParameter("generos"); 
            String estreno = request.getParameter("estreno");
            String salida = request.getParameter("salida");
            String sinopsis = request.getParameter("sinopsisP");
            boolean peliculacomp=false;
            for(int i=0;i<p.MostrarTodoPeliculas().size();i++){
                if(p.MostrarTodoPeliculas().get(i).getTitulo().toUpperCase().equals(titulo.toUpperCase())){
                    peliculacomp = true;
                }
            }
            if(peliculacomp==true){
                sesion.setAttribute("peliculacomp",true);
            }
            else{
                p.ActualizarPelicula(n, titulo,hora+":"+minuto+":"+segundo, sinopsis, clasificacion, generos, estreno, salida);
                sesion.setAttribute("TituloPeli",titulo);
                sesion.setAttribute("DuracionPeli",hora+":"+minuto+":"+segundo);
                sesion.setAttribute("SinopsisPeli",sinopsis);
                sesion.setAttribute("ClasificacionPeli",clasificacion);
                sesion.setAttribute("GenerosPeli",generos);
                sesion.setAttribute("FechaLlegadaPeli",estreno);
                sesion.setAttribute("FechaSalidaPeli",salida);
                sesion.setAttribute("peliculacomp",false);
            }
            response.sendRedirect("Principal?op=9");
        }
        if(accion.equals("Agregarpeli")){
            String titulo = request.getParameter("titulo");
            String hora = request.getParameter("hora");
            String minuto = request.getParameter("minuto");
            String segundo = request.getParameter("segundo");
            String clasificacion = request.getParameter("clasificacion");
            String generos = request.getParameter("generos");
            String estreno = request.getParameter("estreno");
            String salida = request.getParameter("salida");
            String sinopsis = request.getParameter("sinopsis");
            p.InsertarPelicula(titulo, hora+":"+minuto+":"+segundo, sinopsis, clasificacion, generos, estreno, salida);
            response.sendRedirect("Principal?op=3");
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
