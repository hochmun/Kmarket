package kr.co.Kmarket.dao.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * 2022/12/13 - 상품 가져오기
	 * @author 김재준
	 * @return 
	 */
	public ProductVO selectProduct(String prodNo) {
		ProductVO pvo = null;
		try {
			logger.info("selectProduct..");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				pvo = new ProductVO();
				pvo.setProdNo(rs.getInt(1));
				pvo.setProdCate1(rs.getString(2));
				pvo.setProdCate2(rs.getString(3));
				pvo.setProdName(rs.getString(4));
				pvo.setDescript(rs.getString(5));
				pvo.setCompany(rs.getString(6));
				pvo.setSeller(rs.getString(7));
				pvo.setPrice(rs.getString(8));
				pvo.setDiscount(rs.getString(9));
				pvo.setPoint(rs.getString(10));
				pvo.setStock(rs.getString(11));
				pvo.setSold(rs.getInt(12));
				pvo.setDelivery(rs.getString(13));
				pvo.setHit(rs.getInt(14));
				pvo.setScore(rs.getInt(15));
				pvo.setReview(rs.getInt(16));
				pvo.setThumb1(rs.getString(17));
				pvo.setThumb2(rs.getString(18));
				pvo.setThumb3(rs.getString(19));
				pvo.setDetail(rs.getString(20));
				pvo.setStatus(rs.getString(21));
				pvo.setDuty(rs.getString(22));
				pvo.setReceipt(rs.getString(23));
				pvo.setBizType(rs.getString(24));
				pvo.setOrigin(rs.getString(25));
				pvo.setIp(rs.getString(26));
				pvo.setRdate(rs.getString(27));
				pvo.setEtc1(rs.getInt(28));
				pvo.setEtc2(rs.getInt(29));
				pvo.setEtc3(rs.getString(30));
				pvo.setEtc4(rs.getString(31));
				pvo.setEtc5(rs.getString(32));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return pvo;
	}
	
	
	/**
	 * 2022/12/13 - prodCate 가져오기
	 * @author 김재준
	 * Cate2VO 데이터 => Cate1VO 추가  
	 * @return 
	 */
	public Cate1VO selectProdCates(String prodCate1, String prodCate2) {
		Cate1VO cvo = null;
		try {
			logger.info("selectProdCates...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PROD_CATE);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				cvo = new Cate1VO();
				cvo.setCate1(rs.getInt(1));
				cvo.setC1Name(rs.getString(2));
				cvo.setCate2(rs.getInt(3));
				cvo.setC2Name(rs.getString(4));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return cvo;
	}
	
	
	/**
	 * 2022/12/13 - 상품목록 가져오기
	 * @author 김재준
	 * @return 
	 */
	public List<ProductVO> selectProducts(String prodCate1, String prodCate2) {
		List<ProductVO> pvos = new ArrayList<>();
		try {
			logger.info("selectProducts...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCTS);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setProdNo(rs.getInt(1));
				pvo.setProdCate1(rs.getString(2));
				pvo.setProdCate2(rs.getString(3));
				pvo.setProdName(rs.getString(4));
				pvo.setDescript(rs.getString(5));
				pvo.setCompany(rs.getString(6));
				pvo.setSeller(rs.getString(7));
				pvo.setPrice(rs.getString(8));
				pvo.setDiscount(rs.getString(9));
				pvo.setPoint(rs.getString(10));
				pvo.setStock(rs.getString(11));
				pvo.setSold(rs.getInt(12));
				pvo.setDelivery(rs.getString(13));
				pvo.setHit(rs.getInt(14));
				pvo.setScore(rs.getInt(15));
				pvo.setReview(rs.getInt(16));
				pvo.setThumb1(rs.getString(17));
				pvo.setThumb2(rs.getString(18));
				pvo.setThumb3(rs.getString(19));
				pvo.setDetail(rs.getString(20));
				pvo.setStatus(rs.getString(21));
				pvo.setDuty(rs.getString(22));
				pvo.setReceipt(rs.getString(23));
				pvo.setBizType(rs.getString(24));
				pvo.setOrigin(rs.getString(25));
				pvo.setIp(rs.getString(26));
				pvo.setRdate(rs.getString(27));
				pvo.setEtc1(rs.getInt(28));
				pvo.setEtc2(rs.getInt(29));
				pvo.setEtc3(rs.getString(30));
				pvo.setEtc4(rs.getString(31));
				pvo.setEtc5(rs.getString(32));
				
				pvos.add(pvo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return pvos;
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
	 * 카테고리별 전체 게시물 갯수
	 * @author 김재준
	 * @return
	 */
	public int selectCountProducts(String prodCate1, String prodCate2, String prodName, String descript) {
		int total = 0;
		try {
			logger.info("selectCountProducts...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_PRODUCTS);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			psmt.setString(3, prodName);
			psmt.setString(4, descript);
			rs = psmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	
	/**
	 * 2022/12/13 - 상품목록 보기 (판매많은순)
	 * @author 김재준
	 * @return 
	 */
	public List<ProductVO> SelectProductSold(String prodCate1, String prodCate2){
		List<ProductVO> prods = new ArrayList<>();
		try {
			logger.info("SelectProductSold...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_LIST_SOLD);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO pv = new ProductVO();
				pv.setProdNo(rs.getInt("prodno"));
				pv.setProdName(rs.getString("prodname"));
				pv.setDescript(rs.getString("descript"));
				pv.setSeller(rs.getString("seller"));
				pv.setPrice(rs.getString("price"));
				pv.setDiscount(rs.getString("discount"));
				pv.setDelivery(rs.getString("delivery"));
				pv.setScore(rs.getInt("score"));
				pv.setThumb1(rs.getString("thumb1"));
				
				prods.add(pv);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return prods;
	}
	
	/**
	 * 2022/12/13 - 상품목록 보기 (낮은가격순)
	 * @author 김재준
	 * @return 
	 */
	public List<ProductVO> SelectProductLow(String prodCate1, String prodCate2){
		List<ProductVO> prods = new ArrayList<>();
		try {
			logger.info("SelectProductLow...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_LIST_LOW);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO pv = new ProductVO();
				pv.setProdNo(rs.getInt("prodno"));
				pv.setProdName(rs.getString("prodname"));
				pv.setDescript(rs.getString("descript"));
				pv.setSeller(rs.getString("seller"));
				pv.setPrice(rs.getString("price"));
				pv.setDiscount(rs.getString("discount"));
				pv.setDelivery(rs.getString("delivery"));
				pv.setScore(rs.getInt("score"));
				pv.setThumb1(rs.getString("thumb1"));
				
				prods.add(pv);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return prods;
	}
	
	/**
	 * 2022/12/13 - 상품목록 보기 (높은가격순)
	 * @author 김재준
	 * @return 
	 */
	public List<ProductVO> SelectProductHigh(String prodCate1, String prodCate2){
		List<ProductVO> prods = new ArrayList<>();
		try {
			logger.info("SelectProductHigh...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_LIST_HIGH);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO pv = new ProductVO();
				pv.setProdNo(rs.getInt("prodno"));
				pv.setProdName(rs.getString("prodname"));
				pv.setDescript(rs.getString("descript"));
				pv.setSeller(rs.getString("seller"));
				pv.setPrice(rs.getString("price"));
				pv.setDiscount(rs.getString("discount"));
				pv.setDelivery(rs.getString("delivery"));
				pv.setScore(rs.getInt("score"));
				pv.setThumb1(rs.getString("thumb1"));
				
				prods.add(pv);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return prods;
	}
	
	/**
	 * 2022/12/13 - 상품목록 보기 (평점높은순)
	 * @author 김재준
	 * @return 
	 */
	public List<ProductVO> SelectProductHstar(String prodCate1, String prodCate2){
		List<ProductVO> prods = new ArrayList<>();
		try {
			logger.info("SelectProductHstar...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_LIST_HSTAR);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO pv = new ProductVO();
				pv.setProdNo(rs.getInt("prodno"));
				pv.setProdName(rs.getString("prodname"));
				pv.setDescript(rs.getString("descript"));
				pv.setSeller(rs.getString("seller"));
				pv.setPrice(rs.getString("price"));
				pv.setDiscount(rs.getString("discount"));
				pv.setDelivery(rs.getString("delivery"));
				pv.setScore(rs.getInt("score"));
				pv.setThumb1(rs.getString("thumb1"));
				
				prods.add(pv);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return prods;
	}
	
	/**
	 * 2022/12/13 - 상품목록 보기 (후기많은순)
	 * @author 김재준
	 * @return 
	 */
	public List<ProductVO> SelectProductReview(String prodCate1, String prodCate2){
		List<ProductVO> prods = new ArrayList<>();
		try {
			logger.info("SelectProductReview...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_LIST_REVIEW);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO pv = new ProductVO();
				pv.setProdName(rs.getString("prodname"));
				pv.setDescript(rs.getString("descript"));
				pv.setSeller(rs.getString("seller"));
				pv.setPrice(rs.getString("price"));
				pv.setDiscount(rs.getString("discount"));
				pv.setDelivery(rs.getString("delivery"));
				pv.setScore(rs.getInt("score"));
				pv.setThumb1(rs.getString("thumb1"));
				
				prods.add(pv);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return prods;
	}	
	
	/**
	 * 2022/12/13 - 상품목록 보기 (최근등록순)
	 * @author 김재준
	 * @return 
	 */
	public List<ProductVO> SelectProductLatest(String prodCate1, String prodCate2){
		List<ProductVO> prods = new ArrayList<>();
		try {
			logger.info("SelectProductLatest...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_LIST_LATEST);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO pv = new ProductVO();
				pv.setProdName(rs.getString("prodname"));
				pv.setDescript(rs.getString("descript"));
				pv.setSeller(rs.getString("seller"));
				pv.setPrice(rs.getString("price"));
				pv.setDiscount(rs.getString("discount"));
				pv.setDelivery(rs.getString("delivery"));
				pv.setScore(rs.getInt("score"));
				pv.setThumb1(rs.getString("thumb1"));
				
				prods.add(pv);
        }
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    return prods;
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
	
	/**
	 * 2022/12/14 카테고리1 카테고리2 정보 가져오기
	 * @author 심규영
	 * @return
	 */
	public Map<String, Object> selectCate1Cate2() {
		Map<String, Object> voss = new HashMap<>();
		List<Cate1VO> vos1 = new ArrayList<>();
		List<Cate2VO> vos2 = new ArrayList<>();
		try {
			logger.info("ProductDAO selectCate1Cate2...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_CATE1_CATE2);
			while(rs.next()) {
				Cate1VO vo1 = new Cate1VO();
				Cate2VO vo2 = new Cate2VO();
				
				vo1.setCate1(rs.getInt("cate1"));
				vo1.setC1Name(rs.getString("c1Name"));
				vo2.setCate2(rs.getInt("cate2"));
				vo2.setC2Name(rs.getString("c2Name"));
				
				vos1.add(vo1);
				vos2.add(vo2);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		voss.put("vos1", vos1);
		voss.put("vos2", vos2);
		return voss;
	}
	
	// upload
	
	// delete
}
