package log;

import org.lip6.struts.domain.Contact;

public class AOPLoggerRemove {
	public void log(Contact contact) {
		System.out.println("AOP Logger pointcut : before remove contact" + contact + "with id" + contact.getId_contact());
	}
}
