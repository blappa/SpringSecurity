/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mekomou.sprinsecurity.beans;
import java.io.Serializable;
import java.util.Collection;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 

/**
 *
 * @author william mekomou
 * <williammekomou@yahoo.com>
 */
@ManagedBean
@SessionScoped
@Controller
public class LoginBean implements Serializable{
    
    public boolean admin(){
    Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<GrantedAuthority> granted = ((User)obj).getAuthorities();
        Object[] granted1 = granted.toArray();
	String authority = ((GrantedAuthority)granted1[0]).getAuthority() ;
        if (authority.contains("admin")) 
            return true;
        return false;
    }
    
    public boolean chef(){
    Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<GrantedAuthority> granted = ((User)obj).getAuthorities();
        Object[] granted1 = granted.toArray();
	String authority = ((GrantedAuthority)granted1[0]).getAuthority() ;
        if (authority.contains("CHEF")) 
            return true;
        return false;
    }
    
    public boolean user(){
    Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<GrantedAuthority> granted = ((User)obj).getAuthorities();
        Object[] granted1 = granted.toArray();
	String authority = ((GrantedAuthority)granted1[0]).getAuthority() ;
        if (authority.contains("USER")) 
            return true;
        return false;
    }
    
   
    
    private String username;
    private   String locale = "fr";

    public String setFrenchLocale() {
        locale = "fr";
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.FRENCH);
        return null;
    }

    public String setEnglishLocale() {
        locale = "en";
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
        return null;
    }

    public String getLocale() {
        return FacesContext.getCurrentInstance().getViewRoot().getLocale().getCountry();
    }

    public String getUsername() throws Exception{
        username=((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
 
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
//		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String name = user.getUsername();	
//		model.addAttribute("username", name);
		return "/pages/welcome"; 
	}
 
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "index";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "index";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "index";
	}
        
        @RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(ModelMap model) {
		return "/pages/403";

	}
        
       
	
//        public String login() {
//        return "/pages/welcome.xhtml?faces-redirect=true";
//    }
}