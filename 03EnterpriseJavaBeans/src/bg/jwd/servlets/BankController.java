package bg.jwd.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.jwd.beans.GlobalUserData;

@WebServlet("/Test")
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	GlobalUserData globalData;

	public BankController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String clientId = request.getParameter("client_id");
		Double currentAmount = Double.parseDouble(request.getParameter("current_amount"));
		String option = request.getParameter("option");
		Double amount = Double.parseDouble(request.getParameter("amount"));

		StringBuilder log = new StringBuilder();

		if (option.equals("deposit")) {
			log.append(this.globalData.addClient(clientId, currentAmount) + "\n");
			log.append(this.globalData.deposit(clientId, amount) + "\n");
		} else {
			if (this.globalData.hasAccount(clientId)) {
				log.append(this.globalData.addClient(clientId, currentAmount) + "\n");
				log.append(this.globalData.withdraw(clientId, amount) + "\n");
			} else {
				log.append("You cannot withdraw without account.\n");
				log.append(this.globalData.addClient(clientId, currentAmount) + "\n");
			}
		}

		response.getWriter().append("------ Log of the last request ------\n");
		response.getWriter().append(log.toString() + "\n");
		response.getWriter().append("--------------------------------\n");
		response.getWriter().append("------ Info about the current client ------\n");
		response.getWriter().append("Current client data: " + this.globalData.getCurrentClient(clientId) + "\n");
		response.getWriter().append("--------------------------------\n");
		response.getWriter().append("------ List of all clients ------\n");
		response.getWriter().append(this.globalData.displayClients());
		response.getWriter().append("--------------------------------\n");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
