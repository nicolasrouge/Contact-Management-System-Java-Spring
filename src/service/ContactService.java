package service;

import java.util.List;

import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.PhoneNumber;

public class ContactService implements IContactService {

	private DAOContact daocontact;
	
	@Override
	public boolean createContact(String firstName, String lastName, String email, String phonenumber, String street, String city, String zip, String country) throws Exception {
		
		return daocontact.addContact(firstName,lastName,email,phonenumber,street,city,zip,country);

	}

	@Override
	public List<Contact> getListContact() {
		// TODO Auto-generated method stub
		return daocontact.getListContacts();
	}

	@Override
	public String updateContact(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact displayContact(int idcontact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteContact(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contact> searchContact(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addGroup(String nomGroup) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void generate() {
		daocontact.generate();
	}

	@Override
	public Contact getContact(long id) {
		return daocontact.getContact(id);
	}

	@Override
	public List<PhoneNumber> getPhones(long id) {
		return daocontact.getPhones(id);
	}
}
