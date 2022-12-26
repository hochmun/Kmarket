package kr.co.Kmarket.service.cs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.cs.CsDAO;
import kr.co.Kmarket.vo.AdminVO;
import kr.co.Kmarket.vo.MemberVO;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
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
	 * @param qnaNo
	 * @return
	 */
	public CsQnaVO selectQnaArticle(String qnaNo) {
		return dao.selectQnaArticle(qnaNo);
	}
	
	/**
	 * 2022/12/23 관리자/메인 쇼핑몰 운영 현황
	 * @author 심규영
	 * @return
	 */
	public AdminVO selectAll() {
		return dao.selectAll();
	}
	
	// service
	
	/** 페이징 */ 
	
	/**
	 * 2022/12/19 qna 작성글 목록 불러오기
	 * @author 김재준
	 * @param cate1
	 * @param limitStart
	 * @return
	 */
	public List<CsQnaVO> selectQnaArticles(String cate1, int limitStart){
		return dao.selectQnaArticles(cate1, limitStart);
	}
	
	/**
	 * 2022/12/20 카테고리1 정보 가져오기
	 * @return
	 */
	public List<CsCate1VO> selectCsCate1() {
		return dao.selectCsCate1();
	}
	
	/**
	 * 2022/12/20 카테고리1 값으로 카테고리 2 정보 가져오기
	 * @author 심규영
	 * @param csCate1
	 * @return
	 */
	public List<CsCate2VO> selectCsCate2(String csCate1) {
		return dao.selectCsCate2(csCate1);
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
	
	/**
	 * 2022/12/19 qna 카테고리별 작성글 count
	 * @author 김재준
	 * @param cate1
	 * @return
	 */
	public int selectCountTotal(String cate1) {
		return dao.selectCountTotal(cate1);
	}
	
	public int boardPaging(HttpServletRequest req, String cate1) {
		String pg = req.getParameter("pg");
		
		int currentPage = 1; // 현재 페이지
		int total = selectCountTotal(cate1); // 총 게시물 갯수
		int lastPageNum = 0; // 마지막 페이지 번호
		
		// 페이지 마지막 번호 계산
		if(total % 10 != 0) lastPageNum = (total / 10) + 1;
		else lastPageNum = (total / 10);
		
		// 전체 페이지 게시물 limit 시작값 계산
		if(pg != null) currentPage = Integer.parseInt(pg);
		int limitStart = (currentPage - 1) * 10;
		
		// 페이지 그룹 계산
		int pageGroupCurrent = (int)Math.ceil(currentPage / 5.0);
		int pageGroupStart = (pageGroupCurrent - 1) * 5 + 1;
		int pageGroupEnd = pageGroupCurrent * 5;
		
		if (pageGroupEnd > lastPageNum) pageGroupEnd = lastPageNum;
		
		// 페이지 시작 번호 계산
		int pageStartNum = total - limitStart;
		
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
		
		return limitStart;
	}
	/**
	 * 2022/12/26 최고관리자 정보 가져오기
	 * @author 라성준
	 * @return
	 */
	List<MemberVO> selectTopManager() {
		return dao.selectTopManager();
	}
}