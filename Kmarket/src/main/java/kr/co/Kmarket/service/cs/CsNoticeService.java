package kr.co.Kmarket.service.cs;

import java.util.List;

import kr.co.Kmarket.dao.cs.CsNoticeDAO;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsNoticeVO;

public enum CsNoticeService {
	instance;
	
	private CsNoticeDAO dao;
	
	private CsNoticeService () {
		dao = new CsNoticeDAO();
	}
	
	/**
	 * 2022/12/21 - /cs/notice/list
	 * author 라성준
	 */
	public List<CsNoticeVO> selectCsNoticeListWithCsCate1(List<CsCate2VO> vos4){
		return dao.selectCsNoticeWithCscate1(vos4);
	}
}