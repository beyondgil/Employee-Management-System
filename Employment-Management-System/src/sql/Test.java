package sql;

import java.util.List;

import datastructure.*;

import java.io.File;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class Test {

	public static void main(String[] args) {
        String title[]={"Id","Name","Salary","Phone","Email"};
        String title2[]={"Dep_id","Name"};
		EmployeeService service = new EmployeeService();

		 List<Employee> list1 = service.getEmployeeByDepartment(31111);
		 WritableWorkbook book;
		 WritableSheet sheet;
		 int col=0;
		 try{File file = new File("t.xls");
			 if(!file.exists()){
		            book= Workbook.createWorkbook(new File("t.xls")); 
		             sheet=book.createSheet("Report",0); 
			 }else{
				 Workbook wb = Workbook.getWorkbook( new File( "t.xls" ));
				 book = Workbook.createWorkbook( new File( "t.xls" ),
				wb);
				
				sheet = book.createSheet( "Report" , 0 );
			 }
		sheet.mergeCells(0, 0, 4, 0);
		sheet.addCell(new Label(0,col,"List of people from Marketing:"));
		col++;
		for(int i=0;i<title.length;i++){
			sheet.addCell(new Label(i,col,title[i]));
		}
		col++;
		 for (int i=0;i<list1.size();i++) {
			 sheet.addCell(new Label(0,i+col,list1.get(i).getEmp_id()+""));
			 sheet.addCell(new Label(1,i+col,list1.get(i).getName()+""));
			 sheet.addCell(new Label(2,i+col,list1.get(i).getSalary()+""));
			 sheet.addCell(new Label(3,i+col,list1.get(i).getPhone()+""));
			 sheet.addCell(new Label(4,i+col,list1.get(i).getEmail()+""));
			 
 		 }
		 col=col+list1.size();
		 sheet.mergeCells(0, col, 4, col);
			sheet.addCell(new Label(0,col,"People who get Same Salary:"));
			col++;
			for(int i=0;i<title.length;i++){
				sheet.addCell(new Label(i,col,title[i]));
			}
			col++;
		 List<Employee> list3 = service.getSameSalaryEmployee();
		 for (int i=0;i<list3.size();i++) {
			 sheet.addCell(new Label(0,i+col,list3.get(i).getEmp_id()+""));
			 sheet.addCell(new Label(1,i+col,list3.get(i).getName()+""));
			 sheet.addCell(new Label(2,i+col,list3.get(i).getSalary()+""));
			 sheet.addCell(new Label(3,i+col,list3.get(i).getPhone()+""));
			 sheet.addCell(new Label(4,i+col,list3.get(i).getEmail()+""));
			 
 		 }
		 col=col+list3.size();
		 sheet.mergeCells(0, col, 4, col);
			sheet.addCell(new Label(0,col,"The Minimum Department:"));
			col++;
			for(int i=0;i<title2.length;i++){
				sheet.addCell(new Label(i,col,title2[i]));
			}
			col++;
			Department minDepartment = service.getMinimumDepartment();
			sheet.addCell(new Label(0,col,minDepartment.getDep_id()+""));
			 sheet.addCell(new Label(1,col,minDepartment.getDep_name()+""));
		  book.write(); 
          book.close(); 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
 		
 		

 		
	}

}
