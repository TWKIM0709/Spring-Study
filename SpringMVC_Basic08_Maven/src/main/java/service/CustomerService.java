package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

@Service
public class CustomerService {
	
	//MyBatis 작업
//	@Autowired
	private SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	// = = List = =
	public List<Notice> noticeList(String pg, String f,String p) {
		
		//DAO 작업
		List<Notice> list = null;
		try {
			NoticeDao noticedao =  sqlSession.getMapper(NoticeDao.class);
			list = noticedao.getNotices(Integer.parseInt(pg), f, p);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();}
		
		return list;
	}
	//Detail 상세보기
	public Notice noticeDetail(String seq) {

		Notice notice = null;
		try {
			NoticeDao noticedao =  sqlSession.getMapper(NoticeDao.class);
			notice = noticedao.getNotice(seq);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();	}
		
		return notice;
	}

	//글쓰기 처리 서비스
	public String noticeWriteOk(Notice notice, HttpServletRequest request) {
		
		List<CommonsMultipartFile> files = notice.getFiles();
		List<String> names = new ArrayList<String>();
		
		for(CommonsMultipartFile imagefile: files) {
			if(imagefile != null) {
				 String filename = imagefile.getOriginalFilename();
				 String path = request.getServletContext().getRealPath("/customer/upload"); //배포된 서버 경로
				String fpath = path + "\\" + filename; System.out.println(fpath);
				
				FileOutputStream fs =null; try { fs = new FileOutputStream(fpath);
				fs.write(imagefile.getBytes());
				
				} catch (Exception e) { // TODO Auto-generated catch block
				e.printStackTrace(); }finally { try { fs.close(); } catch (IOException e) {
				e.printStackTrace(); }
				} //File Upload
				names.add(filename);
			}
		}
		notice.setFileSrc(files.get(0).getOriginalFilename());
		notice.setFileSrc2(files.get(1).getOriginalFilename());
		// DataBase 처리
		int row = 0;
		try {
			NoticeDao noticedao =  sqlSession.getMapper(NoticeDao.class);
			row = noticedao.insert(notice);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
		// DataBase
		System.out.println(row);
		System.out.println("Notice : " + notice);
		return "redirect:notice.htm";
	}
	
	//수정 처리
	public Notice noticeEdit(String seq) {

		Notice notice = null;
		try {
			NoticeDao noticedao =  sqlSession.getMapper(NoticeDao.class);
			notice = noticedao.getNotice(seq);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();	}
		
		
		return notice;
	}
	
	//수정 처리
	public String noticeEditOk(Notice notice, HttpServletRequest request) {
		int row = 0;
		
		try {
			NoticeDao noticedao =  sqlSession.getMapper(NoticeDao.class);
			row = noticedao.update(notice);
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
		
		return "redirect:noticeDetail.htm";
	}
	
	//글 삭제하기 처리 서비스
	public String noticeDel(String seq) {
		
		try {
			NoticeDao noticedao =  sqlSession.getMapper(NoticeDao.class);
			noticedao.delete(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:notice.htm";
	}
	
	// 파일 다운로드 서비스 함수
	public void download(String p, String f, HttpServletRequest request, HttpServletResponse response)
		throws IOException {

			String fname = new String(f.getBytes("euc-kr"), "8859_1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fname + ";");

			String fullpath = request.getServletContext().getRealPath("/customer/" + p + "/" + f);
			System.out.println(fullpath);
			FileInputStream fin = new FileInputStream(fullpath);

			ServletOutputStream sout = response.getOutputStream();
			byte[] buf = new byte[1024]; // 전체를 다읽지 않고 1204byte씩 읽어서
			int size = 0;
			while ((size = fin.read(buf, 0, buf.length)) != -1) {
				sout.write(buf, 0, size);
			}
			fin.close();
			sout.close();
		}
}
