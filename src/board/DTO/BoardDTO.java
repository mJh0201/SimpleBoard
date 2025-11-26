package board.DTO;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter@ToString
public class BoardDTO {

	private Integer board_id;
	private String board_title;
	private String board_content;
	private Date board_date;
	private String user_name;
	private String user_pw;
	
}


