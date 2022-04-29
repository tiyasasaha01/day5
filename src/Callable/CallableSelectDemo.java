package Callable;

import java.sql.*;
import java.util.Scanner;

public class CallableSelectDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "LTI","root");
			Scanner s = new Scanner(System.in);
			System.out.println("enter dept no");
			int dno = s.nextInt();
			
			String s1 = "{call seldept(?, ?, ?)}";
			CallableStatement cst = con.prepareCall(s1);
			cst.setInt(1, dno);
			cst.registerOutParameter(2, java.sql.Types.INTEGER);
			cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			cst.execute();
			System.out.println(cst.getInt(2));
			System.out.println(cst.getString(3));
			
		}
		catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}