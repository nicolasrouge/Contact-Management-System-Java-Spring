package org.lip6.struts.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lip6.struts.domain.Contact;
import util.HibernateUtil;

public class DAOContact {

	public boolean addContact(String firstName, String lastName, String email, String phonenumber, String street, String city, String zip, String country) {
		Session session = null;
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
			session = HibernateUtil.getSessionFactory().getCurrentSession();

			// mettre les actions entre une transaction
			org.hibernate.Transaction tx = session.beginTransaction();
			System.out.print("DAO ADD " + newcontact.getNom());
			
			session.save(newaddress);
			session.save(newcontact);
			session.save(newphone);
			//session.save(groupe);
			//session.save(entreprise);
			
			// pour montrer qu'hibernate met à jour systematiquement la base de
			// données
			// et sans faire un save à nouveau
			//contact.setNom("TOTOTOTO");

			System.out.println("before Commit instruction");
			// Commiter la transaction sinon rien ne se passe
			tx.commit();
			
			System.out.println("Done");
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
		       
		      Contact c = (Contact) session.load(Contact.class, id);
		      System.out.println("GET CONTACT" + c.getPrenom() + " --------------- ");
		       
		      //Let's verify the entity name
		      System.out.println(session.getEntityName(c));
		       
		      session.getTransaction().commit();
			return c;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ContactGroup getGroup(long id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		       
		      ContactGroup group = (ContactGroup) session.load(ContactGroup.class, id);
		      System.out.println("GET GROUP" + group.getGroupName() + " --------------- ");
		       
		      //Let's verify the entity name
		      System.out.println(session.getEntityName(group));
		       
		      session.getTransaction().commit();
			return group;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteContact(long id) {
    	boolean res = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//Query q = session.createQuery("delete c from Contact c where c.id = :id");
			//q.setParameter("id", id);
			Contact contact = (Contact) session.get(Contact.class, id); //session.get(Contact.class, id);
			System.out.println("DELETE :" + contact.getMail());
			session.delete(contact);
			session.getTransaction().commit();
			session.close();
			res = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public List<PhoneNumber> getPhones(long id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      
		      Query q = session.createQuery("select pN from PhoneNumber pN where pN.id = :id");
		      q.setParameter("id", id);
		      @SuppressWarnings("unchecked")
			List<PhoneNumber> list = q.list();
		      
		      //Contact c = (Contact) session.load(Contact.class, id);
		      //System.out.println("GET CONTACT" + c.getPrenom() + " --------------- ");
		       
		      //Let's verify the entity name
		      //System.out.println(session.getEntityName(c));
		       
		      session.getTransaction().commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addGroup(String nomGroup) {
		Session session = null;
		ContactGroup group = new ContactGroup();

		group.setGroup_ID(1);
		group.setGroupName(nomGroup);
		
		//créer un contact au préalable
		//group.setContact(contact);
		
		try {
			
			// utilisation de la classe utilitaire HibernateUtil
			// qui applique le pattern singleton et
			// qui assure que SessionFactory ne sera instanciee qu'une seule fois
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();

			// mettre les actions entre une transaction
			org.hibernate.Transaction tx = session.beginTransaction();
			
			session.save(group);
			
			// pour montrer qu'hibernate met à jour systematiquement la base de données
			// et sans faire un save à nouveau
			//contact.setNom("TOTOTOTO");
			
			System.out.println("before Commit instruction");
			// Commiter la transaction sinon rien ne se passe
			tx.commit();

			System.out.println("Done");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return true;

	}
	
	public List<Contact> getListContacts() {
		List<Contact> lesContacts = new ArrayList<Contact>();
		try {
			//Session session = null;
			//session = HibernateUtil.getSessionFactory().getCurrentSession();
			//org.hibernate.Transaction tx = session.beginTransaction();
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			StringBuffer requestS = new StringBuffer();
			requestS.append("select contact from Contact contact");
			Query request = session.createQuery(requestS.toString());
			
			@SuppressWarnings("unchecked")
			List<Contact> list = request.list();
			//on récupère chaque contact de la requète et on les mets dans la liste 'lescontacts'
			for(Contact contact : list) {
				Contact c = new Contact(contact);
				c.setContact_ID(contact.getContact_ID());
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
			
			StringBuffer requestS = new StringBuffer();
			requestS.append("select group from ContactGroup group");
			Query request = session.createQuery(requestS.toString());
			
			@SuppressWarnings("unchecked")
			List<ContactGroup> list = request.list();
			for(ContactGroup group : list) {
				ContactGroup groupe = new ContactGroup(group);
				groupe.setGroup_ID(group.getGroup_ID());
				lesGroupes.add(groupe);
			}
			
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
	}
		return lesGroupes;
	}
	
	
	
	public boolean updateContact(long id,String firstName, String lastName, String email, String phonenumber, String street, String city, String zip, String country){
    try {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//Query q = session.createQuery("delete c from Contact c where c.id = :id");
		//q.setParameter("id", id);
		Contact contact = (Contact) session.get(Contact.class, id); //session.get(Contact.class, id);
		System.out.println("UPDATE :" + contact.getMail());
		
		contact.setMail(email);
		contact.setNom(lastName);
		contact.setPrenom(firstName);
		//TODO Phone NUMBER
		contact.getAddress().setCity(city);
		contact.getAddress().setCountry(country);
		contact.getAddress().setStreet(street);
		contact.getAddress().setZip(zip);
		
		session.update(contact);
		session.getTransaction().commit();
		session.close();
    } catch (Exception e) {
        return true;
    }
    return false;
}
	public void generate() {
		addContact("Nicolas", "Rouge", "nicolas.rouge@gmail.com", "0750474601","rue des olives","Nanterre", "92000", "France");
		addContact("Lucas", "Nayet", "lucas.nayet@gmail.com", "0634261733","rue du puit","Nanterre", "92000", "France");
	}
	
	public boolean addContactToGroup(Long idContact, Long idGroup) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			ContactGroup group = (ContactGroup) session.get(ContactGroup.class, idGroup);
			Contact contact = (Contact) session.get(Contact.class, idContact);
			
			if(group.getContacts()== null)
				group.setContact(contact);
			group.getContacts().add(contact);
			
			
			if (contact.getGroups() == null)
				contact.setGroups(new HashSet<ContactGroup>());
			contact.getGroups().add(group);
			
			session.saveOrUpdate(group);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
}
	
}