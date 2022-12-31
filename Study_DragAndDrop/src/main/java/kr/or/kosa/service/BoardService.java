package kr.or.kosa.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosa.dao.BoardDao;
import kr.or.kosa.dto.Board;

@Service
public class BoardService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Board> getBoardList(){
		List<Board> list = null;
		try {
			BoardDao dao = sqlSession.getMapper(BoardDao.class);
			list = dao.getBoardList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String updateBoardList(List<Board> list) {
		String result = null;
		for(Board board : list) {
			System.out.println(board);
		}
		try {
			BoardDao dao = sqlSession.getMapper(BoardDao.class);
			dao.updateBoardList(list);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		return result;
	}
}
