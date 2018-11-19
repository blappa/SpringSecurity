/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mekomou.sprinsecurity.service;

import com.mekomou.sprinsecurity.entities.Droit;
import java.util.List;

/**
 *
 * @author william mekomou
 * <williammekomou@yahoo.com>
 */
public interface IDroitService {

    public Droit creer(Droit droit);
    public void modifier(Droit droit);
    public void supprimer(Droit droit);
    public Droit recherche(int id);
    public List<Droit> lister();
    
}
