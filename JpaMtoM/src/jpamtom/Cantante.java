
package jpamtom;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author dordonez@ute.edu.ec
 */
@Entity
public class Cantante implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    @ManyToMany(mappedBy = "cantantes")
    private List<Cd> cds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cd> getCds() {
        return cds;
    }

    public void setCds(List<Cd> cds) {
        this.cds = cds;
    }
    
}
