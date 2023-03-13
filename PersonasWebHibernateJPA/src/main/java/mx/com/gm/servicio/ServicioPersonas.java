package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class ServicioPersonas {
    private PersonaDAO personaDao;
    
    public ServicioPersonas(){
        this.personaDao = new PersonaDAO();
    }
    public List<Persona> listarPersonas(){
        return this.personaDao.listar();
    }
    public void instertarPersona(Persona persona){
       this.personaDao.insertar(persona);
    }
    public Persona searchPersona(Persona persona){
       return  this.personaDao.buscarPersonaPorID(persona);
    }
    public void actualizaPersona(Persona persona){
        this.personaDao.actualizar(persona);
    }
    
    public void deletePersona(Persona persona){
        this.personaDao.eliminarPersona(persona);
    }
}
