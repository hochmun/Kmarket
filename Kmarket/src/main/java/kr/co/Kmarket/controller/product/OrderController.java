package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.Kmarket.service.member.MemberService;
import kr.co.Kmarket.service.product.ProductCartService;
import kr.co.Kmarket.vo.MemberVO;
import kr.co.Kmarket.vo.ProductCartVO;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService memberService = MemberService.INSTANCE;
	private ProductCartService productCartService = ProductCartService.INSTANCE;

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
		// 주문하기
		
	}
}
