package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	//DAO
	private NoticeDao noticsdao;
	@Autowired
	public void setNoticsdao(NoticeDao noticsdao) {
		this.noticsdao = noticsdao;
	}
	
	// = = List = =
	@RequestMapping("notice.htm")
	public String noticeList(@RequestParam(value="pg", defaultValue = "1") String pg,
            @RequestParam(value ="f", defaultValue = "TITLE") String f,
            @RequestParam(value="p", defaultValue="%%") String p,
            Model model) {
		
		//DAO 작업
		List<Notice> list = null;
		try {
			list = noticsdao.getNotices(Integer.parseInt(pg), f, p);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();}
		
		//Spring  적용
		model.addAttribute("list",list);
		
		return "notice.jsp";
	}
	// = = Detail = = 
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq, Model model) {

		Notice notice = null;
		try {
			notice = noticsdao.getNotice(seq);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();	}
		
		model.addAttribute("notice", notice);
		
		return "noticeDetail.jsp";
	}
	// = = 글쓰기 = =
	@GetMapping("noticeReg.htm")
	public String noticeWrite() {
		return "noticeReg.jsp";
	}
	//글쓰기 처리
	@PostMapping("noticeReg.htm")
	public String noticeWriteOk(Notice notice, Model model,HttpServletRequest request) {
		//File Upload
		CommonsMultipartFile imagefile = notice.getFile();
		// 파일 업로드
		//실제 파일 업로드 구현 (upload 업로드)
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/customer/upload"); //배포된 서버 경로 
		String fpath = path + "\\" + filename;
		System.out.println(fpath);
		
		FileOutputStream fs =null;
		try {
			     fs = new FileOutputStream(fpath);
			     fs.write(imagefile.getBytes());
			     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//File Upload
		notice.setFileSrc(imagefile.getOriginalFilename());
		// DataBase 처리
		int row = 0;
		try {
			row = noticsdao.insert(notice);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
		// DataBase
		System.out.println(row);
		System.out.println("Notice : " + notice);
		return "redirect:notice.htm";
	}
	@GetMapping("noticeEdit.htm")
	public String noticeEdit(String seq, Model model) {

		Notice notice = null;
		try {
			notice = noticsdao.getNotice(seq);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();	}
		
		model.addAttribute("notice", notice);
		
		return "noticeEdit.jsp";
	}
	@PostMapping("noticeEdit.htm")
	public String noticeEditOk(Notice notice, Model model, HttpServletRequest request) {
		//File Upload
		CommonsMultipartFile imagefile = notice.getFile();
		// 파일 업로드
		//실제 파일 업로드 구현 (upload 업로드)
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/customer/upload"); //배포된 서버 경로 
		String fpath = path + "\\" + filename;
		System.out.println(fpath);
		
		FileOutputStream fs =null;
		try {
			     fs = new FileOutputStream(fpath);
			     fs.write(imagefile.getBytes());
			     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//File Upload
		notice.setFileSrc(imagefile.getOriginalFilename());
		int row = 0;
		
		try {
			row = noticsdao.update(notice);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
		System.out.println(row);
		System.out.println("Notice : " + notice);
		model.addAttribute("seq",notice.getSeq());
		return "redirect:noticeDetail.htm";
	}
	
}
