/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.ComentarioTarea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marco
 */
@Stateless
public class ComentarioTareaFacade extends AbstractFacade<ComentarioTarea> {

    @PersistenceContext(unitName = "ProyectoFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComentarioTareaFacade() {
        super(ComentarioTarea.class);
    }
    
}
