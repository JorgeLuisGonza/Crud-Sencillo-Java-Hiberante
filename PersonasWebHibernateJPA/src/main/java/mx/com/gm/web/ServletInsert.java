package mx.com.gm.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.ServicioPersonas;

@WebServlet("/ServletInsert")
public class ServletInsert extends HttpServlet {
    
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response){
         String nombre = request.getParameter("nombre");
         String apellido = request.getParameter("apellido");
         String email = request.getParameter("email");
         String telefono = request.getParameter("telefono");
         
         Persona persona =  new Persona(nombre, apellido, email, telefono);
           ServicioPersonas personaService = new ServicioPersonas();
           
           personaService.instertarPersona(persona);
           
           response.setContentType("text/html");
            PrintWriter out;
        try {
            String url= "/PersonasWebHibernateJPA/";
            out = response.getWriter();
             out.println("<html><head><title>Alerta desde Servlet</title></head><body>");
            out.println("<script>alert('¡Registro insertado correctamente!');</script>");
           out.println("<script>window.location.replace('"+url+"');</script>");
            out.println("</body></html>");

        } catch (IOException ex) {
           ex.printStackTrace(System.out);
        }
       

           
     }
}
