package in.co.rays.util;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class JdbcDataSource {
private static JdbcDataSource jds = null;
	
	private ComboPooledDataSource cpds = null;
	ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");
	private JdbcDataSource() {
		try {
			cpds = new ComboPooledDataSource();
			
			
			
			cpds.setDriverClass(rb.getString("Driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("username"));
			cpds.setPassword(rb.getString("password"));
			cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialpoolsize")));
			cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireincrement")));
			cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxpoolsize")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static JdbcDataSource getInstance() {
		
		if(jds == null) {
			jds = new JdbcDataSource();
		}
		return jds;
	}
	
	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		} catch (Exception e) {
		
		}
		return null;
		}
	
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null)rs.close();
			if(stmt != null)stmt.close();
			if(conn != null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(
			Connection conn, Statement stmt) {
		closeConnection(conn, stmt, null);
	}
	
	public static void closeConnection(Connection conn) {
		closeConnection(conn,null,null);
	}

}
