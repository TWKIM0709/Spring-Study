package kosa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import kosa.vo.Employee;
import kosa.vo.TestVO;

@Controller
public class AjaxController {
	
	@Autowired
	private View jsonview;
	
	@PostMapping("json.kosa")
	 public View jsonkosa(String command , String name , String[] arr , ModelMap map) {
		System.out.println("command : " + command);
		System.out.println("name : " + name);
		System.out.println("arr : " + arr);
		System.out.println("Arrays.toString(arr) : " + Arrays.toString(arr));
		
		List<String> list = new ArrayList<String>();
		list.add("치킨");
		list.add("피자");
		list.add("햄버거");
		map.addAttribute("menu",list);
		 return jsonview;
	 }
	//<bean name="jsonview" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView" />
	//와 동일한 타입을 동일한 이름으로 return 하면
	//map.addAttribute("menu",list);를 자동으로 json형태로 변환해 비동기 전달한다.
	
	@PostMapping("json2.kosa")
	 public View jsonkosa2(String command , String name  , ModelMap map) {
		System.out.println("json2.kosa");

		List<TestVO> list = new ArrayList<TestVO>();
		
		TestVO vo =  new TestVO();
		vo.setBeer("라거");
		vo.setFood("하몽");
		list.add(vo);

		TestVO vo2 =  new TestVO();
		vo2.setBeer("카스");
		vo2.setFood("치킨");
		list.add(vo2);
		
		map.addAttribute("menu",list);
		/*
			{
				menu : [
					{bear : '라거', food : '하몽'},
					{bear : '카스', food : '치킨'},
				]
			}
		*/
		 return jsonview;
	 }
	@PostMapping("json3.kosa")
	 public View jsonkosa3( ModelMap map) {
		
		List<Employee> list = new ArrayList<Employee>();
		
		Employee emp1 = new Employee();
		emp1.setFirstname("김");
		emp1.setLastname("태우");
		emp1.setEmail("123@123.123");
		
		list.add(emp1);

		Employee emp2 = new Employee();
		emp2.setFirstname("김2");
		emp2.setLastname("태우2");
		emp2.setEmail("123@123.1232222");
		
		list.add(emp2);

		map.addAttribute("data", list);
		
		 return jsonview;
	 }
	@PostMapping("json4.kosa")
	 public View jsonkosa4(@RequestParam(value="aaa[]", required = false) String[] aaa,
			 								@RequestParam(value = "bbb",required = false) String bbb,
			 								String ccc,
			 								ModelMap map) {
		System.out.println("aaa : " + Arrays.toString(aaa));
		System.out.println("bbb : " + bbb);
		System.out.println("ccc : " + ccc);
		 return null;
	 }
}
