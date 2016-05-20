/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.ComentarioProyecto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marco
 */
@Stateless
public class ComentarioProyectoFacade extends AbstractFacade<ComentarioProyecto> {

    @PersistenceContext(unitName = "ProyectoFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComentarioProyectoFacade() {
        super(ComentarioProyecto.class);
    }
    
}
