package in.co.rays.model;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.MarksheetBean;

public class MarksheetModel {
	 public  void add(MarksheetBean bean) throws Exception{
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection conn =   DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		  
		  PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		 
		  ps.setInt(1, bean.getId());
		  ps.setString(2, bean.getName());
		  ps.setInt(3, bean.getRollNo());
		  ps.setInt(4, bean.getPhysics());
		  ps.setInt(5, bean.getChemestry());
		  ps.setInt(6, bean.getMaths());
		  
		  int i = ps.executeUpdate();
		  
		  System.out.println("Data Inserted"+i);
		 
	 }
	  public void update(MarksheetBean bean) throws Exception{
		  
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection conn = DriverManager.getConnection("jdbc:mysql://local:3306/raystech","root","root");
		  
		  PreparedStatement ps = conn.prepareStatement("update marksheet set name =?,  id =?, chemestry=?,physics = ?,maths=?, where roll_no=?");
		  
		  ps.setString(1, bean.getName());
		  ps.setInt(2, bean.getId());
		  ps.setInt(3, bean.getChemestry());
		  ps.setInt(4, bean.getPhysics());
		  ps.setInt(5,bean.getMaths());
		  ps.setInt(6, bean.getMaths());
		  
		    int i = ps.executeUpdate();
		    
		    System.out.println("data insert = " +i );
	  }
	   public void delete(int i) throws Exception{
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
			   
			   PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");
			   
			   ps.setInt(1, bean.getId());
			   
			   int i = ps.executeUpdate(); 
			    
			   
			   System.out.println("Data deleted= " + i);
			   
	   } 
	   public MarksheetBean findbyId(int id) throws Exception{
		   
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		   
		   PreparedStatement ps = conn.prepareStatement("select * from marksheet where 1 = 1");
		   
		     ResultSet rs =ps.executeQuery();
		 
			return null;
		    
	   }

	   public List search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet");

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			MarksheetBean bean  = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemestry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);

			   
		}
		return list;
		}		   
}

