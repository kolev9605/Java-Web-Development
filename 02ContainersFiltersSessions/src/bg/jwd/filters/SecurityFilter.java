package bg.jwd.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/pages/HomePage.jsp")
public class SecurityFilter implements Filter {

	public final static String ADMIN_USR = "admin";
	public final static String ADMIN_PWD = "1234";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		String requestUsername = request.getParameter("username");
		String requestPassword = request.getParameter("password");

		if (requestUsername != null && requestPassword != null) {
			if (this.ADMIN_USR.equals(requestUsername) && this.ADMIN_PWD.equals(requestPassword)) {
				session.setAttribute("username", requestUsername);
				session.setAttribute("password", requestPassword);
				httpResponse.sendRedirect("HomePage.jsp");
			} else {
				httpResponse.sendRedirect("Login.jsp");
			}
		} else {
			Object userObj = session.getAttribute("username");
			Object pwdObj = session.getAttribute("password");
			if (userObj == null || pwdObj == null) {
				httpResponse.sendRedirect("Login.jsp");
			} else {
				requestUsername = userObj.toString();
				requestPassword = pwdObj.toString();
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
