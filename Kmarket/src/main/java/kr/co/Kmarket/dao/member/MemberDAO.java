package kr.co.Kmarket.dao.member;

import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.MemberVO;

public class MemberDAO extends DBCP{
	// create
	/**
	 * 일반회원 가입
	 */
	public void insertMemberType1(MemberVO vo) {
		try {
			logger.info("insertMember...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_MEMBER_TYPE1);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getName());
			psmt.setInt(4, vo.getGender());
			psmt.setString(5, vo.getHp());
			psmt.setString(6, vo.getEmail());
			psmt.setString(7, vo.getZip());
			psmt.setString(8, vo.getAddr1());
			psmt.setString(9, vo.getAddr2());
			psmt.setString(10, vo.getRegip());
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
