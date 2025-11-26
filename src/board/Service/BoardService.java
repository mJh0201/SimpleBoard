package board.Service;

import board.DAO.BoardDAO;
import board.DTO.BoardDTO;

public class BoardService {
	
	BoardDAO boardDAO = new BoardDAO();
	
	// 게시글 생성
	public String boardCreate(BoardDTO boardDTO) {
		return boardDAO.boardCreate(boardDTO);
	}

}
