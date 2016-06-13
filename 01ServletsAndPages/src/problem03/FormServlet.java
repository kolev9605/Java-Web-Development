package problem03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FormServlet() {
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
					+ "<form>"
						+  "ID: "
						+ "<input type=\"text\" name=\"id\"><br>"
						+ "Topic: "
						+ "<input type=\"text\" name=\"topic\"><br>"
						+ "Date: "
						+ "<input type=\"text\" name=\"date\"><br>"
						+ "<button type=\"button\">Submit</button>"
						+ "<button type=\"button\">Cancel</button>"
					+ "</form>"
				+ "</body>"
				+ "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
