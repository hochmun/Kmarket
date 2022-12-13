package kr.co.Kmarket.service.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.product.ProductDAO;
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
	
	// upload
	
	// delete
}
