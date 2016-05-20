/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "TAREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t"),
    @NamedQuery(name = "Tarea.findByIdTarea", query = "SELECT t FROM Tarea t WHERE t.tareaPK.idTarea = :idTarea"),
    @NamedQuery(name = "Tarea.findByTitulo", query = "SELECT t FROM Tarea t WHERE t.titulo = :titulo"),
    @NamedQuery(name = "Tarea.findByDescripcion", query = "SELECT t FROM Tarea t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tarea.findByFechaCreacion", query = "SELECT t FROM Tarea t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Tarea.findByEstado", query = "SELECT t FROM Tarea t WHERE t.estado = :estado"),
    @NamedQuery(name = "Tarea.findByAutor", query = "SELECT t FROM Tarea t WHERE t.autor = :autor"),
    @NamedQuery(name = "Tarea.findByPersonaAsignada", query = "SELECT t FROM Tarea t WHERE t.personaAsignada = :personaAsignada"),
    @NamedQuery(name = "Tarea.findByProyectoIdProyecto", query = "SELECT t FROM Tarea t WHERE t.tareaPK.proyectoIdProyecto = :proyectoIdProyecto")})
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TareaPK tareaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 1000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 20)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "AUTOR")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PERSONA_ASIGNADA")
    private String personaAsignada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarea")
    private List<ComentarioTarea> comentarioTareaList;
    @JoinColumn(name = "PROYECTO_ID_PROYECTO", referencedColumnName = "ID_PROYECTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    public Tarea() {
    }

    public Tarea(TareaPK tareaPK) {
        this.tareaPK = tareaPK;
    }

    public Tarea(TareaPK tareaPK, String titulo, Date fechaCreacion, String autor, String personaAsignada) {
        this.tareaPK = tareaPK;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
        this.personaAsignada = personaAsignada;
    }

    public Tarea(String idTarea, String proyectoIdProyecto) {
        this.tareaPK = new TareaPK(idTarea, proyectoIdProyecto);
    }

    public TareaPK getTareaPK() {
        return tareaPK;
    }

    public void setTareaPK(TareaPK tareaPK) {
        this.tareaPK = tareaPK;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPersonaAsignada() {
        return personaAsignada;
    }

    public void setPersonaAsignada(String personaAsignada) {
        this.personaAsignada = personaAsignada;
    }

    @XmlTransient
    public List<ComentarioTarea> getComentarioTareaList() {
        return comentarioTareaList;
    }

    public void setComentarioTareaList(List<ComentarioTarea> comentarioTareaList) {
        this.comentarioTareaList = comentarioTareaList;
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
        hash += (tareaPK != null ? tareaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.tareaPK == null && other.tareaPK != null) || (this.tareaPK != null && !this.tareaPK.equals(other.tareaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tarea[ tareaPK=" + tareaPK + " ]";
    }
    
}
