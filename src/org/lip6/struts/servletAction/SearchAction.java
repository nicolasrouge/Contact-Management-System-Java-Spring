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
import org.lip6.struts.domain.Contact1;
import org.lip6.struts.domain.DAOContact1;


public class SearchAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws NamingException, SQLException {

		System.out.println("Entre dans action search");

		final SearchValidationForm lForm = (SearchValidationForm) pForm;

		final String word = lForm.getWord();
		
		List<Contact1> contacts = new ArrayList<Contact1>();

		DAOContact1 daoContact = new DAOContact1();
		try {
			contacts = daoContact.searchContact(word);
			pRequest.setAttribute("listContacts", contacts);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pMapping.findForward("success");
	}
}