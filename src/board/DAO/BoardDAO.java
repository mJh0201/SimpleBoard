package board.DAO;

import java.sql.CallableStatement;
import java.sql.Types;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.DTO.BoardDTO;
import board.Util.DBUtil;

public class BoardDAO {

	public String boardCreate(BoardDTO boardDTO) {
		String message = null;
		Connection conn = null;
		CallableStatement st = null;

		String sql = """
				BEGIN
				INSERT INTO BOARD(BOARD_ID, BOARD_TITLE, BOARD_CONTENT, USER_NAME, USER_PW)
				VALUES (SEQ_BOARD_ID.NEXTVAL, ?, ?, ?, ?)
				RETURNING BOARD_ID INTO ?;
				END;
				""";

		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareCall(sql);
			// in 파라미터
			st.setString(1, boardDTO.getBoard_title());
			st.setString(2, boardDTO.getBoard_content());
			st.setString(3, boardDTO.getUser_name());
			st.setString(4, boardDTO.getUser_pw());
			// out 파라미터
			st.registerOutParameter(5, Types.INTEGER);
			// SQL 실행
			int result = st.executeUpdate();
			// out 파라미터 읽어오기
			int generated_id = st.getInt(5);
			boardDTO.setBoard_id(generated_id);
			// message 출력
			message = result + "건의 게시글이 작성되었습니다.";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}

		return message;
	}

	// 모든 게시글 조회
	public List<BoardDTO> selectAll() {
		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		String sql = "select * from board";

		try {
			conn = DBUtil.dbConnect();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				BoardDTO dto = BoardDTO.builder().board_id(rs.getInt("BOARD_ID"))
						.board_title(rs.getString("BOARD_TITLE")).board_content(rs.getString("BOARD_CONTENT"))
						.board_date(rs.getDate("BOARD_DATE")).user_name(rs.getString("USER_NAME"))
						.user_pw(rs.getString("USER_PW")).build();
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dtoList;
	}

	// 상세조회
	public BoardDTO selectOne(int board_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		BoardDTO dto = null;

		String sql = "select * from board where board_id = ?";

		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setInt(1, board_id);

			rs = st.executeQuery();

			while (rs.next()) {
				dto = BoardDTO.builder().board_id(rs.getInt("BOARD_ID")).board_title(rs.getString("BOARD_TITLE"))
						.board_content(rs.getString("BOARD_CONTENT")).board_date(rs.getDate("BOARD_DATE"))
						.user_name(rs.getString("USER_NAME")).user_pw(rs.getString("USER_PW")).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}
}
