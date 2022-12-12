package kr.co.Kmarket.service.member;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.member.MemberDAO;
import kr.co.Kmarket.vo.MemberVO;

public enum MemberService {
	INSTANCE;
	private MemberDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private MemberService() {
		dao = new MemberDAO();
	}
	// create
	public void insertMemberType1(MemberVO vo) {
		dao.insertMemberType1(vo);
	}
	// read
	
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
}
