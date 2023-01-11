package kr.or.kosa;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

	@Autowired
	private JavaMailSender mailSender;
	
	@PostMapping("/sendMail")
	public ResponseEntity<String> sendMail(String fromEmail, String toEmail){
		
		System.out.println("From : "+fromEmail);
		System.out.println("To : "+ toEmail);
		
		Random random = new Random();
		int code = random.nextInt(888888) + 111111;
		
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 <" + code + "> 입니다." + "<br>"
				+ "홈페이지로 돌아가서 해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		
//		MimeMessage message = mailSender.createMimeMessage();
		
		try {
//			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
//			
//			helper.setFrom("보내는사람 이메일");
//			helper.setTo("받는 사람 이메일");
//			helper.setSubject("MailSendTest");
//			helper.setText(content,true);
			
//			mailSender.send(message);
			
			EmailCodeMap.addMap(toEmail, code);

			EmailCodeMap.printTest();
			
			return new ResponseEntity<String>("success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
		}
	} //sendMail Function end 
	
	@PostMapping("/codeCheck")
	public ResponseEntity<String> codeCheck(String email, String code){
		String result = EmailCodeMap.checkCode(email, Integer.parseInt(code)) ? "success" : "fail";
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}