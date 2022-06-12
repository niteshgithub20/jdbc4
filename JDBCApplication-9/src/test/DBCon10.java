package test;
import java.sql.*;
import java.util.*;
public class DBCon10 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the Acno");
			long accNo = Long.parseLong(s.nextLine());
			System.out.println("Enter the CustName");
			String custName = s.nextLine();
			System.out.println("Enter the Balance");
			float bal = Float.parseFloat(s.nextLine());
			System.out.println("Enter the AccType");
			String accType = s.nextLine();
			System.out.println("Enter the Address");
			String addr = s.nextLine();
			System.out.println("Enter the MailId");
			String mId = s.nextLine();
			System.out.println("Enter the PhnoeNo");
			Long phNo = Long.parseLong(s.nextLine());
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","student");
			
			CallableStatement cs = con.prepareCall("{call CreateAccount43(?,?,?,?,?,?,?)}");
			cs.setLong(1, accNo);
			cs.setString(2, custName);
			cs.setFloat(3, bal);
			cs.setString(4, accType);
			cs.setString(5, addr);
			cs.setString(6, mId);
			cs.setLong(7, phNo);
			
			cs.execute();
			
			System.out.println("Procedure Executed Successfully......");
			con.close();			
			s.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
