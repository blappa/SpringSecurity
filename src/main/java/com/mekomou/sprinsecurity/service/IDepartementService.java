/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mekomou.sprinsecurity.service;

import com.mekomou.sprinsecurity.entities.Departement;
import java.util.List;

/**
 *
 * @author william mekomou
 * <williammekomou@yahoo.com>
 */
public interface IDepartementService {
    
    public Departement creer(Departement departement);
    public void modifier(Departement departement);
    public void supprimer(Departement departement);
    public Departement recherche(int id);
    public List<Departement> lister();
 
}
