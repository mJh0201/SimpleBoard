package board.Service;

import java.util.List;

import board.DAO.BoardDAO;
import board.DTO.BoardDTO;

public class BoardService {

	BoardDAO boardDAO = new BoardDAO();

	// 게시글 생성
	public String boardCreate(BoardDTO boardDTO) {
		return boardDAO.boardCreate(boardDTO);
	}

	// 모든 게시글 조회
	public List<BoardDTO> selectAll() {
		return boardDAO.selectAll();
	}

	// 상세 게시글 조회
	public BoardDTO selectOne(int board_id) {
		return boardDAO.selectOne(board_id);
	}

}
