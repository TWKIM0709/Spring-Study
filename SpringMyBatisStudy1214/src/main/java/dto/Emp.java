package dto;

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
}
//EMPNO    NOT NULL NUMBER       
//ENAME             VARCHAR2(10) 
//JOB               VARCHAR2(9)  
//MGR               NUMBER       
//HIREDATE          DATE         
//SAL               NUMBER       
//COMM              NUMBER       
//DEPTNO            NUMBER    