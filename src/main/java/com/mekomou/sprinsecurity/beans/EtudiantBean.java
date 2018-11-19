/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mekomou.sprinsecurity.beans;

import com.mekomou.sprinsecurity.entities.Departement;
import com.mekomou.sprinsecurity.entities.Etudiant;
import com.mekomou.sprinsecurity.entities.Utilisateur;
import com.mekomou.sprinsecurity.service.IDepartementService;
import com.mekomou.sprinsecurity.service.IEtudiantService;
import com.mekomou.sprinsecurity.service.IUtilisateurService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author kejemto
 */
@ManagedBean
@SessionScoped
public class EtudiantBean {

    @ManagedProperty(value = "#{IEtudiantService}")
    private IEtudiantService etudiantService;
    @ManagedProperty(value = "#{IDepartementService}")
    private IDepartementService departementService;
    @ManagedProperty(value = "#{IUtilisateurService}")
    private IUtilisateurService utilisateurService;
    private List<Etudiant> etudiants;
    private List<Departement> departements;
    private Etudiant selectedEtudiant = new Etudiant();
    private Etudiant etudiant = new Etudiant();
    private Long idDepartement;
    /*****************************************************************/
    private Map<String, String> continent = new HashMap<String, String>();
    private Map<String, Map<String, String>> p = new HashMap<String, Map<String, String>>();
    private Map<String, Map<String, String>> v = new HashMap<String, Map<String, String>>();
    private Map<String, String> pays = new HashMap<String, String>();
    private Map<String, String> ville = new HashMap<String, String>();
    private String nomContinent;
    private String nomPays;
    private String nomVille;
    private boolean paysDisabled=true;
    private boolean villeDisabled=true;
    
    

    public EtudiantBean() {
        /**
         * **************************** tests des changelisteners ***********************
         */
        

        continent.put("Europe", "Europe");
        continent.put("Afrique", "Afrique");

        Map<String, String> europe = new HashMap<String, String>();
        europe.put("France", "France");
        europe.put("Italie", "Italie");

        Map<String, String> afrique = new HashMap<String, String>();
        afrique.put("Cameroun", "Cameroun");
        afrique.put("Nigeria", "Nigeria");

        
        p.put("Europe", europe);
        p.put("Afrique", afrique);

        Map<String, String> cameroun = new HashMap<String, String>();
        cameroun.put("Yaounde", "Yaounde");
        cameroun.put("Douala", "Douala");

        Map<String, String> nigeria = new HashMap<String, String>();
        nigeria.put("Lagos", "Lagos");
        nigeria.put("Abudja", "Abudja");

        Map<String, String> france = new HashMap<String, String>();
        france.put("Paris", "Paris");
        france.put("Lourdes", "Lourdes");

        Map<String, String> italie = new HashMap<String, String>();
        italie.put("Rome", "Rome");
        italie.put("Padova", "Padova");

       
        v.put("France", france);
        v.put("Italie", italie);
        v.put("Cameroun", cameroun);
        v.put("Nigeria", nigeria);


    }

    public void modifier(ActionEvent actionEvent) {
        FacesMessage msg = new FacesMessage("Modification faite avec succes", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        selectedEtudiant.setDepartement(departementService.recherche(idDepartement.intValue()));;
        selectedEtudiant.setUtilisateur(utilisateurService.recherche(1));;
        etudiantService.modifier(selectedEtudiant);
    }

    public void supprimer(ActionEvent actionEvent) {
        FacesMessage msg = new FacesMessage("L'element a ete supprime", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        etudiantService.supprimer(selectedEtudiant);
    }

    public void save(ActionEvent actionEvent) {
        FacesMessage msg;
        if (etudiant.getName().isEmpty()) {
            msg = new FacesMessage("le nom est obligatoire", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            etudiant.setDepartement(departementService.recherche(idDepartement.intValue()));;
            etudiant.setUtilisateur(utilisateurService.recherche(1));;
            etudiantService.creer(etudiant);
            msg = new FacesMessage("Departement enregistre", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public IEtudiantService getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    public IDepartementService getDepartementService() {
        return departementService;
    }

    public void setDepartementService(IDepartementService departementService) {
        this.departementService = departementService;
    }

    public List<Etudiant> getEtudiants() {
        try {
            etudiants = new ArrayList<Etudiant>();
            etudiants.addAll(etudiantService.lister());
            return etudiants;
        } catch (Exception e) {
            return null;
        }
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<Departement> getDepartements() {
        try {
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

    public Etudiant getSelectedEtudiant() {
        return selectedEtudiant;
    }

    public void setSelectedEtudiant(Etudiant selectedEtudiant) {
        this.selectedEtudiant = selectedEtudiant;
        idDepartement = selectedEtudiant.getDepartement().getId();
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Long getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Long idDepartement) {
        this.idDepartement = idDepartement;
    }

    public IUtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public void setUtilisateurService(IUtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    public Map<String, String> getContinent() {
        return continent;
    }

    public void setContinent(Map<String, String> continent) {
        this.continent = continent;
    }

    public Map<String, String> getPays() {
        return pays;
    }

    public void setPays(Map<String, String> pays) {
        this.pays = pays;
    }

    public Map<String, String> getVille() {
        return ville;
    }

    public void setVille(Map<String, String> ville) {
        this.ville = ville;
    }

    public String getNomContinent() {
        return nomContinent;
    }

    public void setNomContinent(String nomContinent) {
        this.nomContinent = nomContinent;
        paysDisabled=false;
        if(nomContinent !=null && !nomContinent.equals(""))  
            pays = p.get(nomContinent);  
        else  
            pays = new HashMap<String, String>();  
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
        villeDisabled=false;
        if(nomPays !=null && !nomPays.equals(""))  
            ville = v.get(nomPays);  
        else  
            ville = new HashMap<String, String>();  
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public boolean isPaysDisabled() {
        return paysDisabled;
    }

    public void setPaysDisabled(boolean paysDisabled) {
        this.paysDisabled = paysDisabled;
    }

    public boolean isVilleDisabled() {
        return villeDisabled;
    }

    public void setVilleDisabled(boolean villeDisabled) {
        this.villeDisabled = villeDisabled;
    }
    
    
    
    
}
