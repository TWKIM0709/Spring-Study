package kr.or.kosa.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.Emp;

@Service
public class EmpService {
	@Autowired
	private SqlSession sqlSession;
	
	//select * from emp;
	public List<Emp> selectAllEmpList(){
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		return dao.select();
	}
	//select * from emp where empno = empno
	public Emp selectEmpByEmpno(int empno) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		return dao.selectByEmpno(empno);
	}
	//insert into emp(...) values(...)
	public int insertEmp(Emp emp) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		return dao.insert(emp);
	}
	//update emp set ename=? , sal=? where empno=?
	public int updateEmp(Emp emp) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		return dao.update(emp);
	}
	//delete from emp where empno=?
	public int deleteEmp(int empno) {
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		return dao.delete(empno);
	}
}
