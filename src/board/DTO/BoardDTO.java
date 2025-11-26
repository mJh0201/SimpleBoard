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

/*
 *  BOARD_ID NUMBER NOT NULL,
    BOARD_TITLE VARCHAR2(50) NOT NULL,
    BOARD_CONTENTS VARCHAR2(100) NOT NULL,
    BOARD_DATE DATE DEFAULT SYSDATE NOT NULL,
    USER_NAME VARCHAR2(20)NOT NULL,
    USER_PW VARCHAR2(20) NOT NULL,
    
    CONSTRAINT PK_BOARD PRIMARY KEY(BOARD_ID),
    CONSTRAINT UK_USER_NAME UNIQUE(USER_NAME),
    CONSTRAINT UK_USER_PW UNIQUE(USER_PW)
    */ 
