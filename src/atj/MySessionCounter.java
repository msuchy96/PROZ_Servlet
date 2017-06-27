package atj;

import javax.servlet.http.HttpSessionListener;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

/**
 * Class which implements session listener.
 * @author Maciej Suchocki
 *
 */
public class MySessionCounter implements HttpSessionListener {
	 
	  private int numberOfSession = 0;
	  private ServletContext servContext = null;
	  
	 
	  
	  /**
	   * Method which is executed when session starts. It increment number of sessions.
	   */
	  public void sessionCreated(HttpSessionEvent event) {
	  
		  synchronized (event.getSession()) {
			  numberOfSession++;
		}
		  
	   
	   if (servContext == null) {
	    storeInServletContext(event);
	   }
	}
	
	/**
	 * Method which is executed when session ends. It decrement number of sessions.
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		synchronized (event.getSession()) {
			numberOfSession--;
		}
		
	}


	/**
	 * Session number getter.
	 * @return number of running sessions
	 */
	public int getNumberOfSession() {
	  return(numberOfSession);
	}

	/**
	 * Method which sets servlet context attribute.
	 * @param event event from which servlet context is taken form
	 */
	  private void storeInServletContext(HttpSessionEvent event) {
	    HttpSession ses = event.getSession();
	    servContext = ses.getServletContext();
	    servContext.setAttribute("servContextName", this);
	  }
}

