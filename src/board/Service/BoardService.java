package board.Service;

import board.DAO.BoardDAO;

public class BoardService {
	BoardDAO boardDAO = new BoardDAO();
	
	public String update(int id, String name, String pw) {
		return boardDAO.update(id, name, pw);
		
	}
}
