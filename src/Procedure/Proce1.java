package Procedure;
import java.sql.*;
import java.util.Scanner;
public class Proce1 {
	public static void main(String[] args) {
	Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","XE","sahamimi");
    String s="{call b(?)}";
    CallableStatement cst=conn.prepareCall(s);
    cst.registerOutParameter(1, java.sql.Types.VARCHAR2);
    cst.execute();
    System.out.println(cst.getString(1));
}
}
