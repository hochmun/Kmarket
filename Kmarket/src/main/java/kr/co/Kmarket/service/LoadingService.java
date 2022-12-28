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
				+ "location.href='/Kmarket/member/login.do';</script>");
	}
	
	/**
	 * 2022/12/12 - 로그아웃
	 * @author 심규영
	 * @param out
	 * @throws IOException
	 */
	public void logout(Writer out) throws IOException {
		// document.referrer => 이전페이지로 새로고침
		out.write("<script>alert('로그아웃 하였습니다.');location.href = '/Kmarket/index.do';</script>");
	}
	
	/**
	 * 2022/12/12 - 회원가입 완료
	 * @author 심규영
	 * @param out
	 * @throws IOException
	 */
	public void insertUser(Writer out) throws IOException {
		out.write("<script>alert('회원 가입이 완료되었습니다.');location.href='/Kmarket/member/login.do';</script>");
	}
	
	/**
	 * 2022/12/12 - success-500 정보 오류
	 * @author 심규영
	 * @param out
	 * @throws IOException
	 */
	public void typeError(Writer out) throws IOException {
		out.write("<script>alert('회원정보 오류입니다 관리자에게 문의 하십시오.');"
				+ "location.href='/Kmarket/member/login.do';</script>");
	}
	
	/**
	 * 2022/12/12 - success=501 비정상적인 페이지 접근
	 * @param out
	 * @throws IOException
	 */
	public void connectingError(Writer out) throws IOException {
		out.write("<script>alert('비정상적인 페이지 호출입니다.');</script>");
	}
	
	/**
	 * 2022/12/13 - success=600 상품등록 실패
	 * @param out
	 * @throws IOException
	 */
	public void insertProductFail(Writer out) throws IOException {
		out.write("<script>alert('상품 등록에 실패하였습니다. 관리자에게 문의 하십시오.');"
				+ "location.href='/Kmarket/admin/index.do';</script>");
	}
	
	/**
	 * 2022/12/13 - success=601 상품등록 성공
	 * @param out
	 * @throws IOException
	 */
	public void insertProduct(Writer out) throws IOException {
		out.write("<script>alert('상품이 등록 되었습니다.');"
				+ "location.href='/Kmarket/admin/index.do';</script>");
	}
	
	/**
	 * 2022/12/23 - success=602 게시물 삭제
	 * @author 심규영
	 * @param out
	 * @throws IOException
	 */
	public void deleteArticle(Writer out) throws IOException {
		out.write("<script>alert('게시물이 삭제 되었습니다.');"
				+ "location.href = document.referrer;</script>");
	}
	
	// create
	
	// read
	
	// upload
	
	// delete
}
