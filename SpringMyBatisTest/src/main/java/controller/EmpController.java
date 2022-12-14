package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.Emp;
import service.EmpService;

@Controller
@RequestMapping("/emp/")
public class EmpController {
	private EmpService empservice;
	@Autowired
	public void setEmpservice(EmpService empservice) {
		this.empservice = empservice;
	}
	//목록
	@RequestMapping("list.do")
	public String getEmpList(Model model){
		List<Emp> list = empservice.getEmpList();
		model.addAttribute("list",list);
		
		return "emp/list";
	}
	//페이징 목록
	@RequestMapping("pagedlist.do")
	public String getPagedEmpList(@RequestParam(value="pg", defaultValue = "1") String pg,
            @RequestParam(value ="f", defaultValue = "TITLE") String f,
            @RequestParam(value="p", defaultValue="%%") String p,
            Model model) {
		
		List<Emp> list = empservice.getPagedEmpList(pg, f);
		model.addAttribute("list",list);
		
		return "emp/pagedlist";
	}
	//상세보기
	@RequestMapping("detail.do")
	public String getEmpListByEmpno(int empno, Model model){
		Emp emp = empservice.getEmpByEmpno(empno);
		model.addAttribute("emp",emp);
		return "emp/detail";
	}
	//추가 페이지
	@GetMapping("write.do")
	public String insertEmp(){
		return "emp/write";
	}
	//추가 처리
	@PostMapping("write.do")
	public String insertEmpOk(Emp emp){
		return empservice.insertEmp(emp);
	}
	//수정 페이지
	@GetMapping("edit.do")
	public String updateEmp(int empno, Model model){
		Emp emp = empservice.getEmpByEmpno(empno);
		model.addAttribute("emp",emp);
		return "emp/edit";
	}
	//수정 처리
	@PostMapping("edit.do")
	public String updateEmpOk(Emp emp){
		return empservice.updateEmp(emp);
	}
	//삭제 처리
	@RequestMapping("delete.do")
	public String deleteEmp(int empno){
		return empservice.deleteEmp(empno);
	}
}
