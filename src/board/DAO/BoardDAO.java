package board.DAO;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.DTO.BoardDTO;
import board.Util.DBUtil;

public class BoardDAO {
	public String update(int id, String title, String content) {
		StringBuffer input = new StringBuffer("update board set");
		List<String> list = new ArrayList<>();

		// 제목 수정
		if (title != null && !title.equals("")) {
			input.append(" board_title=?,");
			list.add(title);
		}

		// 내용 수정
		if (content != null && !content.equals("")) {
			input.append(" board_content=?,");
			list.add(content);
		}

		if (list.isEmpty()) {
			return "입력한 내용이 없습니다.";
		}

		input.deleteCharAt(input.length() - 1); // 마지막 쉼표 삭제
		input.append(" where board_id=?");

		try (Connection conn = DBUtil.dbConnect(); PreparedStatement st = conn.prepareStatement(input.toString())) {

			int idx = 1;
			for (String s : list) {
				st.setString(idx++, s);
			}
			st.setInt(idx, id);

			st.executeUpdate();
			return "수정되었습니다.";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "수정 실패했습니다.";
	}
}
