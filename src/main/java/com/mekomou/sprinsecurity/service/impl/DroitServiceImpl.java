/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mekomou.sprinsecurity.service.impl;

import com.douwe.generic.dao.DataAccessException;
import com.mekomou.sprinsecurity.dao.IDroitDao;
import com.mekomou.sprinsecurity.entities.Droit;
import com.mekomou.sprinsecurity.service.IDroitService;
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
public class DroitServiceImpl implements IDroitService {

    IDroitDao droitDao;

    public IDroitDao getDroitDao() {
        return droitDao;
    }

    public void setDroitDao(IDroitDao droitDao) {
        this.droitDao = droitDao;
    }

    @Override
    public Droit creer(Droit droit) {
        try {
            return droitDao.create(droit);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void modifier(Droit droit) {
        try {
            droitDao.update(droit);
        } catch (DataAccessException ex) {
            Logger.getLogger(DroitServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(Droit droit) {
        try {
            droitDao.delete(droitDao.findById(droit.getId()));
        } catch (DataAccessException ex) {
            Logger.getLogger(DroitServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Droit recherche(int id) {
        try {
            return droitDao.findById(Long.valueOf(id));
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Droit> lister() {
        try {
            return droitDao.findAll();
        } catch (DataAccessException ex) {
            return null;
        }
    }
}
