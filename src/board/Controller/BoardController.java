package board.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import board.DAO.BoardDAO;
import board.DTO.BoardDTO;
import board.Service.BoardService;
import board.View.BoardView;

public class BoardController {
	static Scanner sc = new Scanner(System.in);
	static BoardService boardService = new BoardService();
	
	public static void main(String[] args) {
		BoardDTO boardDTO = new BoardDTO();
		
		contentCreate();
		BoardView.createBoardMenu(boardDTO);
	}
	
	private static BoardDTO contentCreate() {	
		BoardDTO boardDTO = new BoardDTO();
		
		BoardView.insertRequest("제목 : ");
		String title = sc.nextLine();
		BoardView.insertRequest("작성자 : ");
		String user_name = sc.nextLine();
		BoardView.insertRequest("내용 : ");
		String content = sc.nextLine();
		BoardView.insertRequest("비밀번호 : ");
		String user_pw = sc.nextLine();
		
		boardDTO.setBoard_title(title);
		boardDTO.setUser_name(user_name);
		boardDTO.setBoard_content(content);
		boardDTO.setUser_pw(user_pw);
		
		String message = boardService.boardCreate(boardDTO);
		System.out.println("[확인용] " + message);

		return boardDTO;
	}
	
}
