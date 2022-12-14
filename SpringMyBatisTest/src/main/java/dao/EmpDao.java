package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {
	public List<Emp> getEmpList();
	public Emp getEmpByEmpno(int empno);
	public int insertEmp(Emp emp);
	public int updateEmp(Emp emp);
	public int deleteEmp(int empno);
	public List<Emp> getPagedEmpList(String pg, String f);
}
