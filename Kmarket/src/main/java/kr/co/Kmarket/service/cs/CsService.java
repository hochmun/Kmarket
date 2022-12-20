package kr.co.Kmarket.service.cs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.cs.CsDAO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

public enum CsService {
	
	INSTANCE;
	private CsDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private CsService() {
		dao = new CsDAO();
	}

	// create
	
	// read
	/**
	 * 2022/12/19 qna 글 작성
	 * @author 김재준
	 * @param vo
	 * @return
	 */
	public int insertQnaArticle(CsQnaVO vo) {
		return dao.insertQnaArticle(vo);
	}
	
	/**
	 * 2022/12/19 qna 작성글 불러오기
	 * @author 김재준
	 * @param no
	 * @return
	 */
	public CsQnaVO selectArticle(String no) {
		return dao.selectQnaArticle(no);
	}
	
	/**
	 * 2022/12/19 qna 작성글 목록 불러오기
	 * @author 김재준
	 * @param cate1
	 * @param start
	 * @return
	 */
	public List<CsQnaVO> selectQnaArticles(int cate1, int start){
		return dao.selectQnaArticles(cate1, start);
	}
	
	// service
	
	/** 페이징 */ 
	
	/**
	 * 2022/12/19 qna 카테고리별 작성글 count
	 * @author 김재준
	 * @param cate1
	 * @return
	 */
	public int selectCountTotal(int cate1) {
		return dao.selectCountTotal(cate1);
	}
}
