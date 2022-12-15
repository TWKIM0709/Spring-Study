package dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	public void setHiredate(String hiredate) {
		System.out.println("hiredate setter");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.hiredate = format.parse(hiredate);
		} catch (ParseException e) {
			e.printStackTrace();
			 this.hiredate = (hiredate != null) ? this.hiredate : null; 
		}
	}
//	public void setHiredate(Date hiredate) {
//		this.hiredate = hiredate;
//	}
}
//EMPNO    NOT NULL NUMBER       
//ENAME             VARCHAR2(10) 
//JOB               VARCHAR2(9)  
//MGR               NUMBER       
//HIREDATE          DATE         
//SAL               NUMBER       
//COMM              NUMBER       
//DEPTNO            NUMBER    