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
import org.lip6.struts.actionForm.AddGroupValidationForm;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ContactService;


public class AddGroupAction extends Action {
    
    public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) throws Exception {
    	final AddGroupValidationForm lForm=(AddGroupValidationForm)pForm;
    	
        final String nomGroupe = lForm.getGroupName();
        //créer un nouveau contact
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        ContactService lContactService = (service.ContactService) context.getBean("serviceContact");
        //final String lError = lDAOContact.addContact(firstName,lastName, email,"toto", "toto", "toto", "country" );
        lContactService.createGroup(nomGroupe);
        //lDAOContact.addContact();
        //créer la liste qu'on va envoyer en parametre dans le forward
        List<Contact> listContacts = new ArrayList<Contact>();
        listContacts = (List<Contact>) lContactService.getListContact();
    	pRequest.setAttribute("listContacts", listContacts);
        
    	// if no exception is raised,  forward "success"
		return pMapping.findForward("success");
    }
}