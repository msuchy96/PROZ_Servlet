package atj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Class which implements servlet.
 * @author Maciej Suchocki
 *
 */
@WebServlet(asyncSupported = true, description = "This is my servlet", urlPatterns = { "/testServlet" })

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Method which implements transmission which id executed by server through path to .jsp file.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
			RequestDispatcher reqDis = getServletContext().getRequestDispatcher("/counter.jsp");
			reqDis.forward(request, response);
		
		
	}
}
