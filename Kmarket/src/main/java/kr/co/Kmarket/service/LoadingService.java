package kr.co.Kmarket.service;

import java.io.IOException;
import java.io.Writer;

public enum LoadingService {
	INSTANCE;
	
	private LoadingService() {}
	
	// service
	/**
	 * 2022/12/12 - 로그인 실패
	 * @author 심규영
	 * @param out
	 * @throws IOException
	 */
	public void loginFail(Writer out) throws IOException {
		out.write("<script>alert('로그인에 실패하였습니다.\\n아이디와 비밀번호를 다시 확인하여 주십시오.');"
				+ "location.href='${pageContext.request.contextPath}/member/login.do';</script>");
	}
	
	/**
	 * 2022/12/12 - 로그아웃
	 * @author 심규영
	 * @param out
	 * @throws IOException
	 */
	public void logout(Writer out) throws IOException {
		// document.referrer => 이전페이지로 새로고침
		out.write("<script>alert('로그아웃 하였습니다.');location.href = document.referrer;</script>");
	}
	
	/**
	 * 2022/12/12 - 회원가입 완료
	 * @author 심규영
	 * @param out
	 * @throws IOException
	 */
	public void insertUser(Writer out) throws IOException {
		out.write("<script>alert('회원 가입이 완료되었습니다.');location.href='${pageContext.request.contextPath}/member/login.do';</script>");
	}
	
	// create
	
	// read
	
	// upload
	
	// delete
}
