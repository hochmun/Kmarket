package kr.co.Kmarket.service.cs;

import java.util.List;

import kr.co.Kmarket.dao.cs.CsFaqDAO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsFaqVO;

public enum CsFaqService {
	INSTANCE;
	
	private CsFaqDAO dao;
	
	private CsFaqService () {
		dao = new CsFaqDAO();
	}
	
	// create
	
	// read
	/**
	 * 2022/12/20 - /cs/faq/list - cate1값으로 리스트 불러오기
	 * @author 심규영
	 * @param CsCate1
	 * @return
	 */
	public List<CsFaqVO> selectCsFaqListWithCsCate1(List<CsCate2VO> vos3) {
		return dao.selectCsFaqListWithCsCate1(vos3);
	}
	
	// upload
	
	// delete
	
	// service
}
