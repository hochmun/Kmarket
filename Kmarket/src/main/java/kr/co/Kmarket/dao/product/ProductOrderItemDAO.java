package kr.co.Kmarket.dao.product;

import java.util.List;

import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.ProductCartVO;

public class ProductOrderItemDAO extends DBCP {
	// create
	
	/**
	 * 2022/12/17 product/order - 상품 아이템 등록
	 * @author 심규영
	 * @param vos
	 * @param ordNo
	 */
	public void insertOrderItems(List<ProductCartVO> vos, String ordNo) {
		try {
			logger.info("ProductOrderItemDAO insertOrderItems...");
			conn = getConnection();
			
			for(ProductCartVO vo : vos) {
				psmt = conn.prepareStatement(Sql.INSERT_PRODUCT_ORDER_ITEM);
				
				psmt.setString(1, ordNo);
				psmt.setInt(2, vo.getProdNo());
				psmt.setInt(3, vo.getCount());
				psmt.setInt(4, vo.getPrice());
				psmt.setInt(5, vo.getDiscount());
				psmt.setInt(6, vo.getPoint());
				psmt.setInt(7, vo.getDelivery());
				psmt.setInt(8, vo.getTotal());
				
				psmt.executeUpdate();
			}
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	// read
	
	// upload
	
	// delete
}
