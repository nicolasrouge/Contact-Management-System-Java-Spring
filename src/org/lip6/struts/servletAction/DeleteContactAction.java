package org.lip6.struts.servletAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.DeleteContactValidationForm;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;
 
 
public class DeleteContactAction extends Action {
     
    public ActionForward execute(final ActionMapping pMapping,
            ActionForm pForm, final HttpServletRequest pRequest,
            final HttpServletResponse pResponse) throws Exception, Exception {
     
    final DeleteContactValidationForm lForm=(DeleteContactValidationForm)pForm;
     
    final long id = lForm.getId();
     
    // delete a Contact
            final DAOContact lDAOContact = new DAOContact();
            final boolean lError = lDAOContact.deleteContact(id);
            
     if(lError == true ) {
                List<Contact> listContacts = new ArrayList<Contact>();
                listContacts = lDAOContact.getListContacts();
            	pRequest.setAttribute("listContacts", listContacts);
                
                // if no exception is raised,  forward "success"
                return pMapping.findForward("success");
            }
            else {
                // If any exception, return the "error" forward
                return pMapping.findForward("error");
            }
        }
    }