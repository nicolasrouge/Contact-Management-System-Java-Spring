package service;

import java.util.List;

import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.PhoneNumber;

public class ContactServiceImpl implements IContactService {
	
	private DAOContact daoContact;

	public void setDaoContact(DAOContact daoContact) {
		this.daoContact = daoContact;
	}
	
	@Override
	public Contact getContact(long id) {
		return daoContact.getContact(id);
	}

	@Override
	public List<PhoneNumber> getPhones(long id) {
		return daoContact.getPhones(id);
	}

	@Override
	public boolean addGroup(String nomGroup) {
		return daoContact.addGroup(nomGroup);
	}

	@Override
	public List<Contact> getListContacts() {
		return daoContact.getListContacts();
	}

	@Override
	public String updateContact(Contact contact) {
		return daoContact.updateContact(contact);
	}

	@Override
	public Contact displayContact(int idcontact) {
		return daoContact.displayContact(idcontact);
	}

	@Override
	public int deleteContact(long id) {
		return daoContact.deleteContact(id);
	}

	@Override
	public List<Contact> searchContact(String word) {
		return daoContact.searchContact(word);
	}

	@Override
	public void addContact(String nom, String prenom, String mail, String phonenumber, String street, String city,
			String zip, String country) {
		daoContact.addContact(nom, prenom, mail, phonenumber, street, city, zip, country);
	}

}
