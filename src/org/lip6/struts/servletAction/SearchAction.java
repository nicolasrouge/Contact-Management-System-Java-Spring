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
import org.lip6.struts.actionForm.SearchValidationForm;
import org.lip6.struts.domain.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ContactService;


public class SearchAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws NamingException, SQLException {

		System.out.println("Entre dans action search");

		final SearchValidationForm lForm = (SearchValidationForm) pForm;

		final String word = lForm.getWord();
		
		List<Contact> contacts = new ArrayList<Contact>();

    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        ContactService lContactService = (service.ContactService) context.getBean("serviceContact");
        
		try {
			contacts = lContactService.searchContact(word);
			pRequest.setAttribute("listContacts", contacts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pMapping.findForward("success");
	}
}