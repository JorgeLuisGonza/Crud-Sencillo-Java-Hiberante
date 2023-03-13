package mx.com.gm.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.ServicioPersonas;

@WebServlet("/ServletUpdate")
public class ServletUpdate extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
         ServicioPersonas personaService = new ServicioPersonas();
        String idpersona = request.getParameter("idPersona");
        Integer intIdPersona = Integer.valueOf(idpersona);
        //encontramos a la persona con el idPersona que tenemos almacenado en el url 
        Persona personaUpd = new Persona(intIdPersona);
                //Compartimos la variable personas recuperada por el metodo get
        personaUpd =  personaService.searchPersona(personaUpd);
        
        request.setAttribute("personaUpd", personaUpd);
         request.setAttribute("idPersona", idpersona);
        try {
            //Indicamos a donde mandara
            request.getRequestDispatcher("WEB-INF/update.jsp").forward(request, response);
        } catch (ServletException ex) {
           ex.printStackTrace(System.out);
        } catch (IOException ex) {
             ex.printStackTrace(System.out);
        }
    }
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        ServicioPersonas personaService = new ServicioPersonas();
        
        Integer idpersona =Integer.valueOf(request.getParameter("idpersona"));
           String nombre = request.getParameter("nombre");
         String apellido = request.getParameter("apellido");
         String email = request.getParameter("email");
         String telefono = request.getParameter("telefono");
         
         //Cramos el nuevo objeto que sera el que se actulizara
         Persona personaUpd = new Persona(idpersona, nombre, apellido, email, telefono);
         
         //Actualizamos
         personaService.actualizaPersona(personaUpd);
         
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
