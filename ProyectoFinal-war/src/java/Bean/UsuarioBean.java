/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import ejb.UsuarioFacade;
import entity.Proyecto;
import entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author marco
 */

@SessionScoped
@ManagedBean

public class UsuarioBean implements Serializable {

    @EJB
    private UsuarioFacade usuarioFacade;
    
    
    protected List<Proyecto> listaproyectos;
    protected List<Proyecto> listaproyectoslider;
    protected Usuario usuariologeado;
    protected boolean fallaloginuser;
    protected boolean fallaloginpass;
    /**
     * Creates a new instance of UsuarioBean
     */
    @PostConstruct
    public void init(){
        fallaloginuser=false;
        fallaloginpass=false;
        usuariologeado=new Usuario();
        
    }
    public UsuarioBean() {
    }

    public List<Proyecto> getListaproyectos() {
        return listaproyectos;
    }

    public void setListaproyectos(List<Proyecto> listaproyectos) {
        this.listaproyectos = listaproyectos;
    }

    public List<Proyecto> getListaproyectoslider() {
        return listaproyectoslider;
    }

    public void setListaproyectoslider(List<Proyecto> listaproyectoslider) {
        this.listaproyectoslider = listaproyectoslider;
    }

    public Usuario getUsuariologeado() {
        return usuariologeado;
    }

    public void setUsuariologeado(Usuario usuariologeado) {
        this.usuariologeado = usuariologeado;
    }

    public boolean isFallaloginuser() {
        return fallaloginuser;
    }

    public void setFallaloginuser(boolean fallaloginuser) {
        this.fallaloginuser = fallaloginuser;
    }

    public boolean isFallaloginpass() {
        return fallaloginpass;
    }

    public void setFallaloginpass(boolean fallaloginpass) {
        this.fallaloginpass = fallaloginpass;
    }
    
    public String logeausuario(){
        Usuario usuario=usuarioFacade.find(usuariologeado.getIdUsuario());
        if(usuario!=null){
            if(usuario.getPassword().equals(usuariologeado.getPassword())){
            //cargar proyectos y entrar
            usuariologeado=usuario;
            this.cargaProyectos();
            return "cargaproyectos";
            }else{
            //contraseña incorrecta
            fallaloginpass=true;
            return "login";
            }
        }
        //usuario no existe 
        fallaloginuser=true;
        return "login";
    }
    public void cargaProyectos(){
        listaproyectos=usuariologeado.getProyectoList();
        listaproyectoslider=usuariologeado.getProyectoList1();
        listaproyectos.removeAll(listaproyectoslider);
    }
    
}
