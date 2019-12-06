package mercury.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mercury.dao.UserDAO;
import mercury.dbo.DatabaseConnection;
import mercury.models.Patient;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DatabaseConnection dbCon = null;
 
	public UserController() {
	  dbCon = new DatabaseConnection();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		UserDAO user = new UserDAO();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if (type.equals("createProfile")) {

			try {
				
				String ohipNum = request.getParameter("ohipNum");
				String ohipVer = request.getParameter("ohipVer");
				String fName = request.getParameter("fName");
				String lName = request.getParameter("lName");
				String login = request.getParameter("username");
				String gender = request.getParameter("gender");
				String birth = request.getParameter("dateOfBirth");
				String password = request.getParameter("password");
				String passwordConf = request.getParameter("passwordConfirm");
				
				
				
				if(!user.duplicateCheck(dbCon.getConnection(), login)) {
					out.append("<div class='error'>"
							+ "<p>Username already exists"
							+ "</div>");
				} 
				
				if (!user.duplicateCheck(dbCon.getConnection(), ohipNum)) {
					out.append("<div class='error'>"
							+ "<p>OhipNumber already exists"
							+ "</div>");
				} 
				
				if (password != passwordConf) {
					out.append("<div class='error'>"
							+ "<p>Passwords don't match"
							+ "</div>");
				}
				
				Patient patient = new Patient(ohipNum, ohipVer, fName, lName, login, gender, birth);
				user.createProfile(dbCon.getConnection(), patient, password);
				
				Patient userInfo = user.getUserInfo(dbCon.getConnection(), login);
				session.setAttribute("userInfo", userInfo);

				request.getRequestDispatcher("FrontEnd/homePage.jsp").forward(request, response);

			} catch (SQLException e) {
				System.out.print(e);
			}
			
		} else if(type.equals("updateInfo")) {

			String ohipVer = request.getParameter("ohipVer");
			String fName = request.getParameter("fName");
			String lName = request.getParameter("lName");
			String ohipNum = request.getParameter("ohipNum");
			String gender = request.getParameter("gender");
			String uName = request.getParameter("username");
			
			Patient patient = new Patient(uName, ohipNum, fName, lName, gender, ohipVer);

			String password = request.getParameter("password");
			user.updateProfile(dbCon.getConnection(), patient, password);

			Patient userInfo = user.getUserInfo(dbCon.getConnection(), uName);
			session.setAttribute("userInfo", userInfo);
			
			request.getRequestDispatcher("FrontEnd/updateProfile.jsp").forward(request, response);
			
			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
