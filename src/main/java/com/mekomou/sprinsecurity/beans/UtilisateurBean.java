/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mekomou.sprinsecurity.beans;

import com.mekomou.sprinsecurity.entities.Departement;
import com.mekomou.sprinsecurity.entities.Utilisateur;
import com.mekomou.sprinsecurity.service.IDepartementService;
import com.mekomou.sprinsecurity.service.IDroitService;
import com.mekomou.sprinsecurity.service.IUtilisateurService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

/**
 *
 * @author kejemto
 */
@ManagedBean
@SessionScoped
public class UtilisateurBean implements Serializable {

    @ManagedProperty(value = "#{IUtilisateurService}")
    private IUtilisateurService utilisateurService;
    @ManagedProperty(value = "#{IDepartementService}")
    private IDepartementService departementService;
    @ManagedProperty(value = "#{IDroitService}")
    private IDroitService droitService;
    private List<Utilisateur> utilisateurs;
    private Utilisateur selectedUtilisateur = new Utilisateur();
    private Utilisateur utilisateur = new Utilisateur();
   private List<Departement> departements;
    private int idDroit;
    private Long idDepartement;
    private boolean isDisabled = true;

    public UtilisateurBean() {
    }

    public void cancel(ActionEvent actionEvent) {
        FacesMessage msg = new FacesMessage("Modification annulee", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void modifier(ActionEvent actionEvent) {

        FacesMessage msg = new FacesMessage("Modification faite avec succes", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        selectedUtilisateur.setDroit(droitService.recherche(idDroit));
        utilisateurService.modifier(selectedUtilisateur);

    }

    public void supprimer(ActionEvent actionEvent) {
        FacesMessage msg = new FacesMessage("L'element a ete supprime", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println(selectedUtilisateur);
         selectedUtilisateur.setDepartement(null);
        utilisateurService.supprimer(selectedUtilisateur);
    }

    public void save(ActionEvent actionEvent) {
        FacesMessage msg;
        if (utilisateur.getUsername().isEmpty()) {
            msg = new FacesMessage("le nom est obligatoire", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            utilisateur.setDroit(droitService.recherche(idDroit));
            if(idDroit==3){
            Departement departement = departementService.recherche(idDepartement.intValue());
            utilisateur.setDepartement(departement);
            }
            utilisateurService.creer(utilisateur);
            msg = new FacesMessage("Departement enregistre", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void droitChanged() {
        idDroit = getIdDroit();
    }

    public boolean isIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public List<Departement> getDepartements() {
        try{
          departements = new ArrayList<Departement>();
           departements.addAll(departementService.lister());
            return departements;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }
    
    public List<Utilisateur> getUtilisateurs() {
        try {
            utilisateurs = new ArrayList<Utilisateur>();
            utilisateurs.addAll(utilisateurService.lister());
            return utilisateurs;
        } catch (Exception e) {
            return null;
        }
    }

    public IUtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public void setUtilisateurService(IUtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Utilisateur getSelectedUtilisateur() {
        try {
            idDroit = selectedUtilisateur.getDroit().getId().intValue();
        } catch (Exception e) {
        }

        return selectedUtilisateur;
    }

    public void setSelectedUtilisateur(Utilisateur selectedUtilisateur) {
        this.selectedUtilisateur = selectedUtilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getIdDroit() {
        return idDroit;
    }

    public void setIdDroit(int idDroit) {
        this.idDroit = idDroit;
        if (idDroit == 3) {
            isDisabled = false;
        } else {
            isDisabled = true;
            idDroit = 0;
        }
    }

    public IDroitService getDroitService() {
        return droitService;
    }

    public void setDroitService(IDroitService droitService) {
        this.droitService = droitService;
    }

    public IDepartementService getDepartementService() {
        return departementService;
    }

    public void setDepartementService(IDepartementService departementService) {
        this.departementService = departementService;
    }

    public Long getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Long idDepartement) {
        this.idDepartement = idDepartement;
    }
}
