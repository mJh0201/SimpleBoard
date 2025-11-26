package board.View;

import board.DTO.BoardDTO;

public class BoardView {
	
	// 게시글 생성 UI
	public static void createBoardMenu(BoardDTO boardDTO){
		System.out.println("-----------------------------------------------------------");
	    System.out.printf("게시글 제목: %s\n", boardDTO.getBoard_title());
	    System.out.printf("작성자: %s\n",boardDTO.getUser_name());
	    System.out.printf("게시글 내용 : %s\n", boardDTO.getBoard_content());    
		System.out.println("-----------------------------------------------------------");
		
	}

	public static void insertRequest(String message) {
		System.out.print(message);
	}
	
}
