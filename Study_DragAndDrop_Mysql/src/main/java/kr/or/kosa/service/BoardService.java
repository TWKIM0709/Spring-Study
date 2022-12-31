package kr.or.kosa.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.kosa.dao.BoardDao;
import kr.or.kosa.dto.Board;

@Service
public class BoardService {
	
	@Autowired
	private SqlSession sqlSession;
	
	//Board List All Select
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
	//Board List Update
	@Transactional
	public String updateBoardList(List<Board> list) {
		String result = null;
		for(Board board : list) System.out.println(board);
		
		try {	// DAO
			BoardDao dao = sqlSession.getMapper(BoardDao.class);
			for(Board board : list) {
				System.out.printf("[Board 객체 처리 반복문 실행 중...]\nBoard : [%s]\n", board.toString());
				dao.updateBoardList(board);
			}
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
			throw e;
		}
		return result;
	}
}
