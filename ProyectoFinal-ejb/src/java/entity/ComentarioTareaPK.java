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
public class ComentarioTareaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID_COMENTARIO_TAREA")
    private String idComentarioTarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TAREA_ID_TAREA")
    private String tareaIdTarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TAREA_PROYECTO_ID_PROYECTO")
    private String tareaProyectoIdProyecto;

    public ComentarioTareaPK() {
    }

    public ComentarioTareaPK(String idComentarioTarea, String tareaIdTarea, String tareaProyectoIdProyecto) {
        this.idComentarioTarea = idComentarioTarea;
        this.tareaIdTarea = tareaIdTarea;
        this.tareaProyectoIdProyecto = tareaProyectoIdProyecto;
    }

    public String getIdComentarioTarea() {
        return idComentarioTarea;
    }

    public void setIdComentarioTarea(String idComentarioTarea) {
        this.idComentarioTarea = idComentarioTarea;
    }

    public String getTareaIdTarea() {
        return tareaIdTarea;
    }

    public void setTareaIdTarea(String tareaIdTarea) {
        this.tareaIdTarea = tareaIdTarea;
    }

    public String getTareaProyectoIdProyecto() {
        return tareaProyectoIdProyecto;
    }

    public void setTareaProyectoIdProyecto(String tareaProyectoIdProyecto) {
        this.tareaProyectoIdProyecto = tareaProyectoIdProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentarioTarea != null ? idComentarioTarea.hashCode() : 0);
        hash += (tareaIdTarea != null ? tareaIdTarea.hashCode() : 0);
        hash += (tareaProyectoIdProyecto != null ? tareaProyectoIdProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioTareaPK)) {
            return false;
        }
        ComentarioTareaPK other = (ComentarioTareaPK) object;
        if ((this.idComentarioTarea == null && other.idComentarioTarea != null) || (this.idComentarioTarea != null && !this.idComentarioTarea.equals(other.idComentarioTarea))) {
            return false;
        }
        if ((this.tareaIdTarea == null && other.tareaIdTarea != null) || (this.tareaIdTarea != null && !this.tareaIdTarea.equals(other.tareaIdTarea))) {
            return false;
        }
        if ((this.tareaProyectoIdProyecto == null && other.tareaProyectoIdProyecto != null) || (this.tareaProyectoIdProyecto != null && !this.tareaProyectoIdProyecto.equals(other.tareaProyectoIdProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ComentarioTareaPK[ idComentarioTarea=" + idComentarioTarea + ", tareaIdTarea=" + tareaIdTarea + ", tareaProyectoIdProyecto=" + tareaProyectoIdProyecto + " ]";
    }
    
}
