package kr.co.test.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.co.test.model.dao.NoticeDAO;
import kr.co.test.model.dto.Notice;

@Service
public class NoticeService {
	
	@Autowired
	private SqlSession sqlsession;
	
	
	public List<Notice> getNoticeList(int page, String field, String query){
		NoticeDAO dao = sqlsession.getMapper(NoticeDAO.class);
		List<Notice> list = dao.getNoticeList(page, field, query);
		return list;
	}
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	public Notice getNotice(String seq){
		NoticeDAO dao = sqlsession.getMapper(NoticeDAO.class);
		Notice notice = dao.getNotice(seq);
		return notice;
	}
	
	@Transactional(rollbackFor={Exception.class})
	public String noticeReg(Notice n, HttpServletRequest request)
			throws IOException, ClassNotFoundException, SQLException {
		
		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<String>(); // 파일명만 추출

		if (files != null && files.size() > 0) { // 업로드한 파일이 하나라도 있다면

			for (CommonsMultipartFile multipartfile : files) {

				String fname = multipartfile.getOriginalFilename(); // 파일명 얻기
				String path = request.getServletContext().getRealPath("/customer/upload");
				String fullpath = path + "\\" + fname;

				System.out.println(fname + " / " + path + " / " + fullpath);

				if (!fname.equals("")) {
					// 서버에 파일 쓰기 작업
					FileOutputStream fs = new FileOutputStream(fullpath);
					fs.write(multipartfile.getBytes());
					fs.close();
				}
				filenames.add(fname); // 실 DB Insert 작업시 .. 파일명
			}

		}

		n.setFileSrc(filenames.get(0)); // 파일명 1
		n.setFileSrc2(filenames.get(1)); // 파일명 2
		
		NoticeDAO noticeDao = sqlsession.getMapper(NoticeDAO.class);
		
		try {
			noticeDao.insertNotice(n);
			noticeDao.insertMemberPoint(n.getWriter());
			System.out.println("insertOfMemberPoint");
		} catch (Exception e) {
			System.out.println("예외 함수 타는가?");
			e.printStackTrace();
			throw new SQLException();
		}
		return "redirect:noticeview.htm";
	}
}
