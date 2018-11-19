/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mekomou.sprinsecurity.service.impl;

import com.douwe.generic.dao.DataAccessException;
import com.mekomou.sprinsecurity.dao.IDepartementDao;
import com.mekomou.sprinsecurity.entities.Departement;
import com.mekomou.sprinsecurity.service.IDepartementService;
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
public class DepartementServiceImpl implements IDepartementService {

    IDepartementDao departementDao;

    public IDepartementDao getDepartementDao() {
        return departementDao;
    }

    public void setDepartementDao(IDepartementDao departementDao) {
        this.departementDao = departementDao;
    }

    @Override
    public Departement creer(Departement departement) {
        try {
            return departementDao.create(departement);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void modifier(Departement departement) {
        try {
            departementDao.update(departement);
        } catch (DataAccessException ex) {
            Logger.getLogger(DepartementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(Departement departement) {
        try {
            departementDao.delete(departementDao.findById(departement.getId()));
        } catch (DataAccessException ex) {
            Logger.getLogger(DepartementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Departement recherche(int id) {
        try {
            return departementDao.findById(Long.valueOf(id));
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Departement> lister() {
        try {
            return departementDao.findAll();
        } catch (DataAccessException ex) {
            return null;
        }
    }
}
