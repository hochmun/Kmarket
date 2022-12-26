package kr.co.Kmarket.service.cs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

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
	
	public int selectCountQnaTotal(String qnaCate1, String qnaCate2) {
		return dao.selectCountQnaTotal(qnaCate1, qnaCate2);
	}
	
	public int selectCountQnaTotalAll() {
		return dao.selectCountQnaTotalAll();
	}
	public int selectCountQnaTotalCate1AndCate2(String cate1, String cate2) {
		return dao.selectCountQnaTotalCate1AndCate2(cate1, cate2);
	}
	
	public List<CsQnaVO> selectCsQnaListWithCsCate1(List<CsCate2VO> vos3){
		return dao.selectCsQnaListWithCsCate1(vos3);
	}
	
	public List<CsQnaVO> selectCsQnaList(int limitStart, String cate1, String cate2){
		return dao.selectCsQnaList(limitStart,cate1, cate2);
	}
	
	public List<CsQnaVO> selectCsQnaListCate(String cate1, String cate2, int limitStart){
		return dao.selectCsQnaListCate(cate1, cate2, limitStart);
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
	
	public int boardPaging(HttpServletRequest req, String pg, String cate1, String cate2) {
		int currentPage = 1; // 현재 페이지
		int total = selectCountQnaTotalCate1AndCate2(cate1, cate2); // 총 게시물 갯수
		int lastPageNum = 0; // 마지막 페이지 번호
		
		// 페이지 마지막 번호 계산
		if(total % 10 != 0) lastPageNum = (total/10)+1;
		else lastPageNum = (total/10);
		
		// 전체 페이지 게시물 limit 시작값 계산
		if(pg != null) currentPage = Integer.parseInt(pg);
		int limitStart = (currentPage - 1) * 10;
		
		// 페이지 그룹 계산
		int pageGroupCurrent = (int)Math.ceil(currentPage/10.0);
		int pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
		int pageGroupEnd = pageGroupCurrent * 10;
		
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
	
	public int boardPaging2(HttpServletRequest req, String pg, JsonObject json, String cate1, String cate2) {
		int currentPage = 1; // 현재 페이지
		int total = selectCountQnaTotalCate1AndCate2(cate1, cate2); // 총 게시물 갯수
		int lastPageNum = 0; // 마지막 페이지 번호
		
		// 페이지 마지막 번호 계산
		if(total % 10 != 0) lastPageNum = (total/10)+1;
		else lastPageNum = (total/10);
		
		// 전체 페이지 게시물 limit 시작값 계산
		if(pg != null) currentPage = Integer.parseInt(pg);
		int limitStart = (currentPage - 1) * 10;
		
		// 페이지 그룹 계산
		int pageGroupCurrent = (int)Math.ceil(currentPage/10.0);
		int pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
		int pageGroupEnd = pageGroupCurrent * 10;
		
		if (pageGroupEnd > lastPageNum) pageGroupEnd = lastPageNum;
		
		// 페이지 시작 번호 계산
		int pageStartNum = total - limitStart;
		
		json.addProperty("lastPageNum", lastPageNum);
		json.addProperty("currentPage", currentPage);
		json.addProperty("pageGroupCurrent", pageGroupCurrent);
		json.addProperty("pageGroupStart", pageGroupStart);
		json.addProperty("pageGroupEnd", pageGroupEnd);
		json.addProperty("pageStartNum", pageStartNum);
		
		return limitStart;
	}
}
