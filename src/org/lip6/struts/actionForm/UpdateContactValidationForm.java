package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.EmailValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.Contact;

import service.ContactService;


public class UpdateContactValidationForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private long id=0;   
    private String firstName=null;
    private String lastName=null;
    private String email=null;
	private String phoneNumber=null;
	private String street=null;
	private String city=null;
	private String zip=null;
	private String country=null;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
    	System.out.println("UpdateValidationForm id : " + request.getParameter("id"));
    	Long id_contact =Long.valueOf(request.getParameter("id"));
		Contact contact;
    	ContactService lContactService = new ContactService();
			try {
				contact = lContactService.getContact(id_contact);
				System.out.println("RESET RESET contact id : " + contact.getContact_ID());
		    	this.id  = contact.getContact_ID();
		    	this.lastName =contact.getNom();
		    	this.firstName = contact.getNom();
		    	this.email = contact.getMail();
		    	this.city = contact.getAddress().getCity();
		    	this.country = contact.getAddress().getCountry();
		    	this.street = contact.getAddress().getStreet();
		    	this.zip = contact.getAddress().getZip();
		    	this.phoneNumber = "0733333333";
		    	
			} catch (Exception e) {
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
            
    		//ne doit pas etre vide
            if( getFirstName()== null || getFirstName().length() < 1) {
              errors.add("firstName",new ActionMessage("creation.fn.error.required"));
            }
            
            //ne doit pas contenir de nombres
            if( getFirstName().matches(".*\\d.*")) {//matches("[0-9]+")
                errors.add("firstName",new ActionMessage("creation.fn.error.number"));
            }
            
            //ne doit pas etre vide
            if( getLastName()== null || getLastName().length() < 1) {
              errors.add("lastName",new ActionMessage("creation.ln.error.required"));
            }
            
            //ne doit pas contenir de nombres
            if( getLastName().matches(".*\\d.*")) {
                errors.add("lastName",new ActionMessage("creation.ln.error.number"));
            }
            //ne doit pas etre vide
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