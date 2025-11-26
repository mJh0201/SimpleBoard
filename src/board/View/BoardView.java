package board.View;

import java.util.List;

import board.DTO.BoardDTO;


public class BoardView {
	
	public static void print(String msg) {
		System.out.println(msg);
	}
	
	// 게시글 전체 조회
	public static void list(List<BoardDTO> dtoList) {
		for(BoardDTO data : dtoList) {
			System.out.printf("%3d. [작성자] %-8s  [제목] %-15s\n", data.getBoard_id(), data.getUser_name(), data.getBoard_title());
		}
	}
	
}
