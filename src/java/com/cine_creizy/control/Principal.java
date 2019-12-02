package com.cine_creizy.control;

import com.cine_creizy.CRUD.CComidas;
import com.cine_creizy.CRUD.CDetalleventacomida;
import com.cine_creizy.CRUD.CPaises;
import com.cine_creizy.CRUD.CPeliculas;
import com.cine_creizy.CRUD.CProyecciones;
import com.cine_creizy.CRUD.CRoles;
import com.cine_creizy.CRUD.CSalas;
import com.cine_creizy.CRUD.CTipodeboletos;
import com.cine_creizy.CRUD.CUsuario;
import com.cine_creizy.CRUD.CVentacomida;
import com.cine_creizy.entidad.Detalleventacomida;
import com.cine_creizy.entidad.Menu;
import com.cine_creizy.entidad.Paises;
import com.cine_creizy.entidad.Proyecciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name= "Principal", urlPatterns = {"/Principal"})
public class Principal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("Usuario")==null){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        String accion = request.getParameter("accion");
        if (accion == null){
            CargarRecursos(request, response);
            HttpSession s = request.getSession();
            List<Menu> per = (List<Menu>)s.getAttribute("Permisos");
            List<Menu> MenuPrincipal = per.stream().filter(field -> field.getIdpadre()==0).collect(Collectors.toList());
            request.setAttribute("MenuPrincipal", MenuPrincipal);
            String op = request.getParameter("op");
            if(op!=null){
                List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre()==Integer.parseInt(op)).collect(Collectors.toList());
                request.setAttribute("PermisosAsignados", PermisosAsignados);
                switch(op){
                    case "1":
                        Anular(request, response);
                        request.getRequestDispatcher("venderBoletos/ventas.jsp").forward(request, response);
                        break;
                    case "2":
                        Anular(request, response);
                        request.getRequestDispatcher("venderComida/ventas.jsp").forward(request, response);
                        break;
                    case "3":
                        Anular(request, response);
                        request.getRequestDispatcher("peliculas/AdministrarPeliculas.jsp").forward(request, response);
                        break;
                    case "4":
                        Anular(request, response);
                        request.getRequestDispatcher("cartelera/AdministrarCartelera.jsp").forward(request, response);
                        break;
                    case "5":
                        Anular(request, response);
                        request.getRequestDispatcher("comidas/AdministrarComida.jsp").forward(request, response);
                        break;
                    case "6":
                        Anular(request, response);
                        request.getRequestDispatcher("boletos/AdministrarBoletos.jsp").forward(request, response);
                        break;
                    case "7":
                        request.getRequestDispatcher("usuarios/AdministrarUsuarios.jsp").forward(request, response);
                        break;
                    case "8":
                        if(sesion.getAttribute("comida")==null)
                            request.getRequestDispatcher("comidas/AdministrarComida.jsp").forward(request, response);
                        else
                            request.getRequestDispatcher("comidas/ActualizaComida.jsp").forward(request, response);
                        break;
                    case "9":
                        if(sesion.getAttribute("IdPelicula")==null)
                            request.getRequestDispatcher("peliculas/AdministrarPeliculas.jsp").forward(request, response);
                        else
                            request.getRequestDispatcher("peliculas/InfoPelicula.jsp").forward(request, response);
                        break;
                    case "10":
                        if(sesion.getAttribute("IdPelicula")==null)
                            request.getRequestDispatcher("peliculas/AdministrarPeliculas.jsp").forward(request, response);
                        else
                            request.getRequestDispatcher("peliculas/ActualizaPelicula.jsp").forward(request, response);
                        break;
                    case "11":
                        request.getRequestDispatcher("peliculas/AgregaPelicula.jsp").forward(request, response);
                        break;
                    case "12":
                        if(sesion.getAttribute("FormatoTipoBoletos")==null)
                            request.getRequestDispatcher("boletos/AdministrarBoletos.jsp").forward(request, response);
                        else
                        request.getRequestDispatcher("boletos/ActualizarBoletos.jsp").forward(request, response);
                        break;
                    case "13":
                        if(sesion.getAttribute("IdCartelera")==null)
                            request.getRequestDispatcher("cartelera/AdministrarCartelera.jsp").forward(request, response);
                        else
                            request.getRequestDispatcher("cartelera/MostrarCartelera.jsp").forward(request, response);
                        break;
                    case "14":
                        if(sesion.getAttribute("IdCartelera")==null)
                            request.getRequestDispatcher("cartelera/AdministrarCartelera.jsp").forward(request, response);
                        else
                            request.getRequestDispatcher("cartelera/ActualizarCartelera.jsp").forward(request, response);
                        break;
                }
            }
            request.getRequestDispatcher("Administrar.jsp").forward(request, response);
        }else if (accion.equals("logout")){
            logout(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.removeAttribute("Usuario");
        sesion.removeAttribute("Nombre");
        sesion.removeAttribute("Apellido");
        sesion.removeAttribute("Rol");
        sesion.invalidate();
        response.sendRedirect("Login");
    }
    private void CargarRecursos(HttpServletRequest request, HttpServletResponse response){
        HttpSession sesion = request.getSession();
        CUsuario u = new CUsuario();
        CPaises p = new CPaises();
        CRoles r = new CRoles();
        CComidas c = new CComidas();
        CPeliculas peli = new CPeliculas();
        CTipodeboletos tb = new CTipodeboletos();
        CProyecciones pro = new CProyecciones();
        CSalas s = new CSalas();
        sesion.setAttribute("ListaUsuarios",u.MostrarTodoUsuario());
        sesion.setAttribute("ListaPaises",p.MostrarTodoPaises());
        sesion.setAttribute("ListaRoles",r.MostrarTodoRoles());
        sesion.setAttribute("ListaPeliculas",peli.MostrarTodoPeliculas());
        sesion.setAttribute("ListaComidas",c.MostrarTodoComidas());
        sesion.setAttribute("ListaTipodeBoletos",tb.MostrarTodoTipodeboletos());
        sesion.setAttribute("ListaProyecciones",pro.MostrarTodoProyecciones());
        sesion.setAttribute("ListaSalas",s.MostrarTodoSalas());
        sesion.setAttribute("estaPelicula",peli);
        sesion.setAttribute("estaSala",s);
        sesion.setAttribute("estaComida",c);
        sesion.setAttribute("estaProyeccion",pro);
        Proyeccion(request, response);
    }
    private void Anular(HttpServletRequest request, HttpServletResponse response){
        HttpSession sesion = request.getSession();
        sesion.setAttribute("IdPelicula", null);
        sesion.setAttribute("IdCartelera",null);
        sesion.setAttribute("comida", null);
        sesion.setAttribute("FormatoTipoBoletos", null);
    }
    private void Proyeccion(HttpServletRequest request, HttpServletResponse response){
        HttpSession sesion = request.getSession();
        CProyecciones proyeccion = new CProyecciones();
        Proyecciones p = new Proyecciones();
        int cont =1;
        Proyecciones pro[] = new Proyecciones[proyeccion.MostrarTodoProyecciones().size()];
        for(int i=0; i<proyeccion.MostrarTodoProyecciones().size();i++){
            pro[i] = proyeccion.MostrarTodoProyecciones().get(i);
        }
        for(int i=0; i<proyeccion.MostrarTodoProyecciones().size();i++){
            for(int j=0; j<proyeccion.MostrarTodoProyecciones().size()-1;j++){
                if(pro[j].getIdpelicula()>pro[j+1].getIdpelicula()){
                    p = pro[j];
                    pro[j] = pro[j+1];
                    pro[j+1] = p;
                }
            }
        }
        for(int i=1; i<proyeccion.MostrarTodoProyecciones().size();i++){
            if(pro[i-1].getIdpelicula()!=pro[i].getIdpelicula()){
                cont++;
            }
        }
        sesion.setAttribute("contadorabc", cont);
        sesion.setAttribute("Proyecction2", pro);
        int[] numeros = new int[cont];
        int cont2=0;
        for(int i=0; i<cont;i++){
            numeros[i]=1;
        }
        int c=0;
        for(int i=0; i<proyeccion.MostrarTodoProyecciones().size()-1;i++){
            if(pro[i+1].getIdpelicula()==pro[i].getIdpelicula()){
                numeros[c]=numeros[c]+1;
            }
            else{
                c++;
            }
        }
        Proyecciones[][] matriz = new Proyecciones[cont][];
        for(int i=0; i<cont;i++){
            matriz[i] = new Proyecciones[numeros[i]];
        }
        int contar=0;
        for(int i=0; i<cont; i++){
            for(int j=0; j<numeros[i];j++){
                matriz[i][j] = pro[contar];
                contar++;
            }
        }
        sesion.setAttribute("ListadoPrueba",matriz);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
