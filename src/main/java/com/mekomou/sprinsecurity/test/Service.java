/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mekomou.sprinsecurity.test;

import com.douwe.generic.dao.DataAccessException;
import com.mekomou.sprinsecurity.entities.Departement;
import com.mekomou.sprinsecurity.entities.Droit;
import com.mekomou.sprinsecurity.entities.Utilisateur;
import com.mekomou.sprinsecurity.service.IDepartementService;
import com.mekomou.sprinsecurity.service.IDroitService;
import com.mekomou.sprinsecurity.service.IUtilisateurService;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author william mekomou
 * <williammekomou@yahoo.com>
 */
public class Service {
public static void main(String[] args) throws DataAccessException {
        ApplicationContext ctx= new ClassPathXmlApplicationContext("springPU.xml");
          IDroitService droitService = (IDroitService)ctx.getBean("IDroitService");
          IUtilisateurService utilisateurService= (IUtilisateurService)ctx.getBean("IUtilisateurService");
         
//         Droit droit=new Droit();
//         droit.setType("ROLE_ADMIN");
//         droitService.creer(droit);
//         droit=new Droit();
//         droit.setType("ROLE_USER");
//         droitService.creer(droit);
//         droit=new Droit();
//         droit.setType("ROLE_CHEF");
//         droitService.creer(droit);
         
          
       Utilisateur utilisateur=new Utilisateur();
       utilisateur.setUsername("admin");
       utilisateur.setPassword("lappa");
       utilisateur.setDroit(droitService.recherche(1));
       utilisateurService.creer(utilisateur);
       
         
       
    
    }
}
