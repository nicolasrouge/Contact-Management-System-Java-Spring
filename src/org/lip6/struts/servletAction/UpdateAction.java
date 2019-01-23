package org.lip6.struts.servletAction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.UpdateContactValidationForm;
import org.lip6.struts.domain.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ContactService;

public class UpdateAction extends Action {
    public ActionForward execute(
    		ActionMapping mapping, 
    		ActionForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) throws NamingException, SQLException{
    	
    	UpdateContactValidationForm updateForm = (UpdateContactValidationForm) form;
    	
    	long id = updateForm.getId();
        final String nom = updateForm.getFirstName();
        final String prenom = updateForm.getLastName();
        final String mail = updateForm.getEmail();
        final String phonenumber = updateForm.getPhoneNumber();
        final String street = updateForm.getStreet();
        final String city = updateForm.getCity();
        final String zip = updateForm.getZip();
        final String country = updateForm.getCountry();
		
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        ContactService lContactService = (service.ContactService) context.getBean("serviceContact");
    	
    	try {
			lContactService.updateContact(id, nom,prenom,mail,phonenumber,street,city,zip,country);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        List<Contact> listContacts = new ArrayList<Contact>();
        listContacts = (List<Contact>) lContactService.getListContact();
    	request.setAttribute("listContacts", listContacts);
    
    	
    	return mapping.findForward("displaylist");
        /*
    	if(rechercheForm.getContactId()==0) {
            // if no exception is raised,  forward "success"
            return mapping.findForward("displayList");
        }
        else {
            // If any exception, return the "error" forward
            return mapping.findForward("error");
        }*/
    }
}