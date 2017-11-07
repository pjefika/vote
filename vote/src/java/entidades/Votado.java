package entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vota_votado_2017")
public class Votado extends AbstractEntity {

    @ManyToOne
    private UsuarioEfika usuarioEfika;

    @ManyToOne
    private Dados dados;

    private Date dataDoVoto;

    public Votado() {
    }

    public UsuarioEfika getUsuarioEfika() {
        return usuarioEfika;
    }

    public void setUsuarioEfika(UsuarioEfika usuarioEfika) {
        this.usuarioEfika = usuarioEfika;
    }

    public Dados getDados() {
        return dados;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }

    public Date getDataDoVoto() {
        return dataDoVoto;
    }

    public void setDataDoVoto(Date dataDoVoto) {
        this.dataDoVoto = dataDoVoto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Votado other = (Votado) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Votado [id=" + id + "]";
    }

}
