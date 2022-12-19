package kr.co.Kmarket.service.product;

import java.util.List;

import kr.co.Kmarket.dao.product.ProductOrderItemDAO;
import kr.co.Kmarket.vo.ProductCartVO;

public enum ProductOrderItemService {
	INSTANCE;
	private ProductOrderItemDAO dao;
	
	private ProductOrderItemService() {
		dao = new ProductOrderItemDAO();
	}
	
	// service
	
	// create
	/**
	 * 2022/12/17 product/order - 상품 아이템 등록
	 * @author 심규영
	 * @param vos
	 * @param ordNo
	 */
	public void insertOrderItems(List<ProductCartVO> vos, String ordNo) {
		dao.insertOrderItems(vos, ordNo);
	}
	
	// read
	
	// upload
	
	// delete
}
