package kr.or.kosa.dao;

import java.util.List;

import kr.or.kosa.dto.Emp;

public interface EmpDao {
	//CRUD
	int insert(Emp emp);
	List<Emp> select();
	Emp selectByEmpno(int empno);
	int update(Emp emp);
	int delete(int empno);
}
