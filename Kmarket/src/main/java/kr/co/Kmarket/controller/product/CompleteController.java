package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.member.MemberService;
import kr.co.Kmarket.service.product.ProductOrderItemService;
import kr.co.Kmarket.service.product.ProductOrderService;
import kr.co.Kmarket.vo.MemberVO;
import kr.co.Kmarket.vo.ProductOrderItemVO;
import kr.co.Kmarket.vo.ProductOrderVO;

@WebServlet("/product/complete.do")
public class CompleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductOrderService orderService = ProductOrderService.INSTANCE;
	private ProductOrderItemService orderItemService = ProductOrderItemService.INSTANCE;
	private MemberService memberService = MemberService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// session에서 주문 정보 받기
		String ordNo = (String) req.getSession().getAttribute("ordNo");
		
		// session에 주문 번호 제거
		req.getSession().removeAttribute("ordNo");
		
		// 주문번호로 주문정보(product_order), 주문 상품 정보(product_order_item), 주문자 정보(member) 가져오기
		ProductOrderVO povo = orderService.selectOrderWithOrdNo(ordNo);
		List<ProductOrderItemVO> poivos = orderItemService.selectProductListWithOrdNo(ordNo);
		MemberVO mvo = memberService.selectMemberInfo(povo.getOrdUid());
		
		// 정보 전송
		req.setAttribute("mvo", mvo);
		req.setAttribute("poivos", poivos);
		req.setAttribute("povo", povo);
		
		req.getRequestDispatcher("/product/complete.jsp").forward(req, resp);
	}
}
