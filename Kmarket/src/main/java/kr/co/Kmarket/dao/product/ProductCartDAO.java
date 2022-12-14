package kr.co.Kmarket.dao.product;

import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.ProductCartVO;

public class ProductCartDAO extends DBCP {
	
	// create
	
	/**
	 * 2022/12/14 상품카트에 저장
	 * @author 심규영
	 * @param vo
	 * @return result
	 */
	public int insertProductCart(ProductCartVO vo) {
		int result = 0;
		try {
			logger.info("ProductCartDAO insertProductCart...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_PRODUCT_CART);
			psmt.setInt(1, vo.getCartNo());
			psmt.setString(2, vo.getUid());
			psmt.setInt(3, vo.getProdNo());
			psmt.setInt(4, vo.getCount());
			psmt.setInt(5, vo.getPrice());
			psmt.setInt(6, vo.getDiscount());
			psmt.setInt(7, vo.getPoint());
			psmt.setInt(8, vo.getDelivery());
			psmt.setInt(9, vo.getTotal());
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	// read
	
	// upload
	
	// delete
	
}
