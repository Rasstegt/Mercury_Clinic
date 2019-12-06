package mercury.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mercury.dbo.DatabaseConnection;
import mercury.dao.AppointmentDAO;
import mercury.models.Appointment;
import mercury.models.Patient;

@WebServlet("/CalendarController")
public class CalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DatabaseConnection dbCon = null;
	
	public CalendarController() {
		dbCon = new DatabaseConnection();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String click = request.getParameter("click");
		AppointmentDAO appointment = new AppointmentDAO();
		HttpSession session = request.getSession();
		
		Patient patient = (Patient)session.getAttribute("userInfo");
		String type = (String) session.getAttribute("type");
		DatabaseConnection dbCon = (DatabaseConnection)session.getAttribute("dbCon");
		
		if(type.equals("view")) {
			String user = patient.getLogin();
			
			ArrayList<Appointment> list = appointment.getAppInfo(dbCon.getConnection(), user);
			ArrayList<Appointment> todayList = new ArrayList<Appointment>();
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyMMdd");
			String today = dateFormat.format(cal.getTime());
			cal.add(Calendar.DATE, 1);
			
			for(int i=0; i < list.size(); i++) {
				if (list.get(i).getDate().equals(today))
					todayList.add(list.get(i));
			}
				request.setAttribute("today", todayList);
				request.setAttribute("checkIn", appointment.getAppInfo(dbCon.getConnection(), user));
				request.getRequestDispatcher("FrontEnd/homePage.jsp").forward(request, response);
		
		}
		
		if(click.equals("scheduleAppointment")) {
			
			Appointment apt = new Appointment();
			
			apt.setPatient(patient.getOhipNumber());
			apt.setDate(request.getParameter("date"));
			apt.setTime(request.getParameter("time") + ":00");
			apt.setIsPatientCheckedIn(0);
			apt.setReasonForVisit(request.getParameter("reason"));
			
			appointment.createAppointment(dbCon.getConnection(), apt);
			request.setAttribute("type", "view");
			request.setAttribute("userInfo", patient);
			request.setAttribute("dbCon", dbCon);
			request.getRequestDispatcher("CalendarController").forward(request, response);
		
		} else if(click.equals("deleteAppointment")) {
			
			Appointment apt = new Appointment();

			apt.setAppNumber(request.getParameter("apptNumber"));
			appointment.deleteAppointment(dbCon.getConnection(), apt);
			request.setAttribute("type", "view");
			request.setAttribute("userInfo",  patient);
			request.setAttribute("dbCon", dbCon);
			request.getRequestDispatcher("CalendarController").forward(request, response);
			
		} else if(click.equals("checkIn")) {
			
			Appointment apt = new Appointment();
			
			apt.setAppNumber(request.getParameter("apptNumber"));
			appointment.checkInAppointment(dbCon.getConnection(), apt);
			request.setAttribute("type", "view");
			request.setAttribute("userInfo",  patient);
			request.setAttribute("dbCon", dbCon);
			request.getRequestDispatcher("CalendarController").forward(request, response);
			
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
