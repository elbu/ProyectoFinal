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
@Table(name = "COMENTARIO_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioProyecto.findAll", query = "SELECT c FROM ComentarioProyecto c"),
    @NamedQuery(name = "ComentarioProyecto.findByIdComentarioProyecto", query = "SELECT c FROM ComentarioProyecto c WHERE c.comentarioProyectoPK.idComentarioProyecto = :idComentarioProyecto"),
    @NamedQuery(name = "ComentarioProyecto.findByAutor", query = "SELECT c FROM ComentarioProyecto c WHERE c.autor = :autor"),
    @NamedQuery(name = "ComentarioProyecto.findByContenido", query = "SELECT c FROM ComentarioProyecto c WHERE c.contenido = :contenido"),
    @NamedQuery(name = "ComentarioProyecto.findByFechaCreacion", query = "SELECT c FROM ComentarioProyecto c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ComentarioProyecto.findByProyectoIdProyecto", query = "SELECT c FROM ComentarioProyecto c WHERE c.comentarioProyectoPK.proyectoIdProyecto = :proyectoIdProyecto")})
public class ComentarioProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComentarioProyectoPK comentarioProyectoPK;
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
    @JoinColumn(name = "PROYECTO_ID_PROYECTO", referencedColumnName = "ID_PROYECTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    public ComentarioProyecto() {
    }

    public ComentarioProyecto(ComentarioProyectoPK comentarioProyectoPK) {
        this.comentarioProyectoPK = comentarioProyectoPK;
    }

    public ComentarioProyecto(ComentarioProyectoPK comentarioProyectoPK, String autor, String contenido, Date fechaCreacion) {
        this.comentarioProyectoPK = comentarioProyectoPK;
        this.autor = autor;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    public ComentarioProyecto(String idComentarioProyecto, String proyectoIdProyecto) {
        this.comentarioProyectoPK = new ComentarioProyectoPK(idComentarioProyecto, proyectoIdProyecto);
    }

    public ComentarioProyectoPK getComentarioProyectoPK() {
        return comentarioProyectoPK;
    }

    public void setComentarioProyectoPK(ComentarioProyectoPK comentarioProyectoPK) {
        this.comentarioProyectoPK = comentarioProyectoPK;
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

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comentarioProyectoPK != null ? comentarioProyectoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioProyecto)) {
            return false;
        }
        ComentarioProyecto other = (ComentarioProyecto) object;
        if ((this.comentarioProyectoPK == null && other.comentarioProyectoPK != null) || (this.comentarioProyectoPK != null && !this.comentarioProyectoPK.equals(other.comentarioProyectoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ComentarioProyecto[ comentarioProyectoPK=" + comentarioProyectoPK + " ]";
    }
    
}
