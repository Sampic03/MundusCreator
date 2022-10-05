/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;

import edu.sena.entity.munduscreator.Cursos;
import edu.sena.facade.munduscreator.CursosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sr992
 */
@Named(value = "cursoView")
@ViewScoped
public class CursoView implements Serializable{
    @EJB
    CursosFacadeLocal cfl;
    private Cursos CurVie = new Cursos();
    
    /**
     * Creates a new instance of CursoView
     */
    public CursoView() {
    }
    
    public List<Cursos> leerCursos() {
        return cfl.leerCursos();
    }

    
    
    
    public Cursos getCurVie() {
        return CurVie;
    }

    public void setCurVie(Cursos CurVie) {
        this.CurVie = CurVie;
    }
    
    
    
}
