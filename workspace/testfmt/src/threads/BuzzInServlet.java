package threads;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class BuzzInServlet extends HttpServlet {

	/** The attribute name used throughout. */
	protected final static String WINNER = "buzzin.winner";

	/**
	 * doGet is called from the contestants web page. Uses a synchronized code
	 * block to ensure that only one contestant can change the state of
	 * "buzzed".
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = getServletContext();

		boolean iWon = false;
		String user = request.getRemoteHost() + '@' + request.getRemoteAddr();

		// Do the synchronized stuff first, and all in one place.
		synchronized (application) {
			if (application.getAttribute(WINNER) == null) {
				application.setAttribute(WINNER, user);
				application.log("BuzzInServlet: WINNER " + user);
				iWon = true;
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Thanks for playing</title></head>");
		out.println("<body bgcolor=\"white\">");

		if (iWon) {
			out.println("<b>YOU GOT IT</b>");
			// TODO - output HTML to play a sound file :-)
		} else {
			out.println("Thanks for playing, " + request.getRemoteAddr());
			out.println(", but " + application.getAttribute(WINNER)
					+ " buzzed in first");
		}
		out.println("</body></html>");
	}

	/**
	 * The Post method is used from an Administrator page (which should only be
	 * installed in the instructor/host's localweb directory). Post is used for
	 * administrative functions: 1) to display the winner; 2) to reset the
	 * buzzer for the next question.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = getServletContext();

		response.setContentType("text/html");
		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();

		if (request.getParameter("password").equals("zz3zcwbjavahome")) {
			out.println("<html><head><title>Welcome admin back, "
					+ "</title><head>");
			out.println("<body bgcolor=\"white\">");
			String command = request.getParameter("command");
			if (command.equals("reset")) {

				// Synchronize what you need, no more, no less.
				synchronized (application) {
					application.setAttribute(WINNER, null);
				}
				session.setAttribute("buzzin.message", "RESET");
			} else if (command.equals("show")) {
				String winner = null;
				synchronized (application) {
					winner = (String) application.getAttribute(WINNER);
				}
				if (winner == null) {
					session.setAttribute("buzzin.message",
							"<b>No winner yet!</b>");
				} else {
					session.setAttribute("buzzin.message", "<b>Winner is: </b>"
							+ winner);
				}
			} else {
				session.setAttribute("buzzin.message", "ERROR: Command "
						+ command + " invalid.");
			}
			RequestDispatcher rd = application
					.getRequestDispatcher("/myexample/servlets/buzzin/hot/password.jsp");
			rd.forward(request, response);
		} else {
			out.println("<html><head><title>Nice try, but... </title><head>");
			out.println("<body bgcolor=\"white\">");
			out.println("I'm sorry, need password");

		}
		out.println("</body></html>");
	}
}