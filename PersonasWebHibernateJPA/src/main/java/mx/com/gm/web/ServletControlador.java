package mx.com.gm.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.ServicioPersonas;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        ServicioPersonas personaService = new ServicioPersonas();
        
        List<Persona> personas = personaService.listarPersonas();
        
        //Compartimos la variable personas recuperada por el metodo get
        request.setAttribute("personas", personas);
        
        try {
            //Indicamos a donde mandara
            request.getRequestDispatcher("WEB-INF/listado.jsp").forward(request, response);
        } catch (ServletException ex) {
                    ex.printStackTrace(System.out);
        } catch (IOException ex) {
                ex.printStackTrace(System.out);
        }
    }
}
