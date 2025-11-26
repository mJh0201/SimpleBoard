package board.Controller;

import java.util.Scanner;
import java.util.List;
import board.DTO.BoardDTO;
import board.Service.BoardService;
import board.View.BoardView;

public class BoardController {
	static Scanner sc = new Scanner(System.in);
	static BoardService boardService = new BoardService();

	public static void main(String[] args) {
		List<BoardDTO> dtoList = boardService.selectAll();

		BoardView.list(dtoList);

		boolean isStop = false;

		while (!isStop) {
			BoardView.print("1.글쓰기 | 2.글보기 | 99.종료");
			BoardView.input("번호입력>>");
			int job = Integer.parseInt(sc.nextLine());

			switch (job) {
			case 1 -> {
				BoardDTO dto = contentCreate();
				
				if(dto != null) {
					BoardView.list(boardService.selectAll());
				}
			}
			case 2 -> { // 글보기
				BoardView.input("글번호입력(뒤로가기:0)>> ");
				int board_id = Integer.parseInt(sc.nextLine());
				BoardView.print(boardService.selectOne(board_id));
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

	private static BoardDTO contentCreate() {
		BoardDTO boardDTO = new BoardDTO();

		BoardView.input("제목 : ");
		String title = sc.nextLine();
		BoardView.input("작성자 : ");
		String user_name = sc.nextLine();
		BoardView.input("내용 : ");
		String content = sc.nextLine();
		BoardView.input("비밀번호 : ");
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
