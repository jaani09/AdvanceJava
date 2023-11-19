package in.co.rays.test;

import java.text.SimpleDateFormat;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {
	public static void main(String[] args) throws Exception {

		 testAdd();
		//testUpdate();

	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = model.findById(4);

		bean.setFirstName("gopal");
		bean.setLastName("malviya");
		bean.setLoginId("gopal@gmail.com");
        bean.setDob(sdf.parse("2002-02-12"));
		model.update(bean);
	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		bean.setFirstName("Hritika");
		bean.setLastName("Sahu");
		bean.setLoginId("hritik@gmail.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("1998-09-01"));
		bean.setAddress("indore");

		UserModel model = new UserModel();
		model.add(bean);

	}
	private static void testAuthenticate() throws Exception {
		 UserModel model = new UserModel();
		UserBean bean =  model.authenticate("shubham@gmail.com", "5678");
		
		 
		 if(bean != null) {
			 System.out.print(bean.getId());
			 System.out.print(" "+bean.getFirstName());
			 System.out.print(" "+bean.getLastName());
			 System.out.print(" "+bean.getLoginId());
			 System.out.print(" "+bean.getPassword());
			 System.out.print(" "+bean.getDob());
			 System.out.println(" "+bean.getAddress());
		 }
		 else 
		 {
			 System.out.println("User does not exist....!!!!");
		 }
		 
	}


}
