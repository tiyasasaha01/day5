package JDBC;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	public class MyOwnDemo {

		public static void main(String[] args) throws SQLException, ClassNotFoundException {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "", "");
			//System.out.println("Inserted Successfully");
			// String str1 = "Select * from dept1";
			// String str1 = "update dept1 set dname='Ishan' where dno=222";
			//String str1 = "update dept1 set dno=40 where dname='Ishan'";
			String str1 = "Select * from dept1";
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery(str1);
			System.out.println("Deptno\tDeptname\n");

			
			
			//for printing/selecting table
			
			while(rs.next()) {
				
				
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2));
				System.out.println("");
			}
			

		}

}
