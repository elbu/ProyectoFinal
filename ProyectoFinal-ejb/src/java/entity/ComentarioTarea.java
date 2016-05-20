/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "COMENTARIO_TAREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioTarea.findAll", query = "SELECT c FROM ComentarioTarea c"),
    @NamedQuery(name = "ComentarioTarea.findByIdComentarioTarea", query = "SELECT c FROM ComentarioTarea c WHERE c.comentarioTareaPK.idComentarioTarea = :idComentarioTarea"),
    @NamedQuery(name = "ComentarioTarea.findByAutor", query = "SELECT c FROM ComentarioTarea c WHERE c.autor = :autor"),
    @NamedQuery(name = "ComentarioTarea.findByContenido", query = "SELECT c FROM ComentarioTarea c WHERE c.contenido = :contenido"),
    @NamedQuery(name = "ComentarioTarea.findByFechaCreacion", query = "SELECT c FROM ComentarioTarea c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ComentarioTarea.findByTareaIdTarea", query = "SELECT c FROM ComentarioTarea c WHERE c.comentarioTareaPK.tareaIdTarea = :tareaIdTarea"),
    @NamedQuery(name = "ComentarioTarea.findByTareaProyectoIdProyecto", query = "SELECT c FROM ComentarioTarea c WHERE c.comentarioTareaPK.tareaProyectoIdProyecto = :tareaProyectoIdProyecto")})
public class ComentarioTarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComentarioTareaPK comentarioTareaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "AUTOR")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "CONTENIDO")
    private String contenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumns({
        @JoinColumn(name = "TAREA_ID_TAREA", referencedColumnName = "ID_TAREA", insertable = false, updatable = false),
        @JoinColumn(name = "TAREA_PROYECTO_ID_PROYECTO", referencedColumnName = "PROYECTO_ID_PROYECTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Tarea tarea;

    public ComentarioTarea() {
    }

    public ComentarioTarea(ComentarioTareaPK comentarioTareaPK) {
        this.comentarioTareaPK = comentarioTareaPK;
    }

    public ComentarioTarea(ComentarioTareaPK comentarioTareaPK, String autor, String contenido, Date fechaCreacion) {
        this.comentarioTareaPK = comentarioTareaPK;
        this.autor = autor;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    public ComentarioTarea(String idComentarioTarea, String tareaIdTarea, String tareaProyectoIdProyecto) {
        this.comentarioTareaPK = new ComentarioTareaPK(idComentarioTarea, tareaIdTarea, tareaProyectoIdProyecto);
    }

    public ComentarioTareaPK getComentarioTareaPK() {
        return comentarioTareaPK;
    }

    public void setComentarioTareaPK(ComentarioTareaPK comentarioTareaPK) {
        this.comentarioTareaPK = comentarioTareaPK;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comentarioTareaPK != null ? comentarioTareaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioTarea)) {
            return false;
        }
        ComentarioTarea other = (ComentarioTarea) object;
        if ((this.comentarioTareaPK == null && other.comentarioTareaPK != null) || (this.comentarioTareaPK != null && !this.comentarioTareaPK.equals(other.comentarioTareaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ComentarioTarea[ comentarioTareaPK=" + comentarioTareaPK + " ]";
    }
    
}
