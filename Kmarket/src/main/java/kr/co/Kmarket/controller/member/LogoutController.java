package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.member.MemberService;

@WebServlet("/member/logout.do")
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그아웃
		service.logoutMember(req, resp);
		
		// 로그아웃 성공 메세지 전송
		// 세션에 로그아웃 기능 호출 코드 입력
		req.getSession().setAttribute("success", "201");
		// 처리페이지로 이동
		resp.sendRedirect("/Kmarket/loadingPage.do");
	}
}
