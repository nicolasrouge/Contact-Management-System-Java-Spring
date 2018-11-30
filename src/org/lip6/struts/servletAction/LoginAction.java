package org.lip6.struts.servletAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.LoginForm;
import org.lip6.struts.domain.Contact1;
import org.lip6.struts.domain.DAOContact1;

public class LoginAction extends Action {


    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginForm loginForm = (LoginForm) form;
        
        
        DAOContact1 lDAOContact = new DAOContact1();
        
        List<Contact1> listContacts = new ArrayList<Contact1>();
        
        listContacts = lDAOContact.getListContacts();
        
    	request.setAttribute("listContacts", listContacts);
    	
    	
        if (loginForm.getUserName().equals(loginForm.getPassword())) {
            return mapping.findForward("success");
        } else {
            return mapping.findForward("failure");
        }
    }
}