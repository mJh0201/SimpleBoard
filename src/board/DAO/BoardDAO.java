package board.DAO;

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
