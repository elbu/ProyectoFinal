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
public class TareaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_TAREA")
    private String idTarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PROYECTO_ID_PROYECTO")
    private String proyectoIdProyecto;

    public TareaPK() {
    }

    public TareaPK(String idTarea, String proyectoIdProyecto) {
        this.idTarea = idTarea;
        this.proyectoIdProyecto = proyectoIdProyecto;
    }

    public String getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
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
        hash += (idTarea != null ? idTarea.hashCode() : 0);
        hash += (proyectoIdProyecto != null ? proyectoIdProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaPK)) {
            return false;
        }
        TareaPK other = (TareaPK) object;
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        if ((this.proyectoIdProyecto == null && other.proyectoIdProyecto != null) || (this.proyectoIdProyecto != null && !this.proyectoIdProyecto.equals(other.proyectoIdProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TareaPK[ idTarea=" + idTarea + ", proyectoIdProyecto=" + proyectoIdProyecto + " ]";
    }
    
}
