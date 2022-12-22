package kr.co.Kmarket.service.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.cs.CsDAO;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

public enum AdminServiceQna {

	INSTANCE;
	private CsDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private AdminServiceQna() {
		dao = new CsDAO();
	}
	
	// create
	
	// read
	/**
	 * 2022/12/19 qna 작성글 불러오기
	 * @author 김재준
	 * @param qnaNo
	 * @return
	 */
	public CsQnaVO selectQnaArticle(String qnaNo) {
		return dao.selectQnaArticle(qnaNo);
	}
	
	/**
	 * 2022/12/21 카테고리 이름 불러오기
	 * @author 김재준
	 * @param cate1name
	 * @return
	 */
	public CsCate1VO selectCsCate(String cate1) {
		return dao.selectCsCate(cate1);
	}
	
	// service
	
	/** 페이징 */ 
	
}
