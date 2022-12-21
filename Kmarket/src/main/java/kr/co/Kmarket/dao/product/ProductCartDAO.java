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
		int key = 0;
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
			psmt.executeUpdate();
			
			// 방금 넣은 상품의 key값 가져오기
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MAX_CARTNO_PRODUCT_CART);
			if(rs.next()) {
				key = rs.getInt(1);
			}
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return key;
	}
	
	// read
	
	/**
	 * 2022/12/16 product/order - 유저 장바구니 정보 가져오기
	 * @param uid
	 * @return Map<String, Object> <= List<ProductCartVO> pcvos, List<ProductVO> pvos
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
				
				vo.setThumb1(rs.getString("thumb1"));
				vo.setProdCate1(rs.getInt("prodCate1"));
				vo.setProdCate2(rs.getInt("prodCate2"));
				vo.setProdName(rs.getString("prodName"));
				vo.setDescript(rs.getString("descript"));
				
				vos.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vos;
	}
	
	/**
	 * 2022/12/20 - product/order - 장바구니번호로 장바구니 정보 받기
	 * @author 심규영
	 * @param arrays
	 * @return
	 */
	public List<ProductCartVO> selectProductCartWithCartNo(String[] arrays) {
		List<ProductCartVO> vos = new ArrayList<>();
		try {
			logger.info("ProductCartDAO selectProductCartWithCartNo...");
			conn = getConnection();
			
			for (String array : arrays) {
				psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_CART_WITH_CARTNO);
				psmt.setString(1, array);
				rs = psmt.executeQuery();
				if(rs.next()) {
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
					
					vo.setThumb1(rs.getString("thumb1"));
					vo.setProdCate1(rs.getInt("prodCate1"));
					vo.setProdCate2(rs.getInt("prodCate2"));
					vo.setProdName(rs.getString("prodName"));
					vo.setDescript(rs.getString("descript"));
					
					vos.add(vo);
				}
			}
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vos;
	}
	
	// upload
	
	// delete
	/**
	 * 2022/12/18 product/order - 장바구니에 상품 정보 삭제
	 * @author 심규영
	 * @param vos
	 */
	public void deleteProductCarts(List<ProductCartVO> vos) {
		try {
			logger.info("ProductCartDAO deleteProductCartInfo...");
			conn = getConnection();
			
			for(ProductCartVO vo : vos) {
				psmt = conn.prepareStatement(Sql.DELETE_PRODUCT_CART);
				
				psmt.setInt(1, vo.getCartNo());
				
				psmt.executeUpdate();
			}
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * 2022/12/20 product/cart - 장바구니에서 상품 정보 삭제
	 * @author 심규영
	 * @param cartNos
	 * @return
	 */
	public int deleteProductCartWithCartNos(String[] cartNos) {
		int result = 0;
		
		try {
			logger.info("ProductCartDAO deleteProductCartWithCartNos...");
			conn = getConnection();
			
			for(String cartNo : cartNos) {
				psmt = conn.prepareStatement(Sql.DELETE_PRODUCT_CART);
				psmt.setString(1, cartNo);
				result += psmt.executeUpdate();
			}
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return result;
	}
}
