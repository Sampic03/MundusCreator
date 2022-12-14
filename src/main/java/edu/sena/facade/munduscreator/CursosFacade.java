/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Cursos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sr992
 */
@Stateless
public class CursosFacade extends AbstractFacade<Cursos> implements CursosFacadeLocal {

    @PersistenceContext(unitName = "MundusCreatorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursosFacade() {
        super(Cursos.class);
    }
    
    @Override
    public List<Cursos> leerCursos(){
        em.getEntityManagerFactory().getCache().evictAll();
        Query q = em.createQuery("SELECT u FROM Cursos u");
        return q.getResultList();         
    }
    
    @Override
    public boolean asignarMultimediaCurso( int id_mul) {
        try {
            Query q = em.createNativeQuery("INSERT INTO tbl_cursos (fk_mul_id) VALUES (?)");
            // tome el primer ? y lo cambia por id_usu
            q.setParameter(1, id_mul);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean asignarPapeleriaCurso( int id_pap) {
        try {
            Query q = em.createNativeQuery("INSERT INTO tbl_cursos (fk_pap_id) VALUES (?)");
            // tome el primer ? y lo cambia por id_usu
            q.setParameter(1, id_pap);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
