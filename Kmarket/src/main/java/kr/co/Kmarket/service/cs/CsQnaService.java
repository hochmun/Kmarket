package kr.co.Kmarket.service.cs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.cs.CsQnaDAO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsFaqVO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

public enum CsQnaService {
	
	INSTANCE;
	
	private CsQnaDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
	
	public CsQnaVO selectCsQnaWithQnaNo(String qnaNo) {
		return dao.selectCsQnaWithQnaNo(qnaNo);
	}
	
	/**
	 * 2022/12/22 vo에 정보 담기
	 * @author 김재준
	 * @param req
	 * @return
	 */
	public CsQnaVO insertCsQnaVO(HttpServletRequest req) {
		CsQnaVO vo = new CsQnaVO();
		
		if(req.getParameter("qnaNo") != null) vo.setQnaNo(req.getParameter("qnaNo"));
		
		logger.debug(vo.getQnaNo()+"");
		
		vo.setQnaAdminContent(req.getParameter("qnaAdminContent"));
		vo.setQnaRegip(req.getRemoteAddr());
		
		return vo;
	}
	
	public int updateQnaAdminContent(CsQnaVO vo) {
		return dao.updateQnaAdminContent(vo);
	}
	
	public int deleteQnaArticle(String[] arrays) {
		return dao.deleteQnaArticle(arrays);
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
