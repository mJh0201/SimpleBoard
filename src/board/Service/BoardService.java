package board.Service;

import java.util.List;
import java.util.Collections;
import board.DAO.BoardDAO;
import board.DTO.BoardDTO;

public class BoardService {

	BoardDAO boardDAO = new BoardDAO();
	final int pageSize = 5;
	int page = 0;

	// 게시글 생성
	public String boardCreate(BoardDTO boardDTO) {
		return boardDAO.boardCreate(boardDTO);
	}

	// 다음 페이지
	// input = 사용자 입력
	private int nextPage(String job) {

		if (job.equals("p") || job.equals("P")) {
			// 다음장
			page++;

		} else if (job.equals("q") || job.equals("Q")) {
			// 이전장
			page--;
		}
		return page;
	}

	// 모든 게시글 조회
	public List<BoardDTO> selectAll() {

		int first = 0;
		List<BoardDTO> bookList = boardDAO.selectAll();
		int end = Math.min(first + pageSize, bookList.size());
		if (first > bookList.size()) {
			return Collections.emptyList();
		} else {
			return bookList.subList(first, end);
		}
	}

	public List<BoardDTO> selectAll(String job) {
		// 페이징
		int first = (nextPage(job)) * pageSize;

		if (first < 0) {
			System.out.println("이미 첫 페이지입니다.");
			first = 0;
		}

		List<BoardDTO> bookList = boardDAO.selectAll();
		int end = Math.min(first + pageSize, bookList.size());

		if (first > bookList.size()) {
			System.out.println("마지막 페이지입니다.");
			first = (bookList.size() / pageSize) * pageSize;
			System.out.println();
			return bookList.subList(first, end);
		} else {
			return bookList.subList(first, end);
		}
	}

	// 상세 게시글 조회
	public BoardDTO selectOne(int board_id) {
		return boardDAO.selectOne(board_id);
	}

	// 게시글 수정
	public String update(int id, String name, String pw) {
		return boardDAO.update(id, name, pw);
	}

	// 게시글 삭제
	public String boardDelete(int boardId) {
		return boardDAO.boardDelete(boardId);
	}

}
