package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author tatsuya.makibuchi
 *
 */
class CommonUtil {

	Scanner getScanner() {
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}


	String stInput(Scanner scanner, String preInputMsg) {
	    System.out.println(preInputMsg);
	    String inputString = scanner.nextLine();
		return inputString;
	}


	Connection getDbConnection () {
		Connection conn = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasamples?",
												"root","mysql");
			conn.setAutoCommit(false);
			return conn;
		}catch (Exception e) {
			e.printStackTrace();
			return conn;
		}
	}

	void commitConnection(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param conn
	 * @param sql
	 */
	void executeQuery (Connection conn, String sql) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
            rset.close();
            stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param conn
	 * @param sql
	 */
	Integer executeUpdate (Connection conn, String sql) {
		Integer updateCount = 0;
		try {
			Statement stmt = conn.createStatement();
			updateCount = stmt.executeUpdate(sql);
            stmt.close();
            return updateCount;
		} catch (Exception e) {
			e.printStackTrace();
			return updateCount;
		}
	}

	/**
	 * @param conn
	 */
	void closeDbConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	String getHMSfromNanotime(long nano) {
		String hms = "";
		String frcPart = String.valueOf(nano % 1000000000);
		long intPart = nano - (nano % 1000000000);
		long hr = intPart / 3600000000000L;
		long min = (intPart % 3600000000000L ) / 60000000000L;
		long sec = (intPart % 3600000000000L ) % 60000000000L / 1000000000;
		hms = String.valueOf(nano) + "("
				+ String.valueOf(hr) + ":"
				+ String.valueOf(min) + ":"
				+ String.valueOf(sec) + "."
				+ frcPart + ")";
		return hms;
	}
}
