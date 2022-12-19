package ncontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CustomerService;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	
	private CustomerService customerservice;

	@Autowired
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	@RequestMapping("notice.htm")   //   /customer/notice.htm
	public String notices(String pg , String f , String q , Model model) {
		List<Notice> list = customerservice.notices(pg, f, q);
		model.addAttribute("list", list);  //자동으로 notice.jsp forward 
		return "customer/notice";
	}
	

	@RequestMapping("noticeDetail.htm")
	public String noticesDetail(String seq  , Model model) {
		Notice notice = customerservice.noticesDetail(seq);
		model.addAttribute("notice", notice);
		return "customer/noticeDetail";
	}
	
	@GetMapping(value="noticeReg.htm")
	public String noticeReg() {
		return "customer/noticeReg";
	}
	@PostMapping(value="noticeReg.htm")
	public String noticeReg(Notice n , HttpServletRequest request) {
		String url = null;
		try {
			url = customerservice.noticeReg(n, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	
	@GetMapping(value="noticeEdit.htm")
	public String noticeEdit(String seq , Model model) {
		Notice notice=null;
		try {
		   notice =  customerservice.noticeEdit(seq);
		} catch( Exception e) {
				e.printStackTrace();
		} 
		
		model.addAttribute("notice", notice);
		return "customer/noticeEdit";
	}
	
	
	
	@PostMapping(value="noticeEdit.htm")
	public String noticeEdit(Notice n , HttpServletRequest request) {
		return customerservice.noticeEdit(n,request);
	}
	
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq){
		return customerservice.noticeDel(seq);
	}
	
	//파일 다운로드
		@RequestMapping("download.htm")
		public void download(String p , String f , HttpServletRequest request , HttpServletResponse response) throws IOException {
			  customerservice.download(p, f, request, response);
		}
	}
