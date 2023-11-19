package in.com.curd;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestAdd1 {

	public static void main(String[] args) throws Exception {

		// add(9, "shubham", 3000);
		testSelect();

	}

	private static void testSelect() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/sunrays", "root", "root");

		Statement stmt = (Statement) conn.createStatement();

		ResultSet rs = ((java.sql.Statement) stmt).executeQuery("select * from emp");

		while (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getInt(3));

		}

	}

//	private static void add(int id, String name, int salary) throws Exception {
//
//		Class.forName("com.mysql.cj.jdbc.Driver");
//
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/sunrays", "root", "root");
//
//		Statement stmt = (Statement) conn.createStatement();
//
//		int i = ((java.sql.Statement) stmt).executeUpdate("insert into emp values(" + id + ", '" + name + "', " + salary + ")");
//
//		System.out.println("Data inserted " + i);

//	}

}


