package kr.co.Kmarket.service.cs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.cs.CsDAO;
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
	 * @param no
	 * @return
	 */
	public CsQnaVO selectQnaArticle(String no) {
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
	
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		if(total % 10 == 0) {
			lastPageNum = (total / 10);
		}else {
			lastPageNum = (total / 10) + 1;
		}
		return lastPageNum;
	}
	
	public int[] getPageGroupNum(int currentPage, int lastPageNum) {
		int pageGroupCurrent = (int)Math.ceil(currentPage / 5.0);
		int pageGroupStart = (pageGroupCurrent -1) * 5 + 1;
		int pageGroupEnd = pageGroupCurrent * 5;
		
		if(pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}
		int[] pageGroup = {pageGroupStart, pageGroupEnd};
		
		return pageGroup;
	}
	
	public int getStartNum(int currentPage) {
		
		return (currentPage -1) * 10;
	}	
	
	public String getC1name(int cate1) {
		
		String c1name = null;
		
		switch(cate1) {
		case 1:
			c1name = "회원";
			break;
		case 2:
			c1name = "쿠폰/이벤트";
			break;
		case 3:
			c1name = "주문/결제";
			break;
		case 4:
			c1name = "배송";
			break;
		case 5:
			c1name = "취소/반품/교환";
			break;
		case 6:
			c1name = "여행/숙박/항공";
			break;
		case 7:
			c1name = "안전거래";
			break;
		}
		return c1name;
	}
}