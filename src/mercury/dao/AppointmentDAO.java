package mercury.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mercury.dbo.DatabaseConnection;
import mercury.models.Appointment;

public class AppointmentDAO {

	PreparedStatement ps = null;
	ResultSet rs = null;
	int result = 0;
	
	public ArrayList<Appointment> getAppInfo(Connection dbCon, String username){
		
		ArrayList<Appointment> list = new ArrayList<Appointment>();
		
		try {
			
			String sql = "SELECT a.apptnumber, a.Patient, a.reasonforvisit, DATE_FORMAT(a.datetime, '%Y%m%d') date, DATE_FORMAT(a.datetime, '%H:%i:%s') time, a.IsPatientCheckedIn\r\n" + 
					"  FROM USERs u, patients p, appointments a\r\n" + 
					" WHERE u.username = p.login\r\n" + 
					"   AND p.OHIPNumber = a.patient\r\n" + 
					"   AND u.username = ?;";

			ps = dbCon.prepareStatement(sql);
			ps.setString(1, username);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				String appnumber = rs.getString(1);
				String patient = rs.getString(2);
				String reason = rs.getString(3);
				String date = rs.getString(4);
				String time = rs.getString(5);
				int checkedIn = rs.getInt(6);
								
				Appointment appointment = new Appointment(appnumber, patient, reason, date, time, checkedIn);
				list.add(appointment);
			}

		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		} finally {
			DatabaseConnection.closeJDBCObjects(dbCon, ps, rs);
		}
		return list;
	}
	
	public void createAppointment(Connection dbCon, Appointment apt) {
		
		try {
			String sql = "INSERT INTO appointments (Patient, ReasonForVisit, DateTime, IsPatientCheckedIn) "
					+ "VALUES (?, ?, ?, ?)";
			ps = dbCon.prepareStatement(sql);
			ps.setString(1, apt.getPatient());
			ps.setString(2, apt.getReasonForVisit());
			ps.setString(3, apt.getDate()+" "+apt.getTime());
			ps.setInt(4, apt.getIsPatientCheckedIn());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		} finally {
			DatabaseConnection.closeJDBCObjects(dbCon, ps, rs);
		}
	}
	
	public void deleteAppointment(Connection dbCon, Appointment apt) {
		
		try {
			
			String sql = "DELETE from appointments WHERE apptnumber = ?";
			ps = dbCon.prepareStatement(sql);
			ps.setString(1, apt.getAppNumber());
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		} finally {
			DatabaseConnection.closeJDBCObjects(dbCon, ps, rs);
		}
	}	
	
	public void checkInAppointment(Connection dbCon, Appointment apt) {
		
		try {
			
			String sql = "UPDATE appointments SET IsPatientCheckedIn = 1 WHERE apptnumber = ?";
			ps = dbCon.prepareStatement(sql);
			ps.setString(1, apt.getAppNumber());
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		} finally {
			DatabaseConnection.closeJDBCObjects(dbCon, ps, rs);
		}
	}	
	
}
