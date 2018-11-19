/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mekomou.sprinsecurity.service;

import com.mekomou.sprinsecurity.entities.Utilisateur;
import java.util.List;

/**
 *
 * @author kejemto
 */
public interface IUtilisateurService {
    
    public Utilisateur creer(Utilisateur utilisateur);
    public void modifier(Utilisateur utilisateur);
    public void supprimer(Utilisateur utilisateur);
    public Utilisateur recherche(int id);
    public List<Utilisateur> lister();
    
}
