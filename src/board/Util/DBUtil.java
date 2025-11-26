package board.Util;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DBUtil {
	//DB연결
	public static Connection dbConnect() {
		Connection conn = null;
		Properties pro = new Properties();
		String path = "oracleDB.properties";
		InputStream is = DBUtil.class.getResourceAsStream(path);
		try {
			pro.load(is);
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String id = pro.getProperty("username");
			String pass = pro.getProperty("password");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//DB해제
	public static void dbDisconnect(Connection conn, Statement st, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
