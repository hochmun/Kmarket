package kr.co.Kmarket.service.product;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.product.ProductOrderDAO;
import kr.co.Kmarket.vo.MemberVO;
import kr.co.Kmarket.vo.ProductOrderVO;

public enum ProductOrderService {
	INSTANCE;
	private ProductOrderDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ProductOrderService () {
		dao = new ProductOrderDAO();
	}
	
	// service
	/**
	 * 2022/12/17 product/order - 주문 정보 저장
	 * @author 심규영
	 * @param req
	 * @return
	 */
	public ProductOrderVO insertOrderVO(HttpServletRequest req) {
		ProductOrderVO vo = new ProductOrderVO();
		
		vo.setOrdUid(((MemberVO)req.getSession().getAttribute("sessUser")).getUid());
		vo.setOrdCount(req.getParameter("ordCount"));
		vo.setOrdPrice(req.getParameter("ordPrice"));
		vo.setOrdDiscount(req.getParameter("ordDiscount"));
		vo.setOrdDelivery(req.getParameter("ordDelivery"));
		vo.setSavePoint(req.getParameter("savePoint"));
		vo.setUsedPoint(req.getParameter("usedPoint"));
		vo.setOrdTotPrice(req.getParameter("ordTotPrice"));
		vo.setRecipName(req.getParameter("recipName"));
		vo.setRecipHp(req.getParameter("recipHp"));
		vo.setRecipZip(req.getParameter("recipZip"));
		vo.setRecipAddr1(req.getParameter("recipAddr1"));
		vo.setRecipAddr2(req.getParameter("recipAddr2"));
		vo.setOrdPayment(req.getParameter("ordPayment"));
		
		return vo;
	}
	
	// create
	/**
	 * 2022/12/17 product/order - 주문 등록, 등록된 주문의 번호 리턴
	 * @author 심규영
	 * @param vo
	 * @return 등록된 주문의 번호
	 */
	public String insertOrder(ProductOrderVO vo) {
		return dao.insertOrder(vo);
	}
	
	// read
	/**
	 * 2022/12/20 product/complete - 주문 정보 불러오기
	 * @author 심규영
	 * @param ordNo
	 * @return
	 */
	public ProductOrderVO selectOrderWithOrdNo(String ordNo) {
		return dao.selectOrderWithOrdNo(ordNo);
	}
	
	// upload
	
	// delete
	
}
