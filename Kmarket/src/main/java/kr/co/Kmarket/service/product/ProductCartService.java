package kr.co.Kmarket.service.product;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.product.ProductCartDAO;
import kr.co.Kmarket.vo.ProductCartVO;

public enum ProductCartService {
	INSTANCE;
	private ProductCartDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ProductCartService () {
		dao = new ProductCartDAO();
	}
	
	// service
	
	/**
	 * 2022/12/14 심규영 상품카트VO 등록
	 * @param req
	 * @return {@link ProductCartVO}
	 */
	public ProductCartVO insertProductCartVO(ServletRequest req) {
		ProductCartVO vo = new ProductCartVO();
		
		vo.setUid(req.getParameter("uid"));
		vo.setProdNo(Integer.parseInt(req.getParameter("prodNo")));
		vo.setCount(Integer.parseInt(req.getParameter("count")));
		vo.setPrice(Integer.parseInt(req.getParameter("price")));
		vo.setDiscount(Integer.parseInt(req.getParameter("discount")));
		vo.setPoint(Integer.parseInt(req.getParameter("point")));
		vo.setDelivery(Integer.parseInt(req.getParameter("delivery")));
		vo.setTotal(Integer.parseInt(req.getParameter("total")));
		
		return vo;
	}

	// create
	
	/**
	 * 2022/12/14 상품카트에 상품 등록
	 * @param vo
	 * @return result
	 */
	public int insertProductCart(ProductCartVO vo) {
		return dao.insertProductCart(vo);
	}
	
	// read
	
	// upload
	
	// delete
}
