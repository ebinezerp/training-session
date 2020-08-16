package regandlogin.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regandlogin.dto.User;
import regandlogin.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("firstname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setFirstname(name);
		user.setUsername(username);
		user.setPassword(password);

		try {

			UserService userService = new UserService();
			if (userService.saveUser(user)) {
				response.sendRedirect("login.jsp");
			} else {
				request.setAttribute("errorMessage", "Some internal error occured. Try again");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}

		} catch (SQLException e) {
			request.setAttribute("errorMessage", "Some internal error occured. Try again");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}

	}

}
