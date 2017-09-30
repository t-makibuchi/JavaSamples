package basic;

import java.sql.*;


public class ConnectDb {
	public static void main (String[] args) {
		try {
			Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
			Connection conn =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/javasamples?",
												"root","mysql");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM sample");
            while ( rset.next() ) {
                System.out.println(rset.getInt(1) + "," + rset.getString(2));
            }
            rset.close();
            stmt.close();
            conn.close();
		}catch (Exception e) {

		}
	}
}