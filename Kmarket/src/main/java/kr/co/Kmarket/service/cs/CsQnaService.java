package kr.co.Kmarket.service.cs;

import java.util.List;

import kr.co.Kmarket.dao.cs.CsQnaDAO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

public enum CsQnaService {
	
	INSTANCE;
	
	private CsQnaDAO dao;
	
	private CsQnaService () {
		dao = new CsQnaDAO();
	}

	public CsQnaVO selectCsQnaNo(String qnaNo){
		return dao.selectCsQnaNo(qnaNo);
	}
	
	public List<CsQnaVO> selectCsQnaListWithCsCate1(List<CsCate2VO> vos3){
		return dao.selectCsQnaListWithCsCate1(vos3);
	}
	
	public List<CsQnaVO> selectCsQnaList(){
		return dao.selectCsQnaList();
	}
	
	public List<CsQnaVO> selectCsQnaListCate(String cate1, String cate2){
		return dao.selectCsQnaListCate(cate1, cate2);
	}
	
	/**
	 * 2022/12/23 관리자/메인 문의사항 최신순 5개 가져오기
	 * @author 심규영
	 * @return
	 */
	public List<CsQnaVO> selectCsQnaListLimit5() {
		return dao.selectCsQnaListLimit5();
	}
}
