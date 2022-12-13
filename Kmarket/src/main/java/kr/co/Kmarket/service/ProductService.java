package kr.co.Kmarket.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
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
			
	private ProductService() {
		dao = new ProductDAO();
	}

	// read
	public List<Cate1VO> selectcate1(){
		return dao.selectcate1();
	}
	
	public List<Cate2VO> selectcate2(String cate1){
		return dao.selectcate2(cate1);
	}
	
	public List<ProductVO> SelectProductSold(ProductVO pv){
		List<ProductVO> vos = dao.SelectProductSold(pv);
		return vos;
	}
	public List<ProductVO> SelectProductLow(ProductVO pv){
		List<ProductVO> vos = dao.SelectProductLow(pv);
		return vos;
	}
	public List<ProductVO> SelectProductHigh(ProductVO pv){
		List<ProductVO> vos = dao.SelectProductHigh(pv);
		return vos;
	}
	public List<ProductVO> SelectProductHstar(ProductVO pv){
		List<ProductVO> vos = dao.SelectProductHstar(pv);
		return vos;
	}
	public List<ProductVO> SelectProductReview(ProductVO pv){
		List<ProductVO> vos = dao.SelectProductReview(pv);
		return vos;
	}
	/**
	 * 카테고리별 총 게시물 갯수
	 * @return
	 */
	public int selectCountProducts(String search, String prodName) {
		return dao.selectCountProducts(search, prodName);
	}
	
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
	public String titNameFormat(String cate1, String cate2) {
		String cate2Name = "";
		logger.debug("cate1 : "+cate1+", cate2 : "+cate2);
		switch(cate1) {
			case "1":
				cate2Name = "cloth";
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
				cate2Name = "furniture";
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
				cate2Name = "food";
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
				cate2Name = "home";
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
				cate2Name = "-1";
				break;
		}
		logger.debug("cate2 : "+cate2Name);
		return cate2Name;
	}
}
