package kr.co.Kmarket.service.cs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	// create
	
	// read
	/**
	 * 2022/12/21 - notice 작성글 불러오기
	 * author 라성준
	 */
	public CsNoticeVO selectNoticeArticle(String noticeNo) {
		return dao.selectNoticleArticle(noticeNo);
	}
	
	// upload
	
	// delete
	
	// service
	
	/** 페이징 */ 
	
	/**
	 * 2022/12/19 notice 카테고리별 작성글 count
	 * @author 라성준
	 * @param cate1
	 * @return
	 */
	
	public void paing(HttpServletRequest req, String pg, String cate1) {
		int currentPage = Integer.parseInt(pg);
		
		// 전체 게시물 갯수 가져오기
		int total = dao.selectNoticeCountTotal(cate1);
		int lastPageNum = 0; // 마지막 페이지 번호
		
		// 페이지 마지막 번호 계산
		if(total % 10 != 0) lastPageNum = (total / 10) + 1;
		else lastPageNum = (total / 10);
		
		int limitStart = (currentPage - 1) * 10;
		
		// 페이지 그룹 계산
		int pageGroupCurrent = (int)Math.ceil(currentPage / 5.0);
		int pageGroupStart = (pageGroupCurrent - 1) * 5 + 1;
		int pageGroupEnd = pageGroupCurrent * 5;
		
		if (pageGroupEnd > lastPageNum) pageGroupEnd = lastPageNum;
		
		// 페이지 시작 번호 계산
		int pageStartNum = total - limitStart;
		
		//List<CsNoticeVO> vos = dao.selectNoticeArticles(limitStart, cate1);
		
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
	}
}