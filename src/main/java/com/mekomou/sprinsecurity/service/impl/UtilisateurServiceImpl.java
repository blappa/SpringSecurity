/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mekomou.sprinsecurity.service.impl;

import com.douwe.generic.dao.DataAccessException;
import com.mekomou.sprinsecurity.dao.IDepartementDao;
import com.mekomou.sprinsecurity.dao.IUtilisateurDao;
import com.mekomou.sprinsecurity.entities.Utilisateur;
import com.mekomou.sprinsecurity.service.IUtilisateurService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author william mekomou
 * <williammekomou@yahoo.com>
 */
@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService {

    IUtilisateurDao utilisateurDao;
    
    IDepartementDao departementDao;

    public IDepartementDao getDepartementDao() {
        return departementDao;
    }

    public void setDepartementDao(IDepartementDao departementDao) {
        this.departementDao = departementDao;
    }
    
    

    public IUtilisateurDao getUtilisateurDao() {
        return utilisateurDao;
    }

    public void setUtilisateurDao(IUtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @Override
    public Utilisateur creer(Utilisateur utilisateur) {
        try {
            if(utilisateur.getDepartement()!=null)
            utilisateur.setDepartement(departementDao.findById(utilisateur.getDepartement().getId()));
            return utilisateurDao.create(utilisateurDao.findById(utilisateur.getId()));
        } catch (DataAccessException ex) {
            Logger.getLogger(UtilisateurServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void modifier(Utilisateur utilisateur) {
        try {
            utilisateurDao.update(utilisateur);
        } catch (DataAccessException ex) {
            Logger.getLogger(UtilisateurServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(Utilisateur utilisateur) {
        try {
            utilisateurDao.delete(utilisateurDao.findById(utilisateur.getId()));
        } catch (DataAccessException ex) {
            Logger.getLogger(UtilisateurServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Utilisateur recherche(int id) {
        try {
            return utilisateurDao.findById(Long.valueOf(id));
        } catch (DataAccessException ex) {
            Logger.getLogger(UtilisateurServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Utilisateur> lister() {
        try {
            return utilisateurDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(UtilisateurServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
