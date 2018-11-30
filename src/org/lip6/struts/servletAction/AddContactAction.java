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
import org.lip6.struts.actionForm.AddContactValidationForm;
import org.lip6.struts.domain.DAOContact;


public class AddContactAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) throws NamingException, SQLException {
    	final AddContactValidationForm lForm=(AddContactValidationForm)pForm;
    	
        
        //final long id = lForm.getId();
        final String firstName = lForm.getFirstName();
        final String lastName = lForm.getLastName();
        final String email = lForm.getEmail();

        System.out.println(org.hibernate.Version.getVersionString());
        //créer un nouveau contact
        final DAOContact lDAOContact = new DAOContact();
        //final String lError = lDAOContact.addContact(firstName,lastName, email,"toto", "toto", "toto", "country" );
        //lDAOContact.addContact(firstName,lastName, email,"toto", "toto", "toto", "country" );
        lDAOContact.addContact();
        //créer la liste qu'on va envoyer en parametre dans le forward
        //List<Contact1> listContacts = new ArrayList<Contact1>();
        //listContacts = lDAOContact.getListContacts();    
    	//pRequest.setAttribute("listContacts", listContacts);
        
    	// if no exception is raised,  forward "success"
		return pMapping.findForward("success");
    }
}

