package mercury.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mercury.dbo.DatabaseConnection;
import mercury.models.Patient;

public class UserDAO {

	PreparedStatement ps = null;
    ResultSet rs = null;
    int check = 0;
    String validation;
    
    public int checkUser(Connection dbCon, String uName, String pw) {

        try {
        	
            String sql = "SELECT username  FROM users WHERE username = ? AND PASSWORD = ?";

            ps = dbCon.prepareStatement(sql);
            ps.setString(1, uName);
            ps.setString(2, pw);


            rs = ps.executeQuery();
            while(rs.next()) {
                 validation = rs.getString("username");
            }


            if(uName.equals(validation)) {
                check=1;
            }
            else {
                check=0;
            }
            
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        } finally {
            DatabaseConnection.closeJDBCObjects(dbCon, ps, rs);
        }
        return check;
    }
	
    
	public Patient getUserInfo(Connection dbCon, String username) {
		
		Patient user = null;
		try {
		
		String sql = "SELECT p.firstName, p.lastName, u.username, "
				+ "p.OHIPNumber, p.DateOfBirth, p.OHIPVersion, p.Gender" + 
				"  FROM users u, patients p " + 
				" WHERE u.username = p.login " + 
				"   AND u.username = ? ";
		ps = dbCon.prepareStatement(sql);
		ps.setString(1, username);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			String fName = rs.getString("firstName");
			String lName = rs.getString("lastName");
			String uName = rs.getString("username");
			String ohipNum = rs.getString("OHIPNumber");
			String dob = rs.getString("DateOfBirth");
			String ohipVer = rs.getString("OHIPVersion");
			String gender = rs.getString("Gender");
			
			user = new Patient(ohipNum, ohipVer, fName, lName, uName, gender, dob);
		} else {
			// user doesnt exist
		}

		} catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		
		return user;
		
	}
	
	public void createProfile(Connection dbCon, Patient patient, String password) throws SQLException {
		
		String sql = "INSERT INTO users (username, role, password) VALUES (?, 2, ?)";	
		
		ps = dbCon.prepareStatement(sql);
		
		ps.setString(1, patient.getLogin());
		ps.setString(2, password);
		
		check = ps.executeUpdate();
		
		sql = "INSERT INTO patients (OHIPNumber, OHIPVersion, FirstName, LastName, Login, Gender, DateOfBirth) \r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		ps = dbCon.prepareStatement(sql);
		
		ps.setString(1, patient.getOhipNumber());
		ps.setString(2, patient.getOhipVersion());
		ps.setString(3, patient.getfName());
		ps.setString(4, patient.getlName());
		ps.setString(5, patient.getLogin());
		ps.setString(6, patient.getGender());
		ps.setString(7, patient.getDateOfBirth());
		
		check = ps.executeUpdate();
		
		DatabaseConnection.closeJDBCObjects(dbCon, ps, rs);
		
	}
	
	public void updateProfile(Connection dbCon, Patient patient, String password) {
		
		try {
		
			String sql = "UPDATE users SET PASSWORD = ? WHERE username = ?";
			ps = dbCon.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, patient.getLogin());
			check = ps.executeUpdate();
			
			sql = "UPDATE patients SET OHIPVersion = ?, firstName = ?, lastName = ?, gender=? WHERE OHIPNumber = ?";
			ps = dbCon.prepareStatement(sql);
			ps.setString(1, patient.getOhipVersion());
			ps.setString(2, patient.getfName());
			ps.setString(3, patient.getlName());
			ps.setString(4, patient.getGender());
			ps.setString(5, patient.getOhipNumber());
			check = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseConnection.closeJDBCObjects(dbCon, ps, rs);
		}
		
	}
	
	public boolean duplicateCheck(Connection dbCon, String username) {

		boolean check = true;
		
		try {
			String sql = "SELECT username FROM users "
					+ "\nWHERE UPPER(username) LIKE UPPER('%"+username+"%')";
			
			ps = dbCon.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				check = false;
			}
			
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		} 
	
		DatabaseConnection.closeJDBCObjects(dbCon, ps, rs);
	
		return check;
	}
	
	public boolean ohipCheck(Connection dbCon, String ohipNum) {

		boolean check = true;
		
		try {
			String sql = "SELECT OHIPNumber FROM patients "
					+ "\nWHERE OHIPNumber LIKE "+ohipNum+")";
			
			ps = dbCon.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				check = false;
			}
			
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		} 
	
		DatabaseConnection.closeJDBCObjects(dbCon, ps, rs);
	
		return check;
	}

}
