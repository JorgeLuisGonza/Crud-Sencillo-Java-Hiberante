package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Persona;

public class PersonaDAO {
private EntityManagerFactory emf;
private EntityManager em;

        public PersonaDAO(){
            emf = Persistence.createEntityManagerFactory("HibernatePU");
            em = emf.createEntityManager();
        }

        public List<Persona> listar(){
            String hql = "SELECT p FROM Persona p";
            Query query = em.createQuery(hql);
            List<Persona> personas = query.getResultList();
        return personas;
        }
        
        public void insertar(Persona persona){
            try{
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            }
            catch(Exception ex){
                ex.printStackTrace(System.out);
                em.getTransaction().rollback();
            }
            finally{
               if(em != null){
                   em.close();
               }
            }
        }
        
        public void actualizar(Persona persona){
                 try{
            em.getTransaction().begin();
            em.merge(persona); //el metodo marge actualiza 
            em.getTransaction().commit();
            }
            catch(Exception ex){
                ex.printStackTrace(System.out);
                em.getTransaction().rollback();
            }
//            finally{
//               if(em != null){
//                   em.close();
//               }
//            }
        }
        
        public Persona buscarPersonaPorID(Persona persona){
         return   em.find(Persona.class, persona.getIdPersona());
        }
        
        public void eliminarPersona(Persona persona){
                  try{
            em.getTransaction().begin();
            em.remove(persona); //el metodo marge actualiza 
            em.getTransaction().commit();
            }
            catch(Exception ex){
                ex.printStackTrace(System.out);
                em.getTransaction().rollback();
            }
//            finally{
//               if(em != null){
//                   em.close();
//               }
//            }
        }
}
