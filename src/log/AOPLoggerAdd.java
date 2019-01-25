package log;

import org.lip6.struts.domain.Contact;

public class AOPLoggerAdd {
	public void log(Contact contact) {
		System.out.println("AOP Logger pointcut : before add contact" + contact);
	}

}
