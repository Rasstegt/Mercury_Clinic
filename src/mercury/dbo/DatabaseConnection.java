   package mercury.dbo;

import java.sql.*;


	public class DatabaseConnection {
	    private String url = "jdbc:mysql://localhost:3306/mercury";
	    private String username = "root";
	    private String password = "";
	    
	    public DatabaseConnection() {
	    	try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch(ClassNotFoundException e) {
	            System.out.println("ERROR: Exception loading driver class");
	        }

	    }
 
		@SuppressWarnings("finally")
		public Connection getConnection() {
	        Connection dbCon = null;
	        try {
	            dbCon = DriverManager.getConnection(url, username, password);
	        } catch (SQLException e) {
	            System.err.println("Exception creating Connection object");
	        } finally {
	            return dbCon;
	        }
	        
	    }
	    
	    public static void closeJDBCObjects(Connection conn, Statement stmt, ResultSet rs) {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            
	            if (stmt != null) {
	                stmt.close();
	            }
	            
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ignored) {
	        }
	    }
	    
	    public static void closeJDBCObjects(Connection conn, Statement stmt) {
	        closeJDBCObjects(conn, stmt, null);
	    }
	}
