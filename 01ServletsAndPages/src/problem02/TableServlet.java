package problem02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TableServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
					+ "<title>Page Title</title>"
				+ "</head>"
				+ "<body>"
					+ "<table border=\"1\">"
					+ "<thead>"
						+ "<tr>"
							+ "<th>Topic</th>"
							+ "<th>Date</th>"
						+ "</tr>"
					+ "</thead>"
					+ "<tbody>"
						+ "<tr>"
							+ "<td>Introduction</td>"
							+ "<td>" + new Date().toString() +"</td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td>Servlets and Pages</td>"
							+ "<td>" + new Date().toString() +"</td>"
						+ "</tr>"
					+ "</tbody>"
					+ "</table>"
				+ "</body>"
				+ "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
