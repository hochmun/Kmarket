package kr.co.Kmarket.dao.product;

import java.util.ArrayList;
import java.util.List;

import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.Cate1VO;
import kr.co.Kmarket.vo.Cate2VO;
import kr.co.Kmarket.vo.ProductVO;

public class ProductDAO extends DBCP {
	// create 
	/**
	 * 2022/12/09 상품 등록
	 * @author 심규영
	 * @param vo
	 */
	public void insertProduct(ProductVO vo) {
		try {
			logger.info("insertProduct... 상품 등록");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_PRODUCT);
			psmt.setInt(1, vo.getProdCate1());
			psmt.setInt(2, vo.getProdCate2());
			psmt.setString(3, vo.getProdName());
			psmt.setString(4, vo.getDescript());
			psmt.setString(5, vo.getCompany());
			psmt.setString(6, vo.getSeller());
			psmt.setInt(7, vo.getPrice());
			psmt.setInt(8, vo.getDiscount());
			psmt.setInt(9, vo.getPoint());
			psmt.setInt(10, vo.getStock());
			psmt.setInt(11, vo.getDelivery());
			psmt.setString(12, vo.getThumb1());
			psmt.setString(13, vo.getThumb2());
			psmt.setString(14, vo.getThumb3());
			psmt.setString(15, vo.getDetail());
			psmt.setString(16, vo.getStatus());
			psmt.setString(17, vo.getDuty());
			psmt.setString(18, vo.getReceipt());
			psmt.setString(19, vo.getBizType());
			psmt.setString(20, vo.getOrigin());
			psmt.setString(21, vo.getIp());
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	// read
	/**
	 * 2022/12/08 - 카테고리1 불러오기
	 * @author 심규영
	 * @return List<{@link Cate1VO}> - 카테고리1
	 */
	public List<Cate1VO> selectcate1() {
		List<Cate1VO> vos = new ArrayList<>();
		try {
			logger.info("selectcate1... 카테고리1 불러오기");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_CATE1);
			while(rs.next()) {
				Cate1VO vo = new Cate1VO();
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
				vos.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vos;
	}
	
	/**
	 * 2022/12/08 카테고리2 불러오기
	 * @author 심규영
	 * @param cate1
	 * @return cate2 list
	 */
	public List<Cate2VO> selectcate2(String cate1) {
		List<Cate2VO> vos = new ArrayList<>();
		try {
			logger.info("selectcate2... 카테고리2 불러오기");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_CATE2);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Cate2VO vo = new Cate2VO();
				vo.setCate1(rs.getInt(1));
				vo.setCate2(rs.getInt(2));
				vo.setC2Name(rs.getString(3));
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
