package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmpDao;
import dto.Emp;

@Service
public class EmpService {
	private SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	//전체 조회
	public List<Emp> getEmpList() {
		List<Emp> list = null;
		try {
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			list = dao.getEmpList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//페이징 전체 조회
	public List<Emp> getPagedEmpList(String pg, String f) {
		List<Emp> list = null;
		try {
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			list = dao.getPagedEmpList(Integer.parseInt(pg), Integer.parseInt(f));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//상세보기
	public Emp getEmpByEmpno(int empno){
		Emp emp = null;
		try {
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			emp = dao.getEmpByEmpno(empno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	//추가
	public String insertEmp(Emp emp) {
		try {
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			dao.insertEmp(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list.do";
	}
	//수정
	public String updateEmp(Emp emp) {
		System.out.println("[input Emp] >>" + emp);
		try {
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			dao.updateEmp(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:detail.do?empno=" + emp.getEmpno();
	}
	//삭제
	public String deleteEmp(int empno) {
		try {
			EmpDao dao = sqlSession.getMapper(EmpDao.class);
			dao.deleteEmp(empno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list.do";
	}
}