package org.lip6.struts.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lip6.struts.domain.Contact;
import util.HibernateUtil;

public class DAOContact {
	
	private SessionFactory sessionFactory;
	
	public DAOContact()
	{
		
	}
	
	public DAOContact(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean addContact(String firstname, String lastname, String email, String phonenumber, String street, String city, String zip, String country) {
		Session session = null;
		boolean res = false;
		Contact newcontact = new Contact();
		newcontact.setFirstname(lastname);
		newcontact.setLastname(firstname);
		newcontact.setEmail(email);
		Address newaddress = new Address(1,street,city,zip,country);
		newcontact.setAddress(newaddress);
		PhoneNumber newphone = new PhoneNumber();
		newphone.setPhoneNumber(phonenumber);
		newphone.setContact(newcontact);
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(newaddress);
			session.save(newcontact);
			session.save(newphone);
			session.getTransaction().commit();
			res = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	public Contact getContact(long id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//get contact from session
			Contact c = (Contact) session.get(Contact.class, id);
			
			//Let's verify the entity name
			System.out.println(session.getEntityName(c));
			session.getTransaction().commit();
			return c;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<PhoneNumber> getPhones(long id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//HQL parameter request
			Query q = session.createQuery("select phoneNumber from PhoneNumber phoneNumber where phoneNumber.id = :id");
			q.setParameter("id", id);
			@SuppressWarnings("unchecked")
			List<PhoneNumber> list = q.list();
			session.getTransaction().commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addGroup(String nomGroup) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			ContactGroup group = new ContactGroup();
			group.setId_group(1);
			group.setGroupName(nomGroup);
			
			org.hibernate.Transaction tx = session.beginTransaction();
			session.save(group);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return true;
	}
	
	public List<Contact> getListContacts() {
		List<Contact> lesContacts = new ArrayList<Contact>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			//Criteria request
			Criteria criteria = session.createCriteria(Contact.class);
			
			@SuppressWarnings("unchecked")
			List<Contact> list = criteria.list();
			
			for(Contact contact : list) {
				Contact c = new Contact(contact);
				c.setId_contact(contact.getId_contact());
				lesContacts.add(c);
			}
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
	}
		return lesContacts;
	}
	
	public List<ContactGroup> getListGroup(){
		List<ContactGroup> lesGroupes = new ArrayList<ContactGroup>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			//Criteria request
			Criteria criteria = session.createCriteria(ContactGroup.class);
			
			@SuppressWarnings("unchecked")
			List<ContactGroup> list = criteria.list();
			
			for(ContactGroup group : list) {
				ContactGroup groupe = new ContactGroup();
				groupe.setId_group(group.getId_group());
				groupe.setGroupName(group.getGroupName());
				lesGroupes.add(groupe);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
	}
		return lesGroupes;
}
	
	public boolean deleteContact(long id) {
    	boolean res = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			Contact contact = (Contact) session.get(Contact.class, id);
			System.out.println("DELETE :" + contact.getEmail());
			
			session.beginTransaction();
			session.delete(contact);
			session.getTransaction().commit();
			res = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean updateContact(long id, String firstname, String lastname, String email, String phonenumber, String street, String city, String zip, String country){
	    try {
	    	Session session = HibernateUtil.getSessionFactory().openSession();
			
			Contact contact = (Contact) session.get(Contact.class, id);
			System.out.println("UPDATE :" + contact.getEmail());
			
			contact.setEmail(email);
			contact.setLastname(lastname);
			contact.setFirstname(firstname);
			contact.getAddress().setCity(city);
			contact.getAddress().setCountry(country);
			contact.getAddress().setStreet(street);
			contact.getAddress().setZip(zip);
			
			@SuppressWarnings("rawtypes")
			Iterator it = contact.getPhones().iterator();
			   while(it.hasNext()) {
				      PhoneNumber obj = (PhoneNumber)it.next();
				      obj.setPhoneNumber(phonenumber);
				    }
			   
			session.beginTransaction();
			session.update(contact);
			session.getTransaction().commit();
			session.close();
	    } catch (Exception e) {
	        return true;
	    }
	    return false;
	}
	
	/*
    public List<Contact1> searchContact(String word) throws NamingException, SQLException {
		System.out.println("Entre dans search contact DAO");
		List<Contact1>contacts = new ArrayList<Contact1>();
        Context lContext = new InitialContext();
        DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
        Connection lConnection  = lDataSource.getConnection();
		try {
			final PreparedStatement lPreparedStatementContact = lConnection.prepareStatement("SELECT ID_CONTACT, LASTNAME, FIRSTNAME, EMAIL FROM contact WHERE ID_CONTACT LIKE ? OR LASTNAME LIKE ? OR FIRSTNAME LIKE ? OR EMAIL LIKE ?");
			lPreparedStatementContact.setString(1, "%" + word + "%");
			lPreparedStatementContact.setString(2, "%" + word + "%");
			lPreparedStatementContact.setString(3, "%" + word + "%");
			lPreparedStatementContact.setString(4, "%" + word + "%");
			ResultSet rsContact = lPreparedStatementContact.executeQuery();

			while (rsContact.next()) {

				final Long id = rsContact.getLong("ID_CONTACT");
				final String lastname = rsContact.getString("LASTNAME");
				final String firstname = rsContact.getString("FIRSTNAME");
				final String email = rsContact.getString("EMAIL");

				contacts.add(new Contact1(id, lastname, firstname, email));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally{
			try {
				if(lConnection!=null) {
					lConnection.close();
					//return ArrayList;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contacts;
    	}
	*/
	public void generate() {
		addContact("Rouge", "Nicolas", "nicolas.rouge@gmail.com", "0750474601","rue des olives","Nanterre", "92000", "France");
		addContact("Nayet", "Lucas", "lucas.nayet@gmail.com", "0634261733","rue du puit","Nanterre", "92000", "France");
	}

	public boolean addContactToGroup(Long idContact, Long idGroup) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			ContactGroup group = (ContactGroup) session.get(ContactGroup.class, idGroup);
			Contact contact = (Contact) session.get(Contact.class, idContact);
			
			if(group.getContacts()== null)
				group.setContacts(new HashSet<Contact>());
			group.getContacts().add(contact);
			
			if (contact.getGroups() == null)
				contact.setGroups(new HashSet<ContactGroup>());
			contact.getGroups().add(group);
			
			session.beginTransaction();
			session.saveOrUpdate(group);
			session.getTransaction().commit();
			
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
}

	public List<Contact> getGroupContacts(Long idGroupContact) {
		List<Contact> lesContacts = new ArrayList<Contact>();

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			/* requete from stackoverflow
			 * avec Hql on a besoin des alias
			 * createQuery("SELECT p FROM Product p JOIN p.categories c WHERE c.id = :idCategory");
			 * query.setParameter("idCategory", category.getId());
			 * */
			
			//HQL parameter request
			Query q = session.createQuery("select contact from Contact as contact join contact.groups as group where group.id_group = :id");
			q.setParameter("id", idGroupContact);
			
			@SuppressWarnings("unchecked")
			List<Contact> list = q.list();
			
			for(Contact contact : list) {
				Contact c = new Contact(contact);
				c.setId_contact(contact.getId_contact());
				lesContacts.add(c);
			}			
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lesContacts;
	}
	public List<Contact> getContactsOutOfGroup(Long idGroupContact) {
		List<Contact> lesContacts = new ArrayList<Contact>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			//HQL simple request
			Query q = session.createQuery("select contact from Contact as contact");
			
			@SuppressWarnings("unchecked")
			List<Contact> list = q.list();
			
			for(Contact contact : list) {
				Contact c = new Contact(contact);
				c.setId_contact(contact.getId_contact());
				lesContacts.add(c);
			}			
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lesContacts;
	}
}