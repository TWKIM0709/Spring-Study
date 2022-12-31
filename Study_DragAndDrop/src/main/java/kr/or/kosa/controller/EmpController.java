package kr.or.kosa.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosa.dto.Emp;
import kr.or.kosa.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {
	@Autowired
	private EmpService empService;
	
//	@GetMapping("")
//	public List<Emp> empList(){
//		return empService.selectAllEmpList();
//	}
	//전체조회
	@GetMapping
	public ResponseEntity<List<Emp>> empList(){
		List<Emp> list = null;
		try {
			System.out.println("정상 실행");
			list = empService.selectAllEmpList();
			return new ResponseEntity<List<Emp>>(list,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("에러 실행");
			return new ResponseEntity<List<Emp>>(list,HttpStatus.BAD_REQUEST);
		}
	}
	//조건조회
	@GetMapping("{empno}")
	public Emp empListByEmpno(@PathVariable("empno") int empno) {
		System.out.println("asdf");
		return empService.selectEmpByEmpno(empno);
	}
	//삽입
	//(empno = 123 , ename = 아무개, sal = 10...) 서버로 전달 되면..
	@PostMapping
	public ResponseEntity<String> insert(Emp emp) {
		System.out.println("insert 실행");
		try {
			empService.insertEmp(emp);
			return new ResponseEntity<String>("insert success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("insert fail",HttpStatus.BAD_REQUEST);
		}
	}
	//수정
	@PutMapping
	public ResponseEntity<String> updateEmp(@RequestBody Emp emp) {
		System.out.println("update 실행" + emp);
		try {
			empService.updateEmp(emp);
			return new ResponseEntity<String>("update success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("update fail",HttpStatus.BAD_REQUEST);
		}
	}
	//삭제
	@DeleteMapping("{empno}")
	public ResponseEntity<String> deleteEmp(@PathVariable("empno") int empno) {
		System.out.println("delete 실행");
		try {
			empService.deleteEmp(empno);
			return new ResponseEntity<String>("delete success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("delete fail",HttpStatus.BAD_REQUEST);
		}
	}
}
