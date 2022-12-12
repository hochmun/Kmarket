package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.member.MemberService;
import kr.co.Kmarket.vo.MemberTermsVO;

@WebServlet("/member/signup.do")
public class SignupController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 보안 - type값 오류
		String type = req.getParameter("type");
		if (!(type.equals("1") || type.equals("2"))) {
			// type 값이 1 또는 2가 아닐때 success 코드 501 전송
			req.getSession().setAttribute("success", "501");
			resp.sendRedirect("/Kmarket/loadingPage.do");
		} else {
			// 약관동의 불러오기
			MemberTermsVO vo = service.selectMemberTerms();
			req.setAttribute("vo", vo);
			
			// 페이지 포워드
			req.getRequestDispatcher("/member/signup.jsp").forward(req, resp);
		}
	}
}
