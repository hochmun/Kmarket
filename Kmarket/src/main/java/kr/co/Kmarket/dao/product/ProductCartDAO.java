package kr.co.Kmarket.dao.product;

import java.util.ArrayList;
import java.util.List;

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
			psmt.setString(1, vo.getUid());
			psmt.setInt(2, vo.getProdNo());
			psmt.setInt(3, vo.getCount());
			psmt.setInt(4, vo.getPrice());
			psmt.setInt(5, vo.getDiscount());
			psmt.setInt(6, vo.getPoint());
			psmt.setInt(7, vo.getDelivery());
			psmt.setInt(8, vo.getTotal());
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	// read
	
	/**
	 * 2022/12/16 product/order - 유저 장바구니 정보 가져오기
	 * @param uid
	 * @return
	 */
	public List<ProductCartVO> selectProductCartWithUid(String uid) {
		List<ProductCartVO> vos = new ArrayList<>();
		try {
			logger.info("ProductCartVO selectProductCartWithUid...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_CART_WITH_UID);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductCartVO vo = new ProductCartVO();
				vo.setCartNo(rs.getInt("cartNo"));
				vo.setUid(rs.getString("uid"));
				vo.setProdNo(rs.getInt("prodNo"));
				vo.setCount(rs.getInt("count"));
				vo.setPrice(rs.getInt("price"));
				vo.setDiscount(rs.getInt("discount"));
				vo.setPoint(rs.getInt("point"));
				vo.setDelivery(rs.getInt("delivery"));
				vo.setTotal(rs.getInt("total"));
				vo.setRdate(rs.getString("rdate"));
				vos.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vos;
	}
	
	// upload
	
	// delete
	
}
