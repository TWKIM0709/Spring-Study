package kr.or.kosa.dao;

import java.util.List;

import kr.or.kosa.dto.Board;

public interface BoardDao {
	public List<Board> getBoardList();
	public int updateBoardList(Board board);
	public int insertBoard(Board board);
}
