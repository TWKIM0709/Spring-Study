package kosa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kosa.vo.Emp;
import service.EmpService;

@RestController // 컨트롤러이고 가지고 있는 모든 함수는 비동기(@ResponseBody 처리)이다.
public class AjaxController {

	@Autowired
	private EmpService empservice;
	
	@RequestMapping("restcon.ajax")
	public List<Emp> ajaxResponseBody(){
		
		List<Emp> list = new ArrayList<Emp>();
		
		Emp emp1 = new Emp();
		emp1.setEmpno(9999);
		emp1.setEname("AAA");
		emp1.setJob("Programmer");
		emp1.setSal(1111);
		
		list.add(emp1);
		
		return list;
	}
	@RequestMapping("view.ajax")
	public String viewPage() {
		System.out.println("view.ajax");
		return "[view.ajax 문자열 반환값]";
	}
	
//	==========================================================================
//	 EMP 연습
//	emp 조회 p f ename
	@RequestMapping("ajaxEmpSearch.do")
	public List<Emp> getEmpListByLikeEname(@RequestParam(value="pg", defaultValue = "1") String pg,
				@RequestParam(value = "search", defaultValue = "") String search,
				@RequestParam(value = "ps",defaultValue = "5") String ps
			){
		List<Emp> list =  empservice.getPagedEmpListByLikeEname(pg, ps, search);
		return list;
	}
	@RequestMapping("ajaxEmpUpdate.do")
	public String updateEmp(Emp emp) {
		String result = empservice.updateEmp(emp);
		return result;
	}
	@RequestMapping("ajaxEmpInsert.do")
	public String insertEmp(Emp emp) {
		String result = empservice.insertEmp(emp);
		return result;
	}
	@RequestMapping("ajaxEmpDelete.do")
	public String deleteEmp(String empno) {
		String result = empservice.deleteEmp(Integer.valueOf(empno));
		return result;
	}
//	==========================================================================
}
