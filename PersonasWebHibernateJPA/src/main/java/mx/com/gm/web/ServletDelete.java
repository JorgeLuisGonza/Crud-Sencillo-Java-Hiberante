package mx.com.gm.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.ServicioPersonas;

@WebServlet("/ServletDelete")
public class ServletDelete extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        ServicioPersonas personaService = new ServicioPersonas();
        
        Integer idPersona = Integer.valueOf(request.getParameter("idPersona"));
       
        Persona personaDelete = new Persona(idPersona);
        
        
          //Ahora creamos un objeto con todos los campos...
        personaDelete=  personaService.searchPersona(personaDelete);
        
        personaService.deletePersona(personaDelete);
        
        String url= "/PersonasWebHibernateJPA/";
        
        try {
            response.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        
    }
}
