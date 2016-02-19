package jdbc.resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.ConnectionFactory;

public class ResultSetDemo {

	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();
                
		//queryActorResultSet(conn);
		//readResultSetMetaData(conn);
		cursorPositioning(conn);
		//cursorPositioningForwardOnlyRS(conn);
	}
	
	/**
	 * query+out actor table 
	 * @param conn
	 */
	private static void queryActorResultSet(Connection conn){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ACTOR");
			while(rs.next()){
				System.out.format("%1$-20s %2$-20s %3$-20s \n", rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			conn.close();
        }
        catch(SQLException e){
        	System.out.println(e.getMessage());
        }
	}
	
	/**
	 * read metadata from resultset
	 * @param conn
	 */
	private static void readResultSetMetaData(Connection conn){
		try{
			Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM ACTOR");
		    ResultSetMetaData rsmd = rs.getMetaData();
		    System.out.format("%1$-5s %2$-15s %3$-5s %4$-15s",   
		    		                    rsmd.getColumnCount(),
									    rsmd.getColumnName(1),
									    rsmd.getColumnDisplaySize(1),
									    rsmd.getTableName(1));
		}
		catch(SQLException e){
			
		}
	}
	
	/**
	 * cursor positioning 
	 * @param conn
	 */
	private static void cursorPositioning(Connection conn){
		try{
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					                                ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("SELECT * FROM ACTOR where actor_id<10");
			rs.absolute(3);
			System.out.format("%1$-20s %2$-20s %3$-20s \n", rs.getInt(1),rs.getString(2),rs.getString(3));
			rs.previous();
			System.out.format("%1$-20s %2$-20s %3$-20s \n", rs.getInt(1),rs.getString(2),rs.getString(3));
			
			rs.beforeFirst();
			System.out.println("Before first cursor pos :" + rs.getRow());
			rs.first();
			System.out.println("First cursor pos :" + rs.getRow() + "!!!");
			rs.afterLast();
			System.out.println("After last cursor pos :" + rs.getRow());
			
		}
		catch(SQLException e){
			
		}
	}
	
	/**
	 * cursor positioning relative to resultset scroll type : does not seem to matter here
	 * @param conn
	 */
	private static void cursorPositioningForwardOnlyRS(Connection conn){
		try{
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
					                                ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("SELECT * FROM ACTOR where actor_id<10");
			//this should not work for this resultset Type, but it does?
			rs.previous();			
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	
}
