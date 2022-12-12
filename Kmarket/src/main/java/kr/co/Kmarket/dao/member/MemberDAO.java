package kr.co.Kmarket.dao.member;

import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.db.Sql;

import kr.co.Kmarket.vo.MemberTermsVO;
import kr.co.Kmarket.vo.MemberVO;

public class MemberDAO extends DBCP {
	// create 
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
  
	// read
	/**
	 * 2022/12/12 아이디와 비밀번호가 동일한 유저 정보 불러오기
	 * @author 심규영
	 * @param uid
	 * @param pass
	 * @return
	 */
	public MemberVO selectUser(String uid, String pass) {
		MemberVO vo = new MemberVO();
		try {
			logger.info("selectUser...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_USER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setUid(rs.getString(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setGender(rs.getInt(4));
				vo.setHp(rs.getString(5));
				vo.setEmail(rs.getString(6));
				vo.setType(rs.getInt(7));
				vo.setPoint(rs.getInt(8));
				vo.setLevel(rs.getInt(9));
				vo.setZip(rs.getString(10));
				vo.setAddr1(rs.getString(11));
				vo.setAddr2(rs.getString(12));
				vo.setCompany(rs.getString(13));
				vo.setCeo(rs.getString(14));
				vo.setBizRegNum(rs.getString(15));
				vo.setComRegNum(rs.getString(16));
				vo.setTel(rs.getString(17));
				vo.setManager(rs.getString(18));
				vo.setManagerHp(rs.getString(19));
				vo.setFax(rs.getString(20));
				vo.setRegip(rs.getString(21));
				vo.setWdate(rs.getString(22));
				vo.setRdate(rs.getString(23));
			}
      close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    return vo;
	}
	
	/**
	 * 2022/12/12 약관동의 정보 가져오기
	 * @author 심규영
	 * @return {@link MemberTermsVO}
	 */
	public MemberTermsVO selectMemberTerms() {
		MemberTermsVO vo = new MemberTermsVO();
		try {
			logger.info("selectMemberTerms...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MEMBER_TERMS);
			if(rs.next()) {
				vo.setTerms(rs.getString("terms"));
				vo.setPrivacy(rs.getString("privacy"));
				vo.setLocation(rs.getString("location"));
				vo.setFinance(rs.getString("finance"));
				vo.setTax(rs.getString("tax"));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	/**
	 * 2022/12/12 ID 중복검사
	 * @author 김재준
	 */
	public int selectCountUid(String uid) {
		int result = 0;
		try {
			logger.info("selectCountUid... Overlap Checking..");
			logger.info("uid"+uid);
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_UID);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	// upload
	
	// delete
}
