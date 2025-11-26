package board.Service;

import java.util.List;

import board.DAO.BoardDAO;
import board.DTO.BoardDTO;

public class BoardService {

	BoardDAO boardDAO = new BoardDAO();

	// 모든 게시글 조회
	public List<BoardDTO> selectAll() {
		return boardDAO.selectAll();
	}

}
