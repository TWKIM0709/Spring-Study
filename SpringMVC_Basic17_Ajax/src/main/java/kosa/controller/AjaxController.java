package kosa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kosa.vo.Employee;

@Controller
public class AjaxController {
	@PostMapping("response.kosa")
	public @ResponseBody Employee add(String firstName , String lastName, String email) {
//	firstName=' + $("#firstName").val() + "&lastName=" + $("#lastName").val() + "&email=" + $("#email").val()
		Employee emp = new Employee();
		emp.setFirstname(firstName);
		emp.setLastname(lastName);
		emp.setEmail(email);
		System.out.println(emp);
		return emp;
	}
	
	//1. 클라이언트에서 전송된 데이터를 객체로 받기 	: @RequestBody
	//2. 서버에서 클라이언트로 객체 전송하기			: @ResponseBody
	@PostMapping("response2.kosa")
	public @ResponseBody Employee add(@RequestBody Employee emp) {
		System.out.println("response2.kosa");
		System.out.println(emp);
		
		return emp;
	}

	//Map 객체도 return 가능
	@PostMapping("response3.kosa")
	public @ResponseBody Map<String,Object> add(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("result", "data");
		map.put("hello","world");
		
		return map;
	}
}
