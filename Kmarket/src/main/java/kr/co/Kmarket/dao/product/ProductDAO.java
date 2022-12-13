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
	public int insertProduct(ProductVO vo) {
		int result = 0;
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
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
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
	
	/**
	 * 2022/12/13 상품정보 가져오기
	 * @author 심규영
	 * @param prodNo
	 * @return {@link ProductVO} 상품정보
	 */
	public ProductVO selectProductWithProdNo(String prodNo) {
		ProductVO vo = new ProductVO();
		try {
			logger.info("productDAO selectProductWithProdNo...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_WITH_PRODNO);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setProdNo(rs.getInt(1));
				vo.setProdCate1(rs.getInt(2));
				vo.setProdCate2(rs.getInt(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setCompany(rs.getString(6));
				vo.setSeller(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10));
				vo.setStock(rs.getInt(11));
				vo.setSold(rs.getInt(12));
				vo.setDelivery(rs.getInt(13));
				vo.setHit(rs.getInt(14));
				vo.setScore(rs.getInt(15));
				vo.setReview(rs.getInt(16));
				vo.setThumb1(rs.getString(17));
				vo.setThumb2(rs.getString(18));
				vo.setThumb3(rs.getString(19));
				vo.setDetail(rs.getString(20));
				vo.setStatus(rs.getString(21));
				vo.setDuty(rs.getString(22));
				vo.setReceipt(rs.getString(23));
				vo.setBizType(rs.getString(24));
				vo.setOrigin(rs.getString(25));
				vo.setIp(rs.getString(26));
				vo.setRdate(rs.getString(27));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	/**
	 * 2022/12/13 카테고리1 이름 받아오기
	 * @author 심규영
	 * @param cate1
	 * @return String cate1Name
	 */
	public String formatCate1Name(int cate1) {
		String cate1Name = "";
		try {
			logger.info("productDAO formatCate1Name...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_CATE1_NAME);
			psmt.setInt(1, cate1);
			rs = psmt.executeQuery();
			if(rs.next()) {
				cate1Name = rs.getString("c1Name");
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return cate1Name;
	}
	
	/**
	 * 2022/12/13 카테고리2 이름 가져오기
	 * @author 심규영
	 * @param cate1
	 * @param cate2
	 * @return {@link String} 카테고리2 이름
	 */
	public String formatCate2Name(int cate1, int cate2) {
		String cate2Name = "";
		try {
			logger.info("productDAO formatCate2Name...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_CATE2_NAME);
			psmt.setInt(1, cate1);
			psmt.setInt(2, cate2);
			rs = psmt.executeQuery();
			if(rs.next()) {
				cate2Name = rs.getString("c2Name");
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return cate2Name;
	}
	
	// upload
	
	// delete
}
