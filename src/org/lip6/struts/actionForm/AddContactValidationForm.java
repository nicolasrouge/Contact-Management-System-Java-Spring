package org.lip6.struts.actionForm;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.EmailValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;

public class AddContactValidationForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String firstname=null;
    private String lastname=null;
    private String email=null;
    private String phonenumber=null;
    private String street=null;
    private String city=null;
    private String zip=null;
    private String country=null;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		//this.id=0;
		this.firstname=null;
		this.lastname=null;
		this.email=null;
		this.phonenumber=null;
		this.street=null;
		this.city=null;
		this.zip=null;
		this.country=null;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		System.out.println("ADD CONTACT VALIDATION");
		final DAOContact daoContact = new DAOContact();
        List<Contact> listContacts = new ArrayList<Contact>();
       
        listContacts = (List<Contact>) daoContact.getListContacts();
		
        //request.setAttribute("listContacts", listContacts);
        
        // Contact
        /*if (getId() < 1) {
        	errors.add("id", new ActionMessage("creation.id.error.required"));
        }*/   	
        
        if( getFirstname()== null || getFirstname().length() < 1 ) {
        	errors.add("firstname",new ActionMessage("creation.fn.error.required"));
        }     
        //ne doit pas contenir de nombres
        if( getFirstname().matches(".*\\d.*")) {//matches("[0-9]+")
            errors.add("firstname",new ActionMessage("creation.fn.error.number"));
        }
        if( getLastname()== null || getLastname().length() < 1 ) {
        	errors.add("lastname",new ActionMessage("creation.ln.error.required"));
        }
        //ne doit pas contenir de nombres
        if( getLastname().matches(".*\\d.*")) {
            errors.add("lastname",new ActionMessage("creation.ln.error.number"));
        }
        if( getEmail() == null || getEmail().length() < 1 ) {
        	errors.add("email", new ActionMessage("creation.email.error.required"));
        }
        
        if( getEmail() == null || getEmail().length() < 1 ) {
        	errors.add("email", new ActionMessage("creation.email.error.required"));
        }
        
        //vérification du format de l'email
        email = email.trim();
    	EmailValidator ev = EmailValidator.getInstance();
    	
    	if(!ev.isValid(email)) {
    		errors.add("email", new ActionMessage("creation.email.error.bad"));
    	}
        return errors;
	}
}
