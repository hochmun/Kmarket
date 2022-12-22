package kr.co.Kmarket.service.cs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.cs.CsFaqDAO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsFaqVO;

public enum CsFaqService {
	INSTANCE;
	
	private CsFaqDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private CsFaqService () {
		dao = new CsFaqDAO();
	}
	
	// create
	/**
	 * 2022/12/22 자주하는 질문 게시물 작성
	 * @author 심규영
	 * @param vo
	 * @return
	 */
	public int insertCsFaq(CsFaqVO vo) {
		return dao.insertCsFaq(vo);
	}
	
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
	
	/**
	 * 2022/12/21 자주묻는 질문 게시물 번호로 게시물 정보 불러오기
	 * @author 심규영
	 * @param faqNo
	 * @return
	 */
	public CsFaqVO selectCsFaqWithFaqNo(String faqNo) {
		return dao.selectCsFaqWithFaqNo(faqNo);
	}
	
	/**
	 * 2022/12/21 관리자 고객센터 자주묻는 질문 전체 게시물에서 상위 10개 리스트 가져오기
	 * @author 심규영
	 * @return
	 */
	public List<CsFaqVO> selectCsFaqListLimit10() {
		return dao.selectCsFaqListLimit10();
	}
	
	/**
	 * 2022/12/21 관리자 고객센터 카테1 과 카테2 값으로 상위 10개 게시물 가져오기
	 * @author 심규영
	 * @param cate1
	 * @param cate2
	 * @return
	 */
	public List<CsFaqVO> selectCsFaqListWithCate1AndCate2(String cate1, String cate2) {
		return dao.selectCsFaqListWithCate1AndCate2(cate1, cate2);
	}
	
	// upload
	/**
	 * 2022/12/22 자주묻는 질문 게시물 수정
	 * @author 심규영
	 * @param vo
	 * @return
	 */
	public int updateCsFaq(CsFaqVO vo) {
		return dao.updateCsFaq(vo);
	}
	
	// delete
	/**
	 * 2022/12/22 자주묻는 질문 개별, 전체 통합
	 * @author 심규영
	 * @param arrays
	 * @return
	 */
	public int deleteCsFaqNoWithFaqNo(String[] arrays) {
		return dao.deleteCsFaqNoWithFaqNo(arrays);
	}
	
	
	// service
	/**
	 * 2022/12/22 vo에 정보 담기
	 * @author 심규영
	 * @param req
	 * @return
	 */
	public CsFaqVO insertCsFaqVO(HttpServletRequest req) {
		CsFaqVO vo = new CsFaqVO();
		
		if(req.getParameter("faqNo") != null) vo.setFaqNo(req.getParameter("faqNo"));
		
		logger.debug(vo.getFaqNo()+"");
		
		vo.setFaqCate1(req.getParameter("cate1"));
		vo.setFaqCate2(req.getParameter("cate2"));
		vo.setFaqTitle(req.getParameter("title"));
		vo.setFaqContent(req.getParameter("content"));
		vo.setFaqRegip(req.getRemoteAddr());
		
		return vo;
	}
	
}
