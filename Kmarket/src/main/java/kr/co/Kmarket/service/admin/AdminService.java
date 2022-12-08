package kr.co.Kmarket.service.admin;

import java.util.Map;

import kr.co.Kmarket.dao.product.ProductDAO;

public enum AdminService {
	
	INSTANCE;
	private ProductDAO dao;
	private AdminService () {
		dao = new ProductDAO();
	}
	
	// service
	
	// create
	
	// read 
	/**
	 * 2022/12/08 - 카테고리 종류 불러오기
	 * @author 심규영
	 * @return c1vos, c2vos - 카테고리1, 카테고리2
	 */
	public Map<String, Object> selectcate() {
		return dao.selectcate();
	}
	
	
	// upload
	
	// delete
}
