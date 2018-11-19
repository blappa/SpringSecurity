/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mekomou.sprinsecurity.service.impl;

import com.douwe.generic.dao.DataAccessException;
import com.mekomou.sprinsecurity.dao.IEtudiantDao;
import com.mekomou.sprinsecurity.entities.Etudiant;
import com.mekomou.sprinsecurity.service.IEtudiantService;
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
public class EtudiantServiceImpl implements IEtudiantService {

    IEtudiantDao etudiantDao;

    public IEtudiantDao getEtudiantDao() {
        return etudiantDao;
    }

    public void setEtudiantDao(IEtudiantDao etudiantDao) {
        this.etudiantDao = etudiantDao;
    }

    @Override
    public Etudiant creer(Etudiant etudiant) {
        try {
            return etudiantDao.create(etudiant);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void modifier(Etudiant etudiant) {
        try {
            etudiantDao.update(etudiant);
        } catch (DataAccessException ex) {
            Logger.getLogger(EtudiantServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(Etudiant etudiant) {
        try {
            etudiantDao.delete(etudiantDao.findById(etudiant.getId()));
        } catch (DataAccessException ex) {
            Logger.getLogger(EtudiantServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Etudiant recherche(int id) {
        try {
            return etudiantDao.findById(Long.valueOf(id));
        } catch (DataAccessException ex) {
            Logger.getLogger(EtudiantServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Etudiant> lister() {
        try {
            return etudiantDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(EtudiantServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
