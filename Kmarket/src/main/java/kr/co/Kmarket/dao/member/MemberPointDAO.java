package kr.co.Kmarket.dao.member;

import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.ProductOrderVO;

public class MemberPointDAO extends DBCP {
	// create
	/**
	 * 2022/12/17 product/order - 포인트 정보 기록
	 * @author 심규영
	 * @param vo
	 * @param ordNo
	 */
	public void insertMemberPoint(ProductOrderVO vo, String ordNo) {
		try {
			logger.info("MemberPointDAO insertMemberPoint...");
			conn = getConnection();
			
			psmt = conn.prepareStatement(Sql.INSERT_MEMBER_POINT);
			psmt.setString(1, vo.getOrdUid());
			psmt.setString(2, ordNo);
			psmt.setInt(3, (vo.getSavePoint()-vo.getUsedPoint()));
			
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	// read
	
	// upload
	
	// delete
}
