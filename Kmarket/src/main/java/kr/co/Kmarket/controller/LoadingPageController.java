package kr.co.Kmarket.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.Kmarket.service.LoadingService;

@WebServlet("/loadingPage.do")
public class LoadingPageController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LoadingService service = LoadingService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 출력 컨텐츠타입 한글
		resp.setContentType("text/html;charset=UTF-8");
		// 출력 기능
		Writer out = resp.getWriter();
		
		// Session 불러오기 => success 값 가져오기 => 세션에서 success 값 제거
		HttpSession sess = req.getSession();
		String success = (String) sess.getAttribute("success");
		sess.removeAttribute("success");
		
		// success 값에 따른 처리
		// success 값이 없을 경우 메인 페이지로 이동
		if (success == null || success == "") resp.sendRedirect("/");
		else {
			if(success.equals("200")) service.loginFail(out); // 로그인 실패
			if(success.equals("201")) service.logout(out); // 로그아웃
			if(success.equals("202")) service.insertUser(out); // 회원가입 성공
			
			if(success.equals("500")) service.typeError(out); // 타입정보 오류
			if(success.equals("501")) service.connectingError(out); // 비정상적인 접근
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
