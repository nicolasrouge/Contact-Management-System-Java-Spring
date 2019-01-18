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
import org.lip6.struts.domain.Contact1;
import org.lip6.struts.domain.DAOContact1;

public class UpdateAction extends Action {
    public ActionForward execute(
    		ActionMapping mapping, 
    		ActionForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) throws NamingException, SQLException{
    	
    	UpdateContactValidationForm updateForm = (UpdateContactValidationForm) form;
    	
    	long id = updateForm.getId();
    	String email = updateForm.getEmail();
    	String lastName = updateForm.getLastName();
    	String firstName = updateForm.getFirstName();
		
    	DAOContact1 lDAOContact = new DAOContact1();
    	     
    	lDAOContact.updateContact(id,firstName, lastName, email);
    
 
        List<Contact1> listContacts = new ArrayList<Contact1>();
        listContacts = lDAOContact.getListContacts();
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
