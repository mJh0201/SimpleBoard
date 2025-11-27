package board.Controller;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import board.DTO.BoardDTO;
import board.Service.BoardService;
import board.View.BoardView;

public class BoardController {
	static Scanner sc = new Scanner(System.in);
	static BoardService boardService = new BoardService();

	public static void main(String[] args) {
		List<BoardDTO> dtoList = new ArrayList<>();

		boolean isStop = false;

		while (!isStop) {
			dtoList = boardService.selectAll();
			BoardView.list(dtoList);
			BoardView.print("1.글쓰기 | 2.글보기 | 99.종료");
			BoardView.input("번호입력>>");
			int job = Integer.parseInt(sc.nextLine());

			switch (job) {
			case 1 -> {
				contentCreate();
			}
			case 2 -> { // 글보기
				BoardView.input("글번호입력(뒤로가기:0)>> ");
				int board_id = Integer.parseInt(sc.nextLine());

				exit:while (true) {
					BoardView.print(boardService.selectOne(board_id)); // 상세 글 조회
					System.out.println("1. 글 수정하기  |  2. 글 삭제하기  | 3. 뒤로가기");
					int select = Integer.parseInt(sc.nextLine());
					
					switch (select) {
						case 1 -> {
							// 글 수정
							System.out.println("제목 수정>> ");
							String title = sc.nextLine();
							System.out.println("내용 수정>> ");
							String content = sc.nextLine();
	
							System.out.println(boardService.update(board_id, title, content));
						} 
						case 2 -> {
							// TODO: 글 삭제 기능 필요
							BoardView.print(boardService.boardDelete(board_id));
							break exit;
						} 
						case 3 -> {break exit;}
						default -> {System.out.println("다시 입력하세요.");}
					}
				}
				
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
