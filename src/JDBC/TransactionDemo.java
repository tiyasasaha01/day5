package JDBC;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;
	public class TransactionDemo {
			public static void main(String[] args) throws SQLException, ClassNotFoundException {

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "XE", "sahamimi");
				con.setAutoCommit(false);
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter Dept No to delete");
				int dno = scan.nextInt();
				String s = "delete from dept1 where dno=?";
				PreparedStatement pst = con.prepareStatement(s);
				pst.setInt(1, dno);
				int i = pst.executeUpdate();
				System.out.println("Are You Sure You Want To Delete?");
				String choice = scan.next();
				if(choice.equalsIgnoreCase("y")) {
					
					con.commit();
					System.out.println("Deleted Successfully");
				}
				else {
					con.rollback();
					System.out.println("Data Restored");
					
				}
		}
}
