package in.co.rays.collable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestProcedureIn {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		CallableStatement callStmt = conn.prepareCall("{CALL empIN(?)}");

		callStmt.setInt(1, 1);

		callStmt.execute();

		ResultSet rs = callStmt.getResultSet();

		while (rs.next()) {

			System.out.print(+rs.getInt(1));
			System.out.print(" "+rs.getString(2));
			System.out.println(" "+rs.getInt(3));

		}

	}

	

}
