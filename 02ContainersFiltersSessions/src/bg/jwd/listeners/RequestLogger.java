package bg.jwd.listeners;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class RequestLogger implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		System.out.println("Session ID: " + session.getId());
		System.out.println("Session created on: " + new Date().toString());
}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		
	}
}
