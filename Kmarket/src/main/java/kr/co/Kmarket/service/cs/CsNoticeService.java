package kr.co.Kmarket.service.cs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.cs.CsNoticeDAO;
import kr.co.Kmarket.vo.cs.CsNoticeVO;

public enum CsNoticeService {
	instance;
	
	private CsNoticeDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
	
	/**
	 * 2022/12/23 관리자/메인 => 공지사항 최근 작성순 5개 가져오기
	 * @author 심규영
	 * @return
	 */
	public List<CsNoticeVO> selectCsNoticeListLimit5() {
		return dao.selectCsNoticeListLimit5();
	}
	
	/**
	 * 2022/12/26 notice 게시물 번호로 게시물 정보 불러오기
	 * @author 라성준
	 * @param noticeNo
	 * @return
	 */
	public CsNoticeVO selectCsNoticeWithNoticeNo(String noticeNo) {
		return dao.selectCsNoticeWithNoticeNo(noticeNo);
	}
	
	// upload
	
	// delete
	
	// service
	/**
	 * 2022/12/23 notice 카테고리별 작성글 count
	 * @author 라성준
	 */
	public int selectCountTotal(String cate1) {
		return dao.selectNoticeCountTotal(cate1);
	}
	
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
		
		List<CsNoticeVO> vos = dao.selectNoticeArticles(limitStart, cate1);
		
		req.setAttribute("vos", vos);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
	}
	
	/**
	 * 2022/12/24 관리자/고객센터/공지사항/리스트 현재 페이지 계산
	 * @param p
	 * @return
	 */
	public int NoticeCurrentPage(String p) {
		int currentPage = 1;
		if(p != null) currentPage = Integer.parseInt(p);
		return currentPage;
	}
	
	/**
	 * 2022/12/24 관리자/고객센터/공지사항/리스트 카테고리 값에 따른 총 개시물 갯수
	 * @author 심규영
	 * @param t
	 * @return
	 */
	public int selectCountNoticeWithCate(String t) {
		return dao.selectCountNoticeWithCate(t);
	}
	
	/**
	 * 2022/12/24 관리자/고객센터/공지사항/리스트 - 마지막 페이지 값 리턴
	 * @author 심규영
	 * @param total
	 * @return
	 */
	public int NoticelastPageNum(int total) {
		int lastPageNum = 0;
		if(total % 10 != 0) lastPageNum = (total/10)+1;
		else lastPageNum = (total/10);
		return lastPageNum;
	}
	
	/**
	 * 2022/12/24 관리자/고객센터/공지사항/리스트 - 페이지 정보 가져오기
	 * @author 심규영
	 * @param limitStart
	 * @param t
	 * @return
	 */
	public List<CsNoticeVO> selectNoticeListWithCate(int limitStart, String t) {
		return dao.selectNoticeListWithCate(limitStart, t);
	}
	
}