package com.cinecreizy.reportes;

import com.cine_creizy.conexion.Conexion;
import com.cine_creizy.conexion.ConexionPool;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
@WebServlet(name = "Reportes", urlPatterns = {"/Reportes"})
public class Reporte extends HttpServlet {
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
     HttpSession sesion = request.getSession();
        if(sesion.getAttribute("Usuario")!=null){
     String accion = request.getParameter("accion");
 //Creamos la conexion
 Conexion cn = new ConexionPool();
 cn.conectar();
 Connection conexion=cn.getConexion();

 ServletContext context = request.getServletContext();

 //obtenemos el reporte (archivo .jasper) en un archivo de tipo file
 File reportFile = null;
 Map parameters = new HashMap();
 if(accion.equals("comida")){
     String parametro = request.getParameter("comer");
    reportFile = new File(context.getRealPath("/")+"Reportes/ReporteDeComidas.jasper");
    parameters.put("comida", parametro+ "");
 }
if(accion.equals("boletos")){
    String parametro = request.getParameter("user");
    reportFile = new File(context.getRealPath("/")+"Reportes/Reporteboletos.jasper");
    parameters.put("usuario",parametro+ "");
}
if(accion.equals("sala")){
    String parametro = request.getParameter("sal");
    reportFile = new File(context.getRealPath("/")+"Reportes/Reportesalas.jasper");
    parameters.put("salas",parametro+ "");
}
if(accion.equals("pelicula")){
    String parametro = request.getParameter("peli");
    reportFile = new File(context.getRealPath("/")+"Reportes/ReportePeliculasMasVistas.jasper");
    parameters.put("peliculas",parametro+ "");
}
 //configuramos los parametros en una varible de tipo Map
 //que como un array
 //para agregar mas parametro solo llame el metodo put() varias veces
 byte[] bytes = null;
 try {
 bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),parameters,conexion);
 } catch (JRException ex) {
 Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
 }
 response.setContentType("application/pdf");

 //para que el pdf se pueda ver en microsoft explorer
 //response.setHeader("Cache-Control", "cache");

 //para que aparezca el diálogo abrir/guardar
 //response.setHeader("Content-Disposition", "attachment; filename=reporte.pdf");

 response.setHeader("Content-Disposition", "inline; filename=ReporteDeComidas.pdf");
 response.setContentLength(bytes.length);
 try (ServletOutputStream ouputStream = response.getOutputStream()) {
 ouputStream.write(bytes, 0, bytes.length);
 ouputStream.flush();
 }
 }
else{
    request.getRequestDispatcher("Administrar.jsp").forward(request, response);
}
 }
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
        processRequest(request, response);     } 
 
    @Override     protected void doPost(HttpServletRequest request, HttpServletResponse response)             throws ServletException, IOException {         processRequest(request, response);     } 
 
}