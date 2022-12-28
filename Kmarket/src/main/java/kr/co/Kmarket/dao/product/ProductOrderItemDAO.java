package kr.co.Kmarket.dao.product;

import java.util.ArrayList;
import java.util.List;

import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.ProductCartVO;
import kr.co.Kmarket.vo.ProductOrderItemVO;

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
			
			psmt = conn.prepareStatement(Sql.INSERT_PRODUCT_ORDER_ITEM);
			
			for(ProductCartVO vo : vos) {
				psmt.setString(1, ordNo);
				psmt.setInt(2, vo.getProdNo());
				psmt.setInt(3, vo.getCount());
				psmt.setInt(4, vo.getPrice());
				psmt.setInt(5, vo.getDiscount());
				psmt.setInt(6, vo.getPoint());
				psmt.setInt(7, vo.getDelivery());
				psmt.setInt(8, vo.getTotal());
				
				psmt.addBatch();
				psmt.clearParameters();
			}
			
			psmt.executeBatch();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	// read
	/**
	 * 2022/12/20 product/complete - 주문번호로 상품 정보 받기
	 * @author 심규영
	 * @param ordNo
	 * @return
	 */
	public List<ProductOrderItemVO> selectProductListWithOrdNo(String ordNo) {
		List<ProductOrderItemVO> vos = new ArrayList<>();
		try {
			logger.info("ProductOrderItemDAO selectProductListWithOrdNo...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_LIST_WITH_ORDNO);
			psmt.setString(1, ordNo);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductOrderItemVO vo = new ProductOrderItemVO();
				vo.setOrdNo(rs.getInt("ordNo"));
				vo.setProdNo(rs.getInt("prodNo"));
				vo.setCount(rs.getInt("count"));
				vo.setPrice(rs.getInt("price"));
				vo.setDiscount(rs.getInt("discount"));
				vo.setPoint(rs.getInt("point"));
				vo.setDelivery(rs.getInt("delivery"));
				vo.setTotal(rs.getInt("total"));
				vo.setProdCate1(rs.getInt("prodCate1"));
				vo.setProdCate2(rs.getInt("prodCate2"));
				vo.setThumb1(rs.getString("thumb1"));
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
	
	// upload
	
	// delete
}
