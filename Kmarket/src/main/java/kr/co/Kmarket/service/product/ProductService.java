package kr.co.Kmarket.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.product.ProductDAO;
import kr.co.Kmarket.vo.Cate1VO;
import kr.co.Kmarket.vo.Cate2VO;
import kr.co.Kmarket.vo.ProductCartVO;
import kr.co.Kmarket.vo.ProductVO;

public enum ProductService {
	INSTANCE;
	private ProductDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ProductService (){
		dao = new ProductDAO();
	}
	
	// service
	
	// create
	
	// read
	/**
	 * 2022/12/13 상품 정보 가져오기
	 * @author 심규영
	 * @param prodNo
	 * @return {@link ProductVO} 상품 정보
	 */
	public ProductVO selectProductWithProdNo(String prodNo) {
		return dao.selectProductWithProdNo(prodNo);
	}
	
	/**
	 * 2022/12/13 카테고리1 이름 가져오기
	 * @author 심규영
	 * @param cate1
	 * @return {@link String} 카테고리1 이름
	 */
	public String formatCate1Name(int cate1) {
		return dao.formatCate1Name(cate1);
	}
	
	/**
	 * 2022/12/13 카테고리2 이름 가져오기
	 * @author 심규영
	 * @param cate1
	 * @param cate2
	 * @return {@link String} 카테고리2 이름
	 */
	public String formatCate2Name(int cate1, int cate2) {
		return dao.formatCate2Name(cate1, cate2);
	}
	
	/**
	 * 2022/12/08 - 카테고리1 불러오기
	 * @author 심규영
	 * @return List<{@link Cate1VO}> - 카테고리1
	 */
	public List<Cate1VO> selectcate1(){
		return dao.selectcate1();
	}
	
	/**
	 * 2022/12/08 카테고리2 불러오기
	 * @author 심규영
	 * @param cate1
	 * @return cate2 list
	 */
	public List<Cate2VO> selectcate2(String cate1){
		return dao.selectcate2(cate1);
	}
	
	/**
	 * 2022/12/14 카테고리1 카테고리2 불러오기
	 * @author 심규영
	 * @return
	 */
	public Map<String, Object> selectCate1Cate2() {
		return dao.selectCate1Cate2();
	}
	
	/**
	 * 2022/12/13 product 불러오기
	 * @author 김재준
	 * 
	 */
	public List<ProductVO> selectProducts(String prodCate1, String prodCate2){
		List<ProductVO> pvos = dao.selectProducts(prodCate1, prodCate2);
		return pvos;
	}
	public ProductVO selectProduct(String prodNo) {
		return dao.selectProduct(prodNo);
	}
	
	/**
	 *  2022/12/13 Cate1,2VO 전체 불러오기
	 * @author 김재준
	 * @param prodCate1
	 * @param prodCate2
	 * @return
	 */
	public Cate1VO selectProdCates(String prodCate1, String prodCate2) {
		return dao.selectProdCates(prodCate1, prodCate2);
	}
	
	/**
	 * 2022/12/13 product 조건별 불러오기
	 * 
	 * 판매량 높은순
	 */
	public List<ProductVO> SelectProductSold(String prodCate1, String prodCate2){
		List<ProductVO> prods = dao.SelectProductSold(prodCate1, prodCate2);
		return prods;
	}
	// 낮은가격
	public List<ProductVO> SelectProductLow(String prodCate1, String prodCate2){
		List<ProductVO> prods = dao.SelectProductLow(prodCate1, prodCate2);
		return prods;
	}
	/**
	 * 높은가격
	 */
	public List<ProductVO> SelectProductHigh(String prodCate1, String prodCate2){
		List<ProductVO> prods = dao.SelectProductHigh(prodCate1, prodCate2);
		return prods;
	}
	/**
	 * 별점순
	 */
	public List<ProductVO> SelectProductHstar(String prodCate1, String prodCate2){
		List<ProductVO> prods = dao.SelectProductHstar(prodCate1, prodCate2);
		return prods;
	}
	/**
	 *  리뷰순
	 * @param pv
	 * @return
	 */
	public List<ProductVO> SelectProductReview(String prodCate1, String prodCate2){
		List<ProductVO> prods = dao.SelectProductReview(prodCate1, prodCate2);
		return prods;
	}
	/**
	 *  최근순
	 * @param pv
	 * @return
	 */
	public List<ProductVO> SelectProductLatest(String prodCate1, String prodCate2){
		List<ProductVO> prods = dao.SelectProductLatest(prodCate1, prodCate2);
		return prods;
	}
	
	
	/**
	 * 카테고리별 총 게시물 갯수
	 * @return
	 */
	public int selectCountProducts(String prodNo, String prodCate1, String prodCate2, String prodName, String descript) {
		return dao.selectCountProducts(prodNo, prodCate1, prodCate2, prodName, descript);
	}
	
	// upload
	
	// delete
	
	// service
		/**
		 * 게시물 페이징
		 */
		public int boardPaging(HttpServletRequest req, String prodNo, String prodCate1, String prodCate2, String prodName, String descript) {
			String pg = req.getParameter("pg");
			
			int currentPage = 1; // 현재 페이지
			int total = selectCountProducts(prodNo, prodCate1, prodCate2, prodName, descript); // 총 게시물 갯수
			int lastPageNum = 0; // 마지막 페이지 번호
			
			// 페이지 마지막 번호 계산
			if(total % 10 != 0) lastPageNum = (total/10)+1;
			else lastPageNum = (total/10);
			
			// 전체 페이지 게시물 limit 시작값 계산
			if(pg != null) currentPage = Integer.parseInt(pg);
			int limitStart = (currentPage - 1) * 10;
			
			// 페이지 그룹 계산
			int pageGroupCurrent = (int)Math.ceil(currentPage/10.0);
			int pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
			int pageGroupEnd = pageGroupCurrent * 10;
			
			if (pageGroupEnd > lastPageNum) pageGroupEnd = lastPageNum;
			
			// 페이지 시작 번호 계산
			int pageStartNum = total - limitStart;
			
			req.setAttribute("lastPageNum", lastPageNum);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("pageGroupCurrent", pageGroupCurrent);
			req.setAttribute("pageGroupStart", pageGroupStart);
			req.setAttribute("pageGroupEnd", pageGroupEnd);
			req.setAttribute("pageStartNum", pageStartNum);
			
			return limitStart;
		}
		
		/**
		 * 카테고리 변환
		 
		public String cateNameFormat(int cate1, int cate2) {
			String titName = "";
			logger.debug("cate1 : "+cate1+", cate2 : "+cate2);
			switch(cate1) {
				case 1:
					titName = "cloth";
					switch(cate2) {
					case 1:
						titName = "man";
						break;
					case 2:
						titName = "woman";
						break;
					case 3:
						titName = "goods";
						break;
					case 4:
						titName = "beauty";
						break;
					default:
						titName = "-1";
					}
					break;
				case 2:
					titName = "furniture";
					switch(cate2) {
					case 1:
						titName = "pc";
						break;
					case 2:
						titName = "furniture";
						break;
					case 3:
						titName = "phone";
						break;
					case 4:
						titName = "other";
						break;
					default:
						titName = "-1";
					}
					break;
				case 3:
					titName = "food";
					switch(cate2) {
					case 1:
						titName = "fresh";
						break;
					case 2:
						titName = "processed";
						break;
					case 3:
						titName = "health";
						break;
					case 4:
						titName = "necess";
						break;
					default:
						titName = "-1";
					}
					break;
				case 4:
					titName = "home";
					switch(cate2) {
					case 1:
						titName = "DIY";
						break;
					case 2:
						titName = "bed";
						break;
					case 3:
						titName = "living";
						break;
					case 4:
						titName = "office";
						break;
					default:
						titName = "-1";
						break;
					}
					break;
				default:
					titName = "-1";
					break;
			}
			logger.debug("cate2 : "+titName);
			return titName;
		}*/
}
