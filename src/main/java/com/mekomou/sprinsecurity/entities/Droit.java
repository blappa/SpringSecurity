/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mekomou.sprinsecurity.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author william mekomou
 * <williammekomou@yahoo.com>
 */
@Entity
public class Droit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    
    @OneToMany(mappedBy = "droit", cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private Set<Utilisateur> utilisateurs = new HashSet<Utilisateur>();

    public void add(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
        utilisateur.setDroit(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Droit)) {
            return false;
        }
        
        
        Droit other = (Droit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mekomou.sprinsecurity.entities.Droit[ id=" + id + " ]";
    }

    public Set<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }
    
    
}
