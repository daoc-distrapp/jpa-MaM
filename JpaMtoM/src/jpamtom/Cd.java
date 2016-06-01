
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
public class Cd implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String titulo;
    @ManyToMany
    private List<Cantante> cantantes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Cantante> getCantantes() {
        return cantantes;
    }

    public void setCantantes(List<Cantante> cantantes) {
        this.cantantes = cantantes;
    }

}
