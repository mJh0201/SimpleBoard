package board.View;

import board.DTO.BoardDTO;
	
import java.util.List;


public class BoardView {
  	
	public static void print(String msg) {
		System.out.println(msg);
	}
	
	public static void input(String msg) {
		System.out.print(msg);
	}
	
	// 게시글 전체 조회
	public static void list(List<BoardDTO> dtoList) {
		for(BoardDTO data : dtoList) {
			System.out.printf("%3d. [작성자] %-8s  [제목] %-15s\n", data.getBoard_id(), data.getUser_name(), data.getBoard_title());
		}
	}
	
	// 게시글 상세조회
	public static void print(BoardDTO dto) {
		System.out.printf("[제목] %-10s\t[작성자] %-7s\t[작성일] %s\n",dto.getBoard_title(),dto.getUser_name(),dto.getBoard_date());
		System.out.printf("[내용] %s\n",dto.getBoard_content());
	}
	
}
