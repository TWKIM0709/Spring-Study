package kr.or.kosa.dao;

import java.util.List;

import kr.or.kosa.dto.Board;

public interface BoardDao {
	public List<Board> getBoardList();
	public int updateBoardList(List<Board> list);
}
