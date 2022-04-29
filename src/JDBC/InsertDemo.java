package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter department Info :");
		System.out.println("Department no :");
		int dno=sc.nextInt();
		System.out.println("Department name :");
		String dname=sc.next();
		System.out.println("Location :");
	    String loc=sc.next();
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","XE","sahamimi");
        String str="insert into dept values('"+dno+"','"+dname+"','"+loc+"')";
        Statement st=con.createStatement();
        int i=st.executeUpdate(str);
        if(i!=0) {
        	System.out.println("Insertion Successful");
        	String str1="select * from dept";
        	Statement st1=con.createStatement();
        	ResultSet rs=st1.executeQuery(str1);
        	System.out.println("Dno\tDname\t\t\tloc");
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3));
        		
        	}
        	System.out.println("");
        }
	}
}