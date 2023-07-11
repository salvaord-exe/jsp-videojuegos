package Config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class ConnectionBD {
	private String message;	
	private Connection con;
	
	public ConnectionBD() {
		this.con = this.getConnection();
	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con=DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/bd_videojuegos","root","Aa987123654");
	        return con;
		}catch(Exception e) {
			this.message = e.getMessage();
			return null;
		}
	}
	
	public ResultSet execQueryWithResult(String query) {
		Statement stmt;
		ResultSet rs;
		try {
			
			stmt = this.con.createStatement();
			rs=stmt.executeQuery(query);
			//rs = preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        return rs;
	}
	
	public String execQueryWithoutResult(String query) {
		PreparedStatement pstmt;
		String message;
		try {
			pstmt = this.con.prepareStatement(query);
			pstmt.execute();
			message = "Elemento ingresado correctamente";
		}catch(Exception e) {
			message = e.getMessage();
		}
		
		return message;
	}
	
	
	
	
	
	
	
	
	

	
}
