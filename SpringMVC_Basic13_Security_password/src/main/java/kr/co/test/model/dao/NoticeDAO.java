package kr.co.test.model.dao;

import java.util.List;

import kr.co.test.model.dto.Notice;

public interface NoticeDAO {
	public List<Notice> getNoticeList(int page, String field, String query);
	
	public Notice getNotice(String seq);
	
	public int insertNotice(Notice notice);
	
	public int insertMemberPoint(String userid);
}
