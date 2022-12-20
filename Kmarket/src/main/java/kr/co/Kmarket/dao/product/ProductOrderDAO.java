package kr.co.Kmarket.dao.product;

import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.ProductOrderVO;

public class ProductOrderDAO extends DBCP {
	// create
	/**
	 * 2022/12/17 product/order - 주문 등록, 등록된 주문의 번호 리턴
	 * @author 심규영
	 * @param vo
	 * @return 등록된 주문의 번호
	 */
	public String insertOrder(ProductOrderVO vo) {
		String ordNo = "";
		
		try {
			logger.info("ProductOrderDAO insertOrder...");
			conn = getConnection();
			
			psmt = conn.prepareStatement(Sql.INSERT_PRODUCT_ORDER);
			
			psmt.setString(1, vo.getOrdUid());
			psmt.setInt(2, vo.getOrdCount());
			psmt.setInt(3, vo.getOrdPrice());
			psmt.setInt(4, vo.getOrdDiscount());
			psmt.setInt(5, vo.getOrdDelivery());
			psmt.setInt(6, vo.getSavePoint());
			psmt.setInt(7, vo.getUsedPoint());
			psmt.setInt(8, vo.getOrdTotPrice());
			psmt.setString(9, vo.getRecipName());
			psmt.setString(10, vo.getRecipHp());
			psmt.setString(11, vo.getRecipZip());
			psmt.setString(12, vo.getRecipAddr1());
			psmt.setString(13, vo.getRecipAddr2());
			psmt.setInt(14, vo.getOrdPayment());
			
			psmt.executeUpdate();
			
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_ORDER_ORDERNO);
			psmt.setString(1, vo.getOrdUid());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				ordNo = rs.getString("ordNo");
			}
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return ordNo;
	}
	
	// read
	/**
	 * 2022/12/20 product/complete - 주문 정보 불러오기
	 * @author 심규영
	 * @param ordNo
	 * @return
	 */
	public ProductOrderVO selectOrderWithOrdNo(String ordNo) {
		ProductOrderVO vo = new ProductOrderVO();
		try {
			logger.info("ProductOrderDAO selectOrderWithOrdNo...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_ORDER_WITH_ORDNO);
			psmt.setString(1, ordNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setOrdNo(rs.getInt("ordNo"));
				vo.setOrdUid(rs.getString("ordUid"));
				vo.setOrdCount(rs.getInt("ordCount"));
				vo.setOrdPrice(rs.getInt("ordPrice"));
				vo.setOrdDiscount(rs.getInt("ordDiscount"));
				vo.setOrdDelivery(rs.getInt("ordDelivery"));
				vo.setSavePoint(rs.getInt("savePoint"));
				vo.setUsedPoint(rs.getInt("usedPoint"));
				vo.setOrdTotPrice(rs.getInt("ordTotPrice"));
				vo.setRecipName(rs.getString("recipName"));
				vo.setRecipHp(rs.getString("recipHp"));
				vo.setRecipZip(rs.getString("recipZip"));
				vo.setRecipAddr1(rs.getString("recipAddr1"));
				vo.setRecipAddr2(rs.getString("recipAddr2"));
				vo.setOrdPayment(rs.getInt("ordPayment"));
				vo.setOrdComplete(rs.getInt("ordComplete"));
				vo.setOrdDate(rs.getString("ordDate"));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	// upload
	
	// delete
}
