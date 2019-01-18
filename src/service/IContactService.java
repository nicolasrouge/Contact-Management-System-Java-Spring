package service;

import java.util.List;

import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.PhoneNumber;

public interface IContactService {
	public Contact getContact(long id);
	public List<PhoneNumber> getPhones(long id);
	public boolean addGroup(String nomGroup);
	public List<Contact> getListContacts();
    public Contact displayContact(int idcontact);
    public int deleteContact(long id);
    public List<Contact> searchContact(String word);
	String updateContact(Contact contact);
	public void addContact(String nom, String prenom, String mail, String phonenumber, String street, String city,
			String zip, String country);
}
