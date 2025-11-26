package board.Controller;

import java.util.List;
import java.util.Scanner;

import board.DTO.BoardDTO;
import board.Service.BoardService;
import board.View.BoardView;

public class BoardController {

	static Scanner sc = new Scanner(System.in);
	static BoardService service = new BoardService();

	// main(게시글 전체 조회)
	public static void main(String[] args) {
		List<BoardDTO> dtoList = service.selectAll();

		BoardView.list(dtoList);
	}

}
