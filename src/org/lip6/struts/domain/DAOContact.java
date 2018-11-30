package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.lip6.struts.domain.Contact;
import util.HibernateUtil;

public class DAOContact {
	public void addContact(String firstName, String lastName, String email, String phonenumber/*String street, String city, String zip, String country*/) {
		Session session = null;
		
		// creation d'un contact et son insertion dans la BD
		
		// dans le cas d'une startegie de generation de cle "increment" par exp,
		// cette ligne peut être omise
		// car l'id sera affecté automatiquement comme max des id + 1 (de la
		// table contact)
		// contact.setId(1);
		
		Contact contact = new Contact();
		
		contact.setContact_ID(1);
		contact.setPrenom(lastName);
		contact.setNom(firstName);
		contact.setMail(email);
		
		Address address = new Address(1,"","","","");
		
		contact.setAddress(address);

		PhoneNumber phone = new PhoneNumber();
		phone.setPhone_ID(12);
		phone.setPhoneNumber(phonenumber);
		phone.setContact(contact);
		
		//ContactGroup groupe = new ContactGroup();
		//groupe.setGroup_ID(1);
		//groupe.setGroupName("M2C");
		//groupe.setContact(contact);
		
		//Entreprise entreprise = new Entreprise(22,"bon","ae","bon.ae@gmail.com",address1,362521879);
		
		try {
			
			// utilisation de la classe utilitaire HibernateUtil
			// qui applique le pattern singleton et
			// qui assure que SessionFactory ne sera instanciee qu'une seule
			// fois

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			// mettre les actions entre une transaction
			org.hibernate.Transaction tx = session.beginTransaction();
			
			session.save(address);
			session.save(contact);
			session.save(phone);
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
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

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
}

	/*
	public void displayContact() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			org.hibernate.Transaction tx = session.beginTransaction();
			
			StringBuffer requests = new StringBuffer();
			requests.append("select contact from Contact contact");
			Query request = session.createQuery( requests.toString() );
			List results = request.list();
			
			Object[] firstResult = (Object[]) results.get(0);
			Contact contact = (Contact)firstResult[0];
			Address address = (Address) firstResult[1];
			
			tx.commit();
			System.out.println("LISTE ---------------> " + contact.getNom());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}*/
