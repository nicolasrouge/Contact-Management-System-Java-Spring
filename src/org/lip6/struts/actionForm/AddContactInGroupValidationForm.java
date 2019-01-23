package org.lip6.struts.actionForm;
 
import javax.servlet.http.HttpServletRequest;
 
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
 
public class AddContactInGroupValidationForm extends ActionForm {
     
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private long id=0;
    private long idGroup=0;
    
    public long getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(long idGroup) {
		this.idGroup = idGroup;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.id=0;
        this.idGroup = 0;
      }
     
}