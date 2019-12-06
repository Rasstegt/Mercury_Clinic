package mercury.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mercury.dbo.*;
import mercury.dao.*;
import mercury.models.*;

@WebServlet("/SystemController")
public class SystemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SystemController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uName = request.getParameter("username");
		String pw = request.getParameter("password");

		DatabaseConnection dbc = new DatabaseConnection();
		UserDAO user = new UserDAO();
		HttpSession session = request.getSession();

		int exist = user.checkUser(dbc.getConnection(), uName, pw);

		if (exist != 0) {
			Patient userInfo = user.getUserInfo(dbc.getConnection(), uName);
			session.setAttribute("userInfo", userInfo);
			session.setAttribute("dbCon", dbc);
			session.setAttribute("type", "view");
			request.getRequestDispatcher("CalendarController").forward(request, response);

		} else {
			request.getRequestDispatcher("signIn.jsp").forward(request, response);
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
