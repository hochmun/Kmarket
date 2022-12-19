package kr.co.Kmarket.service.member;

import kr.co.Kmarket.dao.member.MemberPointDAO;
import kr.co.Kmarket.vo.ProductOrderVO;

public enum MemberPointService {
	INSTANCE;
	private MemberPointDAO dao;
	
	private MemberPointService() {
		dao = new MemberPointDAO();
	}
	
	// service
	
	// create
	/**
	 * 2022/12/17 product/order - 포인트 사용 정보 기록
	 * @author 심규영
	 * @param ordervo
	 * @param ordNo
	 */
	public void insertMemberPoint(ProductOrderVO ordervo, String ordNo) {
		dao.insertMemberPoint(ordervo, ordNo);
	}
	
	// read
	
	// upload
	
	// delete
}
