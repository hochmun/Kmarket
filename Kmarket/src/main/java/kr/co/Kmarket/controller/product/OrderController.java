package kr.co.Kmarket.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.member.MemberService;
import kr.co.Kmarket.vo.MemberVO;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService memberService = MemberService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션에 저장된 유저 정보 가져오기
		MemberVO voNo = (MemberVO) req.getSession().getAttribute("sessUser");
		
		// 유저 정보 갱신 하기
		MemberVO mvo = memberService.selectMemberInfo(voNo.getUid());
		
		// 갱신된 유저 정보로 장바구니 정보 가져오기
		
		req.getRequestDispatcher("/product/order.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 주문하기
		
	}
}
