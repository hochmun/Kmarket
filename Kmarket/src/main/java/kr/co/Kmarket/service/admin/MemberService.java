package kr.co.Kmarket.service.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.product.MemberDAO;
import kr.co.Kmarket.vo.MemberVO;

public enum MemberService {
	INSTANCE;
	private MemberDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private MemberService() {
		dao = new MemberDAO();
	}
	
	// 회원가입
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}
}
