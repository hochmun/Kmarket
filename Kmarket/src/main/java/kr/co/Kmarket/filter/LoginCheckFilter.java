package kr.co.Kmarket.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.vo.MemberVO;

public class LoginCheckFilter implements Filter {
	
	private String unLogin;
	private String uriList;
	private String adminOnly;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 비회원 유저 접근 제한
		unLogin = "/Kmarket/cs/qna/write.do";
		// 일반 유저, 비회원 유저 접근 제한
		uriList = "/Kmarket/admin/";
		// 일반, 비회원, 판매자 유저 접근 제한
		adminOnly = "/Kmarket/admin/cs";
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("loginCheckFilter...");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		
		HttpSession sess = req.getSession();
		MemberVO sessUser = (MemberVO)sess.getAttribute("sessUser");
		
		// 로그인 했으며 관리자 페이지에 들어올 경우 유저 type 확인
		if(uri.contains(uriList)) {
			
			// 로그인을 하지 않고 들어올 경우 => 잘못된 접근
			if(sessUser == null) {
				sess.setAttribute("success", "501");
				resp.sendRedirect("/Kmarket/loadingPage.do");
				return;
			}
			
			if(uri.contains(adminOnly)) {
				// type이 5(최고관리자)가 아닐 경우 접근 제한
				if(sessUser.getType() != 5) {
					resp.sendRedirect("/Kmarket/admin/index.do");
					return;
				}
			}
			
			// 일반회원일 경우 접근 제한
			if(sessUser.getType() == 1) {
				resp.sendRedirect("/Kmarket/index.do");
				return;
			}
		}
		
		// 문의글 작성에 비회원이 접속 했을 경우 접속 제한
		if(uri.contains(unLogin)) {
			if(sessUser == null) {
				sess.setAttribute("success", "501");
				resp.sendRedirect("/Kmarket/loadingPage.do");
				return;
			}
		}
		
		chain.doFilter(request, response);
	}
		
}
