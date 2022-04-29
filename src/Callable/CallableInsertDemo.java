package Callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableInsertDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "XE","sahamimi");
			Scanner s = new Scanner(System.in);
			System.out.println("enter dept no");
			int dno = s.nextInt();
			
			System.out.println("enter dept name");
			String name = s.next();
			
			String s1 = "{call insdept(?, ?)}";
			CallableStatement cst = conn.prepareCall(s1);
			cst.setInt(1, dno);
			cst.setString(2, name);
			cst.execute();
			System.out.println("INserted");
			
		}
		catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}

