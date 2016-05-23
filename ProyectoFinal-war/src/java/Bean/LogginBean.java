/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jace
 */
@ManagedBean
@SessionScoped
public class LogginBean {
    
     protected boolean message; 
     protected String user;
     protected String pass; 
     
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public LogginBean() {
    }
    
    @PostConstruct
    public void init() {
        this.setUser("");
        this.setPass("");
        this.setMessage((boolean) Boolean.FALSE);
    }
    
    public String doAction(){
        
        /// fail 
        this.setUser("");
        this.setPass("");
        this.setMessage((boolean) Boolean.TRUE);
        
        return "login.xhtml";
    }
    
    public String doRegistrar(){
        
        return "";
    }
    public String doRecordar(){
        
        return "";
    }

    /**
     * @return the message
     */
    public boolean isMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(boolean message) {
        this.message = message;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
