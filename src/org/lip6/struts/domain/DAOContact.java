package org.lip6.struts.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.lip6.struts.domain.Contact;

public class DAOContact {
	
	private SessionFactory sessionFactory;
	
	public DAOContact(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean addContact(String firstName, String lastName, String email, String phonenumber, String street, String city, String zip, String country) {
		
		boolean res = false;
		
		// creation d'un contact et son insertion dans la BD
		
		Contact newcontact = new Contact();
		
		newcontact.setContact_ID(1);
		newcontact.setPrenom(lastName);
		newcontact.setNom(firstName);
		newcontact.setMail(email);
		
		Address newaddress = new Address(1,street,city,zip,country);
		
		newcontact.setAddress(newaddress);

		PhoneNumber newphone = new PhoneNumber();
		
		newphone.setPhone_ID(12);
		newphone.setPhoneNumber(phonenumber);
		newphone.setContact(newcontact);
		
		try {
			
			this.sessionFactory.getCurrentSession().save(newaddress);
			this.sessionFactory.getCurrentSession().save(newcontact);
			this.sessionFactory.getCurrentSession().save(newphone);
			
			System.out.print("DAO ADD " + newcontact.getNom());
			
			System.out.println("Done");
			res = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return res;

	}
	
	public Contact getContact(long id) {
		try {
		      this.sessionFactory.getCurrentSession().beginTransaction();
		       
		      Contact c = (Contact) this.sessionFactory.getCurrentSession().load(Contact.class, id);
			return c;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<PhoneNumber> getPhones(long id) {
		try {
			  //Session session = HibernateUtil.getSessionFactory().openSession();
		      //session.beginTransaction();
		      
		      Query q = this.sessionFactory.getCurrentSession().createQuery("select pN from PhoneNumber pN where pN.id = :id");
		      q.setParameter("id", id);
		      @SuppressWarnings("unchecked")
		      List<PhoneNumber> list = q.list();
		      
		      //Contact c = (Contact) session.load(Contact.class, id);
		      //System.out.println("GET CONTACT" + c.getPrenom() + " --------------- ");
		       
		      //Let's verify the entity name
		      //System.out.println(session.getEntityName(c));
		       
		      //session.getTransaction().commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addGroup(String nomGroup) {
		//Session session = null;
		ContactGroup group = new ContactGroup();

		group.setGroup_ID(1);
		group.setGroupName(nomGroup);
		
		//créer un contact au préalable
		//group.setContact(contact);
		
		try {
			
			// utilisation de la classe utilitaire HibernateUtil
			// qui applique le pattern singleton et
			// qui assure que SessionFactory ne sera instanciee qu'une seule fois
			
			//session = HibernateUtil.getSessionFactory().getCurrentSession();

			// mettre les actions entre une transaction
			//org.hibernate.Transaction tx = session.beginTransaction();
			
			this.sessionFactory.getCurrentSession().save(group);
			
			// pour montrer qu'hibernate met à jour systematiquement la base de données
			// et sans faire un save à nouveau
			//contact.setNom("TOTOTOTO");
			
			System.out.println("before Commit instruction");

			System.out.println("Done");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return true;

	}
	
	public List<Contact> getListContacts() {
		List<Contact> lesContacts = new ArrayList<Contact>();
		try {
			StringBuffer requestS = new StringBuffer();
			requestS.append("select contact from Contact contact");
			Query request = this.sessionFactory.getCurrentSession().createQuery(requestS.toString());
			
			@SuppressWarnings("unchecked")
			List<Contact> list = request.list();
			//on récupère chaque contact de la requête et on les mets dans la liste 'lescontacts'
			for(Contact contact : list) {
				Contact c = new Contact(contact);
				c.setContact_ID(contact.getContact_ID());
				lesContacts.add(c);
			}
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
			//Session session = HibernateUtil.getSessionFactory().openSession();
			
			StringBuffer requestS = new StringBuffer();
			requestS.append("select contactGroup from ContactGroup contactGroup");
			System.out.println("DAO GROUP request"+requestS.toString());
			Query request = this.sessionFactory.getCurrentSession().createQuery(requestS.toString());
			
			List<ContactGroup> list = request.list();
			for(ContactGroup group : list) {
				ContactGroup groupe = new ContactGroup();
				groupe.setGroup_ID(group.getGroup_ID());
				groupe.setGroupName(group.getGroupName());
				lesGroupes.add(groupe);
				System.out.println("DAO GROUP "+group.getGroupName());
			}
			
			//session.close();
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
			Contact contact = (Contact) this.sessionFactory.getCurrentSession().get(Contact.class, id);
			this.sessionFactory.getCurrentSession().delete(contact);
			res = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean updateContact(long id, String firstName, String lastName, String email, String phonenumber, String street, String city, String zip, String country){
	    try {
			Contact contact = (Contact) this.sessionFactory.getCurrentSession().get(Contact.class, id);
			System.out.println("UPDATE :" + contact.getMail());
			
			contact.setMail(email);
			contact.setNom(lastName);
			contact.setPrenom(firstName);
			//TODO Phone NUMBER
			contact.getAddress().setCity(city);
			contact.getAddress().setCountry(country);
			contact.getAddress().setStreet(street);
			contact.getAddress().setZip(zip);
			
			this.sessionFactory.getCurrentSession().update(contact);
	    } catch (Exception e) {
	        return true;
	    }
	    return false;
	}
	
	public void generate() {
		addContact("Nicolas", "Rouge", "nicolas.rouge@gmail.com", "0750474601","rue des olives","Nanterre", "92000", "France");
		addContact("Lucas", "Nayet", "lucas.nayet@gmail.com", "0634261733","rue du puit","Nanterre", "92000", "France");
	}

	public List<Contact> searchContact(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	
}