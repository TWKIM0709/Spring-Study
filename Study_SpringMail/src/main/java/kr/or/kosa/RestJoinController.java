package kr.or.kosa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestJoinController {

	@PostMapping("/join")
	public ResponseEntity<String> sendMail(String email){
		
		//회원가입 했다고 치고...
		System.out.println(email);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
}
