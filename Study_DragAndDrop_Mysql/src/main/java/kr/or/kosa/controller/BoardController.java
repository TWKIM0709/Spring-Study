package kr.or.kosa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosa.dto.Board;
import kr.or.kosa.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping
	public ResponseEntity<List<Board>> getBoardList(){
		System.out.println("================Controller start");
		List<Board> list = null;
		try {
			list = service.getBoardList();
			return new ResponseEntity<List<Board>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Board>>(list,HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping
	public ResponseEntity<String> updateBoardList(@RequestBody List<Board> list){
		String result = "fail";
		try {
			result = service.updateBoardList(list);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(result,HttpStatus.BAD_REQUEST);
		}
	}
	
}
