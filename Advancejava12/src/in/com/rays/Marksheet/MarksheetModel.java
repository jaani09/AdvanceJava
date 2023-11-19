package in.com.rays.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.com.rays.jdbc.JDBCDataSource;

public class MarksheetModel {
	
	public void add(MarksheetBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		
		   ps.setInt(1, bean.getId());
		   ps.setString(2, bean.getName());
		   ps.setInt(3, bean.getRollNo());
		   ps.setInt(4, bean.getMaths());
		   ps.setInt(5, bean.getChemestry());
		   ps.setInt(6, bean.getMaths());
		   
		   int i = ps.executeUpdate();
		   
		   System.out.println("Data insert" + i);
	}
	
	
		   
		   
		   public void update(MarksheetBean bean)throws Exception{
			   Connection conn = JDBCDataSource.getConnection();

			   
			 PreparedStatement ps =  conn.prepareStatement("update marksheet set name = ?,id = ?, chemistry = ?, physics = ?, maths = ? where roll_no = ? "); 
		   
		   
		   ps.setString(1,bean.getName());
		   ps.setInt(2,bean.getId());
		   ps.setInt(3,bean.getChemestry());
		   ps.setInt(4,bean.getPhysics() );
		   ps.setInt(5,bean.getMaths() );
		   ps.setInt(6,bean.getRollNo() );
		   
		   int i  = ps.executeUpdate();
		   
		   System.out.println("data updates " + i);
		
	}
		   
		   public void delete(int id) throws Exception{
			   Connection conn = JDBCDataSource.getConnection();

					   
					 PreparedStatement ps =  conn.prepareStatement("delete from marksheet where id = ?"); 
					 ps.setInt(1,id);
					 
					 int i = ps.executeUpdate();
					 
					 conn.close();
					 
					 System.out.println("data deleted = " + i);
				   
			   
			   			   
		   }




		public MarksheetBean FindById(int id) throws Exception {
			Connection conn = JDBCDataSource.getConnection();

			
			
			PreparedStatement ps = conn.prepareStatement("select*from marksheet where id = ?");
			
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			MarksheetBean bean = null ;
			
			while(rs.next()) {
				
				bean = new MarksheetBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setRollNo(rs.getInt(3));
				bean.setPhysics(rs.getInt(4));
				bean.setChemestry(rs.getInt(5));
				bean.setMaths(rs.getInt(6));
				
			
			}
			conn.close();
			
			return bean;
		}
		public List search(MarksheetBean bean, int pageNo, int pageSize) throws Exception {
			Connection conn = JDBCDataSource.getConnection();


			StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

			if (bean != null) {

				if (bean.getName() != null && bean.getName().length() > 0) {
					sql.append(" and name like '" + bean.getName() + "%'");
				}

				if (bean.getRollNo() > 0) {
					sql.append(" and roll_no = " + bean.getRollNo());
				}
			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;

				sql.append(" limit " + pageNo + ", " + pageSize);

			}

			System.out.println("SQL = " + sql);

			PreparedStatement ps = conn.prepareStatement(sql.toString());

			ResultSet rs = ps.executeQuery();

			List list = new ArrayList();

			while (rs.next()) {
				bean = new MarksheetBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setRollNo(rs.getInt(3));
				bean.setPhysics(rs.getInt(4));
				bean.setChemestry(rs.getInt(5));
				bean.setMaths(rs.getInt(6));

				list.add(bean);
			}
			conn.close();
			return list;
		   
		   
		   
		   
		   
		   
		   
		}
			   
			   
}

