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
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// = = List = =
	@RequestMapping("notice.htm")
	public String noticeList(@RequestParam(value="pg", defaultValue = "1") String pg,
            @RequestParam(value ="f", defaultValue = "TITLE") String f,
            @RequestParam(value="p", defaultValue="%%") String p,
            Model model) {
		
		List<Notice> list = customerservice.noticeList(pg, f, p);
		model.addAttribute("list",list);
		
		return "customer/notice";
	}
	
	// = = Detail = = 
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq, Model model) {

		Notice notice = customerservice.noticeDetail(seq);
		model.addAttribute("notice", notice);
		
		return "customer/noticeDetail";
	}
	
	// = = 글쓰기 = =
	@GetMapping("noticeReg.htm")
	public String noticeWrite() {
		return "customer/noticeReg";
	}
	
	//글쓰기 처리
	@PostMapping("noticeReg.htm")
	public String noticeWriteOk(Notice notice, Model model,HttpServletRequest request) {
		String url = "redirect:notice.htm";
		try {
			url = customerservice.noticeWriteOk(notice, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	
	//수정페이지이동
	@GetMapping("noticeEdit.htm")
	public String noticeEdit(String seq, Model model) {

		Notice notice = null;
		try {
			notice = customerservice.noticeEdit(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
		model.addAttribute("notice", notice);
		
		return "customer/noticeEdit";
	}
	
	
	@PostMapping("noticeEdit.htm")
	public String noticeEditOk(Notice notice, Model model, HttpServletRequest request) {
		String url = null;
		try {
			url = customerservice.noticeEditOk(notice, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("seq",notice.getSeq());
		return "redirect:noticeDetail.htm";
	}
	
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) {
		return customerservice.noticeDel(seq);
	}
	//파일 다운로드
	@RequestMapping("download.htm")
	public void download(String p , String f , HttpServletRequest request , HttpServletResponse response) throws IOException {
		  customerservice.download(p, f, request, response);
	}
}
