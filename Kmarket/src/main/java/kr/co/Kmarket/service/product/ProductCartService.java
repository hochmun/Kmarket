package kr.co.Kmarket.service.product;

import java.util.List;

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
		vo.setProdCate1(Integer.parseInt(req.getParameter("prodCate1")));
		vo.setProdCate2(Integer.parseInt(req.getParameter("prodCate2")));
		vo.setThumb1(req.getParameter("thumb1"));
		vo.setProdName(req.getParameter("prodName"));
		vo.setDescript(req.getParameter("descript"));
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
	
	/**
	 * 2022/12/16 product/order - 유저 장바구니 불러오기
	 * @param uid
	 * @return
	 */
	public List<ProductCartVO> selectProductCartWithUid(String uid) {
		return dao.selectProductCartWithUid(uid);
	}
	
	/**
	 * 2022/12/20 product/order - 장바구니 번호로 장바구니 정보 가져오기
	 * @author 심규영
	 * @param arrays
	 * @return
	 */
	public List<ProductCartVO> selectProductCartWithCartNo(String[] arrays) {
		return dao.selectProductCartWithCartNo(arrays);
	}
	
	// upload
	
	// delete
	/**
	 * 2022/12/18 product/order - 장바구니에 상품 정보 삭제
	 * @author 심규영
	 * @param vos
	 */
	public void deleteProductCarts(List<ProductCartVO> vos) {
		dao.deleteProductCarts(vos);
	}
	
	/**
	 * 2022/12/20 product/cart - 장바구니에 상품 정보 삭제
	 * @author 심규영
	 * @param cartNos
	 * @return
	 */
	public int deleteProductCartWithCartNos(String[] cartNos) {
		return dao.deleteProductCartWithCartNos(cartNos);
	}
	
}
