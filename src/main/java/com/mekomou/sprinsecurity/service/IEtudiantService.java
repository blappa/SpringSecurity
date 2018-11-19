/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mekomou.sprinsecurity.service;

import com.mekomou.sprinsecurity.entities.Etudiant;
import java.util.List;

/**
 *
 * @author kejemto
 */
public interface IEtudiantService {
    
    public Etudiant creer(Etudiant etudiant);
    public void modifier(Etudiant etudiant);
    public void supprimer(Etudiant etudiant);
    public Etudiant recherche(int id);
    public List<Etudiant> lister();
    
}
