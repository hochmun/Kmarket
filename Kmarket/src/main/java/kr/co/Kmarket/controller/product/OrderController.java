package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.member.MemberPointService;
import kr.co.Kmarket.service.member.MemberService;
import kr.co.Kmarket.service.product.ProductCartService;
import kr.co.Kmarket.service.product.ProductOrderItemService;
import kr.co.Kmarket.service.product.ProductOrderService;
import kr.co.Kmarket.service.product.ProductService;
import kr.co.Kmarket.vo.MemberVO;
import kr.co.Kmarket.vo.ProductCartVO;
import kr.co.Kmarket.vo.ProductOrderVO;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet {

	// TODO - 장바구니 페이지 완료 후 다시 손보기
	
	private static final long serialVersionUID = 1L;
	private MemberService memberService = MemberService.INSTANCE;
	private ProductService productService = ProductService.INSTANCE;
	private ProductCartService productCartService = ProductCartService.INSTANCE;
	private ProductOrderService productOrderService = ProductOrderService.INSTANCE;
	private ProductOrderItemService productOrderItemService = ProductOrderItemService.INSTANCE;
	private MemberPointService memberPointService = MemberPointService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션에 저장된 유저 정보 가져오기
		HttpSession sess = req.getSession();
		MemberVO voNo = null;
		
		if(sess.getAttribute("sessUser") == null) {
			sess.setAttribute("success", "501");
			resp.sendRedirect("/Kmarket/loadingPage.do");
		}
		
		if(sess.getAttribute("sessUser") != null) {
			voNo = (MemberVO) sess.getAttribute("sessUser");
			
			// 유저 정보 갱신 하기
			MemberVO mvo = memberService.selectMemberInfo(voNo.getUid());

			// 유저 정보 세션에 갱신
			sess.setAttribute("sessUser", mvo);
			
			// 갱신된 유저 정보로 장바구니 정보 가져오기
			List<ProductCartVO> pcvos = productCartService.selectProductCartWithUid(mvo.getUid());
			
			// 정보 저장
			req.setAttribute("mvo", mvo);
			req.setAttribute("pcvos", pcvos);
			
			// 포워드
			req.getRequestDispatcher("/product/order.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 넘어온 정보 받기
		ProductOrderVO ordervo = productOrderService.insertOrderVO(req);
		
		// productOrder 에 주문 정보 올리기
		String ordNo = productOrderService.insertOrder(ordervo);
		
		// productOrderItem 에 주문한 상품 정보 올리기
		List<ProductCartVO> pcvos = productCartService.selectProductCartWithUid(ordervo.getOrdUid());
		productOrderItemService.insertOrderItems(pcvos, ordNo);
		
		// member_point 에 사용한 포인트 및 적립된 포인트 정보 입력
		memberPointService.insertMemberPoint(ordervo, ordNo);
		
		// member 에 누적 포인트 계산해서 입력
		memberService.updateMemberPoint(ordervo);
		
		// prodoct 에 구매한 상품 수 만큼 상품 갯수 줄이기
		productService.updateProductMinusStock(pcvos);
		
		// product_cart 에 상품 정보 제거
		productCartService.deleteProductCarts(pcvos);
		
		// json 출력
		JsonObject json = new JsonObject();
		json.addProperty("ordNo", ordNo);
		resp.getWriter().write(json.toString());
	}
}
