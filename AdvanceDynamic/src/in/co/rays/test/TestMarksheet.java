package in.co.rays.test;

import java.util.Iterator;

import java.util.List;


import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {
		
		 testAdd();
		// testUpdate();
		//testDelete();
		//testFindById();
		//testsearch();
		}
		

		private static void testsearch() throws Exception{
			
			MarksheetModel model= new MarksheetModel();
			
			List list = model.search();
					Iterator it = list.iterator();
			
			
			while (it.hasNext()) {
				
				MarksheetBean  bean = (MarksheetBean) it.next();
				
				System.out.print(bean.getId());
				System.out.print("\t"+bean.getName());
				System.out.print("\t"+bean.getRollNo());
				System.out.print("\t"+bean.getPhysics());
				System.out.print("\t"+bean.getChemestry());
				System.out.println("\t"+bean.getMaths());
				
			}
		
		
	}


		
		
		
	
	private static void testFindById()throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		MarksheetBean bean  = model.findbyId(2);
		
		if (bean !=null) {
			
			System.out.println(bean.getId());
			System.out.println("\t"+bean.getName());
			System.out.println("\t"+bean.getRollNo());
			System.out.println("\t"+bean.getChemestry());
			System.out.println("\t"+bean.getPhysics());
			System.out.println("\t"+bean.getMaths());
			
		}else {
			
		System.out.println("Id does not exist....!!!!");
		}				
	}				
	


	private static void testDelete() throws Exception{
		
		MarksheetModel model = new MarksheetModel();
		
		model.delete(1); 
		
							
	}


	private static void testUpdate() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		
		bean.setId(11);
		bean.setName("ram");
		bean.setRollNo(108);
		bean.setPhysics(77);
		bean.setChemestry(93);
		bean.setMaths(92);
		
		model.update(bean);
		
	}
		
			
	private static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		
		
		bean.setId(8);
		bean.setName("anjali");
		bean.setRollNo(108);
		bean.setPhysics(06);
		bean.setChemestry(45);
		bean.setMaths(06);
		
		model.add(bean);
		
		
	}

}
