package dao;

import java.util.List;

import kosa.vo.Emp;

public interface EmpDao {
	public List<Emp> getEmpList();
	public Emp getEmpByEmpno(int empno);
	public int insertEmp(Emp emp);
	public int updateEmp(Emp emp);
	public int deleteEmp(int empno);
	public List<Emp> getPagedEmpList(int pg, int f);
	public List<Emp> getPagedLikeEmpListByEname(int pg, int f,String ename);
}
