package com.mekomou.sprinsecurity.test;

import com.mekomou.sprinsecurity.entities.Droit;
import com.mekomou.sprinsecurity.entities.Utilisateur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 * test de la classe entity
 *
 */
public class Entity {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("springPU");
        EntityManager em = null;
        em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Droit droit=new Droit();
        droit.setType("Administrateur");
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setUsername("admin");
        utilisateur.setPassword("admin");
        droit.add(utilisateur);
        em.merge(droit);
       

        tx.commit();
        em.close();
        emf.close();
    }
}
