/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import ejb.UsuarioFacade;
import entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author marco
 */
@Named(value = "usuarioBean")
@SessionScoped
@ManagedBean
public class UsuarioBean implements Serializable {

    @EJB
    private UsuarioFacade usuarioFacade;

    
    protected Usuario usuariologeado;
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }
    
    public void logeausuario(){
        
    }
    
}
