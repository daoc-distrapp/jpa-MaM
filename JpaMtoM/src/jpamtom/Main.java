
package jpamtom;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main {

    private EntityManager em = Persistence.createEntityManagerFactory("JpaMtoMPU").createEntityManager();
    
    //Muchos(Cantante) a Muchos(Cd)
    private void prueba() {
        Cantante diego, ana;
        Cd uno, dos;
        int diegoId, unoId;
        //crea objetos
        diego = creaCantante("diego");
        diegoId = diego.getId();
        ana = creaCantante("ana");
        uno = creaCd("UNO");
        unoId = uno.getId();
        dos = creaCd("DOS");
        //crea relaciones: diego(uno, dos); ana(uno)
        relacionaCantanteConCd(diego, uno);
        relacionaCantanteConCd(diego, dos);
        relacionaCantanteConCd(ana, uno);
       
        //vaciamos variables en Java
        em.clear();
        diego = null;
        ana = null;
        uno = null;
        dos = null;
        
        //recupera diego y revisa sus cds
        diego = em.find(Cantante.class, diegoId);
        for(Cd cd : diego.getCds()) {
            System.out.println(cd.getTitulo());
        }
        
        System.out.println("-------");
        
        //recupera uno y revisa sus cantantes
        uno = em.find(Cd.class, unoId);
        for(Cantante can : uno.getCantantes()) {
            System.out.println(can.getNombre());
        }
    }
    
    private Cantante creaCantante(String nombre) {
        Cantante c = new Cantante();
        c.setNombre(nombre);
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }
    
    private Cd creaCd(String titulo) {
        Cd cd = new Cd();
        cd.setTitulo(titulo);
        em.getTransaction().begin();
        em.persist(cd);
        em.getTransaction().commit();
        return cd;
    }    
    
    private void relacionaCantanteConCd(Cantante can, Cd cd) {
        em.getTransaction().begin();
        can.getCds().add(cd);
        cd.getCantantes().add(can);
        em.getTransaction().commit();        
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.prueba();
    }
    
}
