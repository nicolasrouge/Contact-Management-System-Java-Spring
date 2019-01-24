package service;

import java.util.List;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.ContactGroup;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.PhoneNumber;

public class ContactService implements IContactService {

	private DAOContact daocontact = null;
	
	public ContactService(){
		
	}
	
	public ContactService(DAOContact daocontact) {
		this.daocontact = daocontact;
	}

	public void setDaocontact(DAOContact daocontact) {
		this.daocontact = daocontact;
	}

	@Override
	public boolean createContact(String firstName, String lastName, String email, String phonenumber, String street, String city, String zip, String country) throws Exception {
		return daocontact.addContact(firstName,lastName,email,phonenumber,street,city,zip,country);
	}
	
	@Override
	public boolean createGroup(String nomgroupe) throws Exception {
		return daocontact.addGroup(nomgroupe);
	}

	@Override
	public List<Contact> getListContact() {
		return daocontact.getListContacts();
	}
	
	@Override
	public Contact getContact(long id) {
		return daocontact.getContact(id);
	}

	@Override
	public List<PhoneNumber> getPhones(long id) {
		return daocontact.getPhones(id);
	}
	
	@Override
	public boolean updateContact(long id, String firstName, String lastName, String email, String phonenumber, String street, String city, String zip, String country) throws Exception {
		return daocontact.updateContact(id, firstName, lastName, email, phonenumber, street, city, zip, country);
	}

	@Override
	public boolean deleteContact(long id) throws Exception {
		return daocontact.deleteContact(id);
	}
	
	@Override
	public List<ContactGroup> getListGroup() {
		return daocontact.getListGroup();
	}

	@Override
	public List<Contact> searchContact(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
}
