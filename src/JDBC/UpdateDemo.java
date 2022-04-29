package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter department Info :");
		System.out.println("Department no :");
		int dno=sc.nextInt();
		System.out.println("Department name :");
		String dname=sc.next();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","XE","sahamimi");
        String str="update dept set dname=? where deptno=?";
        PreparedStatement pst= con.prepareStatement(str);
        pst.setString(1, dname);
        pst.setInt(2, dno);
        
        int i=pst.executeUpdate();
        if(i!=0) {
        	System.out.println("Insertion Successful");
        	String str1="select * from dept";
        	Statement st1=con.createStatement();
        	ResultSet rs=st1.executeQuery(str1);
        	System.out.println("Dno\tDname\t\tloc");
        	while(rs.next()) {
        		System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3));
        		System.out.println("");
        	}
        	
  
        }
	}
}