package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.member.MemberService;
import kr.co.Kmarket.vo.MemberVO;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 아이디와 비밀번호와 일치한 유저정보를 가져온다.
		MemberVO vo = service.loginUser(req.getParameter("uid"), req.getParameter("pass"));
		
		// 동일한 회원 정보가 있는지 확인
		if(vo.getUid() != null) {
			// 회원이 맞을 경우
			// 일반 회원인지 판매자 회원인지 확인
			if(vo.getType() == 1) {
				// 일반회원일 경우 메인페이지로 이동
				// 세션에 회원 정보 저장
				req.getSession().setAttribute("sessUser", vo);
				resp.sendRedirect("/Kmarket/index.do");
			} else if(vo.getType() == 2) {
				// 판매자 회원일 경우 관리자 페이지로 이동
				// 세션에 회원 정보 저장
				req.getSession().setAttribute("sessUser", vo);
				resp.sendRedirect("/Kmarket/admin/index.do");
			} else if(vo.getType() == 5) {
				// 최고 관리자
				req.getSession().setAttribute("sessUser", vo);
				resp.sendRedirect("/Kmarket/admin/index.do");
			} else {
				// 타입값이 이상할 경우
				req.getSession().setAttribute("success", "500");
				resp.sendRedirect("/Kmarket/loadingPage.do");
			}
		} else {
			// 회원 정보가 없을 경우
			// 로그인 실패 값 전송
			req.getSession().setAttribute("success", "200");
			resp.sendRedirect("/Kmarket/loadingPage.do");
		}
	}
}
