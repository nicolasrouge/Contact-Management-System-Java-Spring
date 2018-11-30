package org.lip6.struts.actionForm;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.EmailValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.Contact1;
import org.lip6.struts.domain.DAOContact1;


public class UpdateValidationForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private long id=0;   
    private String firstName=null;
    private String lastName=null;
    private String email=null;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
  
    public void reset(ActionMapping mapping, HttpServletRequest request) {
    	DAOContact1 daoContact = new DAOContact1();
    	
    	System.out.println("UpdateValidationForm id : " + request.getParameter("id"));
			Contact1 contact;
			try {
				contact = daoContact.displayContact(Integer.valueOf(request.getParameter("id")));//Integer.valueOf(request.getParameter("id"))
		    	this.id  = contact.getId();
		    	this.lastName =contact.getLastName();
		    	this.firstName = contact.getFirstName();
		    	this.email = contact.getEmail();
			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		/*Integer.valueOf(request.getParameter("id")));*/
    	
    	/*String reset = (String)request.getAttribute("myForm.reset");
        if ((null != reset)|| ("true".equals(reset))) {
            fullName = null;
        }*/
    }
    
    public ActionErrors validate( 
            ActionMapping mapping, HttpServletRequest request ) {
            
    		ActionErrors errors = new ActionErrors();
            
    		//ne doit pas être vide
            if( getFirstName()== null || getFirstName().length() < 1) {
              errors.add("firstName",new ActionMessage("creation.fn.error.required"));
            }
            
            //ne doit pas contenir de nombres
            if( getFirstName().matches(".*\\d.*")) {//matches("[0-9]+")
                errors.add("firstName",new ActionMessage("creation.fn.error.number"));
            }
            
            //ne doit pas être vide
            if( getLastName()== null || getLastName().length() < 1) {
              errors.add("lastName",new ActionMessage("creation.ln.error.required"));
            }
            
            //ne doit pas contenir de nombres
            if( getLastName().matches(".*\\d.*")) {
                errors.add("lastName",new ActionMessage("creation.ln.error.number"));
            }
            //ne doit pas être vide
            if( getEmail() == null || getEmail().length() < 1) {
              errors.add("email", new ActionMessage("creation.email.error.required"));
            }
            email = email.trim();
        	EmailValidator ev = EmailValidator.getInstance();
        	
        	if(!ev.isValid(email)) {
        		errors.add("email", new ActionMessage("creation.email.error.bad"));
        	}
            return errors;
        }
}
