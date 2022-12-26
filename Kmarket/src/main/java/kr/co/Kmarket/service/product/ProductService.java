package kr.co.Kmarket.service.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

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
	 * 2022/12/15 메인 페이지 - 베스트 상품 정보 가져오기
	 * @author 심규영
	 * @return
	 */
	public List<ProductVO> selectProductBest() {
		return dao.selectProductBest();
	}
	
	/**
	 * 2022/12/15 메인 페이지 - hit, score, discount 많은 순서, 상품정보 8개 불러오기
	 * @param mode
	 * @return
	 */
	public List<ProductVO> selectProductListMode3(int mode) {
		return dao.selectProductListMode3(mode);
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
	public List<ProductVO> selectProducts(String cate1, String cate2, int limitStart, String sort){
		List<ProductVO> pvos = dao.selectProducts(cate1, cate2, limitStart, sort);
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
	public Cate1VO selectProdCates(String cate1, String cate2) {
		return dao.selectProdCates(cate1, cate2);
	}
	
	/**
	 * 2022/12/13 product 조건별 불러오기
	 * 
	 * 판매량 높은순
	 */
	public List<ProductVO> SelectProductSold(String cate1, String cate2, int limitStart){
		List<ProductVO> vos = dao.SelectProductSold(cate1, cate2, limitStart);
		return vos;
	}
	// 낮은가격
	public List<ProductVO> SelectProductLow(String cate1, String cate2, int limitStart){
		List<ProductVO> vos = dao.SelectProductLow(cate1, cate2, limitStart);
		return vos;
	}
	/**
	 * 높은가격
	 */
	public List<ProductVO> SelectProductHigh(String cate1, String cate2, int limitStart){
		List<ProductVO> vos = dao.SelectProductHigh(cate1, cate2, limitStart);
		return vos;
	}
	/**
	 * 별점순
	 */
	public List<ProductVO> SelectProductHstar(String cate1, String cate2, int limitStart){
		List<ProductVO> vos = dao.SelectProductHstar(cate1, cate2, limitStart);
		return vos;
	}
	/**
	 *  리뷰순
	 * @param pv
	 * @return
	 */
	public List<ProductVO> SelectProductReview(String cate1, String cate2, int limitStart){
		List<ProductVO> vos = dao.SelectProductReview(cate1, cate2, limitStart);
		return vos;
	}
	/**
	 *  최근순
	 * @param pv
	 * @return
	 */
	public List<ProductVO> SelectProductLatest(String cate1, String cate2, int limitStart){
		List<ProductVO> vos = dao.SelectProductLatest(cate1, cate2, limitStart);
		return vos;
	}
	
	
	/**
	 * 카테고리별 총 게시물 갯수
	 * @return
	 */
	public int selectCountProducts(String cate1, String cate2) {
		return dao.selectCountProducts(cate1, cate2);
	}
	
	// upload
	
	/**
	 * 2022/12/15 상품 조회수 증가
	 * @author 심규영
	 * @param prodNo
	 */
	public void updateProductHitCount(int prodNo) {
		dao.updateProductHitCount(prodNo);
	}
	
	/**
	 * 2022/12/17 product/order - 상품 갯수 줄이기
	 * @author 심규영
	 * @param vos
	 */
	public void updateProductMinusStock(List<ProductCartVO> vos) {
		dao.updateProductMinusStock(vos);
	}
	
	// delete
	
	// service
		/**
		 * 2022/12/15 게시물 페이징
		 * @author 김재준
		 */
	public int boardPaging(HttpServletRequest req, String pg, String cate1, String cate2, String sort) {
		int currentPage = 1; // 현재 페이지
		int total = selectCountProducts(cate1, cate2); // 총 게시물 갯수
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

}
