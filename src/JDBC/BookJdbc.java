package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class BookJdbc{
public static void main(String[] args) {
	Connection con=null;
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","XE","sahamimi");
	System.out.println("Enter the choice 1.Insert 2.Update 3.Delete");
	Scanner s=new Scanner(System.in);
	int choice=s.nextInt();
	//do {
	switch(choice) {
	case 1:
		System.out.println("Enter Book Id");
		int bookid=s.nextInt();
		System.out.println("Enter Book name");
		String bname=s.next();
		System.out.println("Enter author name");
		String aname=s.next();
		System.out.println("Enter publisher name");
		String pname=s.next();
		System.out.println("Enter price ");
		int price=s.nextInt();
		String str="insert into book values('"+bookid+"','"+bname+"','"+aname+"','"+pname+"','"+price+"')";
		Statement st=con.createStatement();
		int i=st.executeUpdate(str);
		if(i!=0) {
			System.out.println("Inserted successfully");
			String str1="select * from book";
			Statement st1=con.createStatement();
			ResultSet rs=st1.executeQuery(str1);
			System.out.println("BookId\tBook name\tAuthor name\tPublisher name\tPrice");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2));
				System.out.print(rs.getString(3));
				System.out.print(rs.getString(4));
				System.out.print(rs.getInt(5));
				System.out.println();
			}
				
		}
	case 2:
		System.out.println("Enter Book Id");
		int bkid=s.nextInt();
		System.out.println("Enter Book name");
		String bnme=s.next();
		String str1="update book set bookName=? where bookId=?";
		PreparedStatement pst=con.prepareStatement(str1);
		pst.setString(1, bnme);
		pst.setInt(2, bkid);
		int i1=pst.executeUpdate();
		
		if(i1!=0) {
			System.out.println("Updated successfully");
			String str2="select * from book";
			Statement st1=con.createStatement();
			ResultSet rs=st1.executeQuery(str2);
			System.out.println("BookId\tBook name");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2));
				System.out.print(rs.getString(3));
				System.out.print(rs.getString(4));
				System.out.print(rs.getInt(5));
				System.out.println();
			}
				
		}
	case 3:
		con.setAutoCommit(false);
		System.out.println("Enter Book Id");
		int bid=s.nextInt();
		
		String str3="delete from book where bookId=?";
		PreparedStatement ps=con.prepareStatement(str3);
	
		ps.setInt(1, bid);
		ps.executeUpdate();

		System.out.println("Are you sure you want to delete (y/n)");
		String op=s.next();
		if(op.equalsIgnoreCase("y")) {
			con.commit();
			System.out.println("Deleted successfully");}
		else {
			con.rollback();
			
				System.out.println("Data restored");
			}
//		default:
//			System.out.println("Invalid choice");
	}


	}
	catch(ClassNotFoundException ce) {
		ce.printStackTrace();
	}catch(SQLException se)
	{
		se.printStackTrace();
	}
	finally {
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
}
