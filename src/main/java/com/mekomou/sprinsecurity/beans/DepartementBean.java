/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mekomou.sprinsecurity.beans;

import com.mekomou.sprinsecurity.entities.Departement;
import com.mekomou.sprinsecurity.service.IDepartementService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;

/**
 *
 * @author kejemto
 */
@ManagedBean
@RequestScoped
public class DepartementBean {
    
    

    @ManagedProperty(value = "#{IDepartementService}")
    private IDepartementService departementService;
    private List<Departement> departements;
    private Departement selectedDepartement=new Departement();
    private Departement departement = new Departement();

    public DepartementBean() {
    }

    public void cancel(ActionEvent actionEvent) {
        FacesMessage msg = new FacesMessage("Modification annulee", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void modifier(ActionEvent actionEvent) {
        
        FacesMessage msg = new FacesMessage("Modification faite avec succes", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        departementService.modifier(selectedDepartement);
        
    }
    
    public void supprimer(ActionEvent actionEvent) {
        FacesMessage msg = new FacesMessage("L'element a ete supprime","");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        departementService.supprimer(departementService.recherche(selectedDepartement.getId().intValue()));
        selectedDepartement=new Departement();
    }

    public void save(ActionEvent actionEvent) {
        FacesMessage msg;
        if(departement.getName().isEmpty()){
        msg = new FacesMessage("le nom et le sigle sont obligatoires", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else{
        departementService.creer(departement);
        msg = new FacesMessage("Departement enregistre", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }

    public void setSelectedDepartement(Departement selectedDepartement) {
        this.selectedDepartement = selectedDepartement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public void setDepartementService(IDepartementService departementService) {
        this.departementService = departementService;
    }

    public IDepartementService getDepartementService() {
        return departementService;
    }

    public List<Departement> getDepartements() {
        try {
            departements = new ArrayList<Departement>();
            departements.addAll(departementService.lister());
            System.out.println(((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath(""));
            return departements;
        } catch (Exception e) {
            return null;
        }
    }

    public Departement getSelectedDepartement() {
        return selectedDepartement;
    }

    public Departement getDepartement() {
        return departement;
    }
}
