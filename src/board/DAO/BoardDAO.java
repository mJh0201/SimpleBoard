package board.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

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

}
