package service;

import java.util.List;

import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.ContactGroup;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.PhoneNumber;

public interface IContactService {

	public boolean createContact(String firstName, String lastName, String email, String phonenumber, String street, String city, String zip, String country) throws Exception;
	
	public List<Contact> getListContact();
	
	public Contact getContact(long id);
	
	public List<PhoneNumber> getPhones(long id);
	
	public boolean updateContact(long id, String firstName, String lastName, String email, String phonenumber, String street, String city, String zip, String country) throws Exception;
	
	public Contact displayContact(int idcontact);
	
	public boolean deleteContact(long id) throws Exception;
	
	public List<Contact> searchContact(String keyword);
	
	public List<ContactGroup> getListGroup();
	
	public List<Contact> getGroupContacts(Long idGroupContact);
	
	public List<Contact> getContactsOutOfGroup(Long idGroupContact);
	
	public boolean addContactToGroup(Long idContact, Long idGroup);
}
