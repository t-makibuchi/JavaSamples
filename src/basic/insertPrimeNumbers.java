package basic;
import java.sql.*;
import java.util.Scanner;

public class insertPrimeNumbers {
	public static void main(String[] args){
		CommonUtil cUtil = new CommonUtil();
		BusinessUtil bUtil = new BusinessUtil();
		Scanner scanner = cUtil.getScanner();
	    String sString = cUtil.stInput(scanner, "Input a start number.");
	    String eString = cUtil.stInput(scanner, "Input a end number.");
	    scanner.close();

	    long sTime = System.nanoTime();

	    Integer sNumber = Integer.parseInt(sString);
	    Integer eNumber = Integer.parseInt(eString);
	    Integer updateCnt = 0;

		Connection conn = cUtil.getDbConnection();
		cUtil.executeUpdate(conn, "DELETE FROM prime_numbers");
		cUtil.executeUpdate(conn, "ALTER TABLE prime_numbers ALGORITHM= COPY, AUTO_INCREMENT = 1");
	    for(int i = sNumber; i < eNumber +1; i++) {
	    	if(bUtil.isPrime(i)) {
	    		StringBuffer sql = new StringBuffer();
	    		sql.append("INSERT INTO prime_numbers (prime_number) VALUES (");
	    		sql.append(i);
	    		sql.append(");");
	    		Integer rsltUpdateCnt = cUtil.executeUpdate(conn, sql.toString());
	    		updateCnt = updateCnt + rsltUpdateCnt;
	    	}
	    }
	    long eTime = System.nanoTime();
	    String exeTime = cUtil.getHMSfromNanotime(eTime - sTime);

	    System.out.println("Update Count: " + updateCnt);
	    System.out.println("Execution Time: " + exeTime);

	    cUtil.closeDbConnection(conn);
	}

}
