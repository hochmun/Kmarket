package kr.co.Kmarket.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBCP {
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement psmt;
	protected ResultSet rs;
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static DataSource ds = null;
	public static Connection getConnection() throws NamingException, SQLException {
		if (ds == null) {
			ds = (DataSource) new InitialContext()
					.lookup("java:comp/env/mydb");
		}
		return ds.getConnection();
	}
	
	/**
	 * 클래스 종료
	 */
	public void close() {
		try {
			// null 채크 && closed 체크 후 close
			if(rs!=null)   if(!rs.isClosed()) 	rs.close();
			if(psmt!=null) if(!psmt.isClosed()) psmt.close();
			if(stmt!=null) if(!stmt.isClosed()) stmt.close();
			if(conn!=null) if(!conn.isClosed()) conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		// close 후 null로 재생성
		conn = null;
		stmt = null;
		psmt = null;
		rs = null;
	}
}
