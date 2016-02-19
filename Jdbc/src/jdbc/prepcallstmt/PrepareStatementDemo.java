package jdbc.prepcallstmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.ConnectionFactory;

public class PrepareStatementDemo {

	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();
        prepStmt(conn);
	}
	
	static private void prepStmt(Connection conn){
		String prepStmt = "SELECT * FROM ACTOR WHERE ACTOR_ID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(prepStmt);
		    stmt.setString(1,"3");
			stmt.executeQuery();
		    ResultSet rs = stmt.getResultSet();
		    rs.next();
		    System.out.println(rs.getString(3));		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
