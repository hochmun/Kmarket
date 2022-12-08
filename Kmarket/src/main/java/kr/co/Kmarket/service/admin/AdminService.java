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
	 * 카테고리 종류 불러오기
	 * @return
	 */
	public Map<String, Object> selectcate() {
		return dao.selectcate();
	}
	
	
	// upload
	
	// delete
}
