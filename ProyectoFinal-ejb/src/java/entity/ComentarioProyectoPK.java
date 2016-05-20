/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author marco
 */
@Embeddable
public class ComentarioProyectoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_COMENTARIO_PROYECTO")
    private String idComentarioProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PROYECTO_ID_PROYECTO")
    private String proyectoIdProyecto;

    public ComentarioProyectoPK() {
    }

    public ComentarioProyectoPK(String idComentarioProyecto, String proyectoIdProyecto) {
        this.idComentarioProyecto = idComentarioProyecto;
        this.proyectoIdProyecto = proyectoIdProyecto;
    }

    public String getIdComentarioProyecto() {
        return idComentarioProyecto;
    }

    public void setIdComentarioProyecto(String idComentarioProyecto) {
        this.idComentarioProyecto = idComentarioProyecto;
    }

    public String getProyectoIdProyecto() {
        return proyectoIdProyecto;
    }

    public void setProyectoIdProyecto(String proyectoIdProyecto) {
        this.proyectoIdProyecto = proyectoIdProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentarioProyecto != null ? idComentarioProyecto.hashCode() : 0);
        hash += (proyectoIdProyecto != null ? proyectoIdProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioProyectoPK)) {
            return false;
        }
        ComentarioProyectoPK other = (ComentarioProyectoPK) object;
        if ((this.idComentarioProyecto == null && other.idComentarioProyecto != null) || (this.idComentarioProyecto != null && !this.idComentarioProyecto.equals(other.idComentarioProyecto))) {
            return false;
        }
        if ((this.proyectoIdProyecto == null && other.proyectoIdProyecto != null) || (this.proyectoIdProyecto != null && !this.proyectoIdProyecto.equals(other.proyectoIdProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ComentarioProyectoPK[ idComentarioProyecto=" + idComentarioProyecto + ", proyectoIdProyecto=" + proyectoIdProyecto + " ]";
    }
    
}
