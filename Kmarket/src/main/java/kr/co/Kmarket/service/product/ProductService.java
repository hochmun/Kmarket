package kr.co.Kmarket.service.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.product.ProductDAO;
import kr.co.Kmarket.vo.Cate1VO;
import kr.co.Kmarket.vo.Cate2VO;
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
	 * 2022/12/13 product 조건별 불러오기
	 * 
	 * 판매량 높은순
	 */
	public List<ProductVO> SelectProductSold(ProductVO pv, String prodNO){
		List<ProductVO> vos = dao.SelectProductSold(pv, prodNO);
		return vos;
	}
	// 낮은가격
	public List<ProductVO> SelectProductLow(ProductVO pv, String prodNO){
		List<ProductVO> vos = dao.SelectProductLow(pv, prodNO);
		return vos;
	}
	/**
	 * 높은가격
	 */
	public List<ProductVO> SelectProductHigh(ProductVO pv, String prodNO){
		List<ProductVO> vos = dao.SelectProductHigh(pv, prodNO);
		return vos;
	}
	/**
	 * 별점순
	 */
	public List<ProductVO> SelectProductHstar(ProductVO pv, String prodNO){
		List<ProductVO> vos = dao.SelectProductHstar(pv, prodNO);
		return vos;
	}
	/**
	 *  리뷰순
	 * @param pv
	 * @return
	 */
	public List<ProductVO> SelectProductReview(ProductVO pv, String prodNO){
		List<ProductVO> vos = dao.SelectProductReview(pv, prodNO);
		return vos;
	}
	
	/**
	 * 카테고리별 총 게시물 갯수
	 * @return
	 */
	public int selectCountProducts(String search, String prodName) {
		return dao.selectCountProducts(search, prodName);
	}
	
	// upload
	
	// delete
	
	// service
		/**
		 * 게시물 페이징
		 */
		public int boardPaging(HttpServletRequest req, String titName, String search) {
			String pg = req.getParameter("pg");
			
			int currentPage = 1; // 현재 페이지
			int total = selectCountProducts(search, titName); // 총 게시물 갯수
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
		 */
		public String cateNameFormat(String cate1, String cate2) {
			String cate1Name = "";
			String cate2Name = "";
			logger.debug("cate1 : "+cate1+", cate2 : "+cate2);
			switch(cate1) {
				case "1":
					cate1Name = "cloth";
					switch(cate2) {
					case "1":
						cate2Name = "man";
						break;
					case "2":
						cate2Name = "woman";
						break;
					case "3":
						cate2Name = "goods";
						break;
					case "4":
						cate2Name = "beauty";
						break;
					default:
						cate2Name = "-1";
					}
					break;
				case "2":
					cate1Name = "furniture";
					switch(cate2) {
					case "1":
						cate2Name = "pc";
						break;
					case "2":
						cate2Name = "furniture";
						break;
					case "3":
						cate2Name = "phone";
						break;
					case "4":
						cate2Name = "other";
						break;
					default:
						cate2Name = "-1";
					}
					break;
				case "3":
					cate1Name = "food";
					switch(cate2) {
					case "1":
						cate2Name = "fresh";
						break;
					case "2":
						cate2Name = "processed";
						break;
					case "3":
						cate2Name = "health";
						break;
					case "4":
						cate2Name = "necess";
						break;
					default:
						cate2Name = "-1";
					}
					break;
				case "4":
					cate1Name = "home";
					switch(cate2) {
					case "1":
						cate2Name = "DIY";
						break;
					case "2":
						cate2Name = "bed";
						break;
					case "3":
						cate2Name = "living";
						break;
					case "4":
						cate2Name = "office";
						break;
					default:
						cate2Name = "-1";
						break;
					}
					break;
				default:
					cate1Name = "-1";
					break;
			}
			logger.debug("cate2 : "+cate2Name);
			return cate2Name;
		}
}
