package kosa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosa.vo.Emp;

@RestController // 컨트롤러이고 가지고 있는 모든 함수는 비동기(@ResponseBody 처리)이다.
public class AjaxController {
	
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
}
