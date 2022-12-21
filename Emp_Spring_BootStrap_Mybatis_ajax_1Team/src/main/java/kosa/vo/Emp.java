package kosa.vo;

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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.hiredate = format.parse(hiredate);
		} catch (Exception e) {
			e.printStackTrace();
			 this.hiredate = (hiredate != null) ? this.hiredate : null; 
		}
	}
	public String getHiredateString() {
		return hiredate.toString();
	}
}