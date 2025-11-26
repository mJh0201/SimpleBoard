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

		boolean isStop = false;

		while (!isStop) {
			BoardView.print("1.글쓰기 | 2.글보기 | 99.종료");
			BoardView.input("번호입력>>");
			int job = Integer.parseInt(sc.nextLine());

			switch (job) {
			case 1 -> {
			}
			case 2 -> { //글보기
				BoardView.input("글번호입력(뒤로가기:0)>> ");
				int board_id = Integer.parseInt(sc.nextLine());
				BoardView.print(service.selectOne(board_id));
			}
			case 99 -> {
				isStop = true;
			}
			default -> {
				BoardView.print("다시입력하세요.");
			}
			}
		}
	}

}
