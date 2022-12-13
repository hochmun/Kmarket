package kr.co.Kmarket.service.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.Kmarket.dao.member.MemberDAO;
import kr.co.Kmarket.vo.MemberTermsVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.vo.MemberVO;

public enum MemberService {
	INSTANCE;
	private MemberDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private MemberService() {
		dao = new MemberDAO();
	}
	
	// service
	/**
	 * 2022/12/12 로그아웃 기능
	 * @author 심규영
	 * @param req
	 * @param resp
	 */
	public void logoutMember(HttpServletRequest req, HttpServletResponse resp) {
		// 세션 에서 유저 정보 받아오기
		HttpSession sess = req.getSession();
		MemberVO vo = (MemberVO)sess.getAttribute("sessUser");
		
		// 세션에서 유저 정보 제거
		sess.removeAttribute("sessUser");
		sess.invalidate();
		
		
		// TODO - 자동 로그인 기능 만든후 설정
		/*
		
		// 자동로그인 쿠키 제거
		Cookie cookie = new Cookie("SESSID", null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		
		// 자동로그인 정보 제거
		updateUserForSessionOut(vo.getUid());
		
		*/
	}
	
	
	// create
	public void insertMemberType1(MemberVO vo) {
		dao.insertMemberType1(vo);
	}
	
	public void insertMemberType2(MemberVO vo) {
		dao.insertMemberType1(vo);
	}
	// read
	/**
	 * 2022/12/12 아이디와 비밀번호가 동일한 유저정보 불러오기
	 * @author 심규영
	 * @param uid
	 * @param pass
	 * @return
	 */
	public MemberVO loginUser(String uid, String pass) {
		return dao.selectUser(uid, pass);
	}
	
	/**
	 * 2022/12/12 약관 동의 정보 가져오기
	 * @author 심규영
	 * @return 약관동의
	 */
	public MemberTermsVO selectMemberTerms() {
		return dao.selectMemberTerms();
	}
	
	
	/**
	 * 2022/12/12 ID 중복체크
	 * @author 김재준
	 * @param uid
	 */
	public int checkUid(String uid) {
		logger.info("checkUid...");
		return dao.selectCountUid(uid);
	}
	
	// upload
	
	// delete
	
	// service
	/**
	 * 일반회원 정보 
	 */
	public MemberVO inputMemberVO(HttpServletRequest req) {
		logger.info("inputMemberVO...");
		MemberVO mvo = new MemberVO();
		mvo.setUid(req.getParameter("km_uid"));
		mvo.setPass(req.getParameter("km_pass2"));
		mvo.setName(req.getParameter("km_name"));
		mvo.setGender(Integer.parseInt(req.getParameter("km_gender")));
		mvo.setHp(req.getParameter("km_hp"));
		mvo.setEmail(req.getParameter("km_email"));
		mvo.setZip(req.getParameter("km_zip"));
		mvo.setAddr1(req.getParameter("km_addr1"));
		mvo.setAddr2(req.getParameter("km_addr2"));
		mvo.setRegip(req.getRemoteAddr());
		return mvo;
	
	}
	
	
	/**
	 * 2022/12/12 판매자회원 정보 
	 * @author 라성준
	 */	
	public MemberVO inputMemberSellerVO(HttpServletRequest req) {
		logger.info("inputMemberSellerVO...");
		MemberVO msvo = new MemberVO();
		msvo.setUid(req.getParameter("km_uid"));
		msvo.setPass(req.getParameter("km_pass2"));
		msvo.setCompany(req.getParameter("kms_company"));
		msvo.setCeo(req.getParameter("kms_ceo"));
		msvo.setBizRegNum("kms_corp_reg");
		msvo.setComRegNum("kms_online_reg");
		msvo.setTel("kms_tel");
		msvo.setFax("kms_fax");
		msvo.setEmail("kms_email");
		msvo.setZip("kms_zip");
		msvo.setAddr1("kms_add1");
		msvo.setAddr2("kms_addr2");
		msvo.setName("km_name");
		msvo.setHp("km_hp");
		return msvo;
	}
}
