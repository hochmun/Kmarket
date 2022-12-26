package kr.co.Kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import kr.co.Kmarket.db.CsSql;
import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsNoticeVO;

public class CsNoticeDAO extends DBCP {
	// create
	
	// read
	/**
	 * 2022/12/21 - /cs/notice/list 
	 * @author 라성준
	 */
	public CsNoticeVO selectNoticleArticle(String noticeNo){
		CsNoticeVO vo = null;
		try {
			logger.info("CsNoticeDAO selectCsNoticeList...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_NOTICE_ARTICLE);
			psmt.setString(1, noticeNo);
			rs = psmt.executeQuery();	
			
			while(rs.next()) {
				vo = new CsNoticeVO();
				vo.setNoticeNo(rs.getInt(1));
				vo.setNoticeCate(rs.getInt(2));
				vo.setNoticeTitle(rs.getString(3));
				vo.setNoticeContent(rs.getString(4));
				vo.setNoticeRdate(rs.getString(5));
				vo.setNoticeRegip(rs.getString(6));
				
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	/**
	 * 2022/12/23 notice 작성글 목록 불러오기
	 * @author 라성준
	 */
	public List<CsNoticeVO> selectNoticeArticles(int limitStart, String cate1){
		List<CsNoticeVO> NoticeArts = new ArrayList<>();
		try {
			logger.info("selectNoticeArticles...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_NOTICE_ARTICLES);
			psmt.setString(1, cate1);
			psmt.setInt(2, limitStart);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsNoticeVO NoticeArt = new CsNoticeVO();
				NoticeArt.setNoticeNo(rs.getInt(1));
				NoticeArt.setNoticeCate(rs.getInt(2));
				NoticeArt.setNoticeTitle(rs.getString(3));
				NoticeArt.setNoticeContent(rs.getString(4));
				NoticeArt.setNoticeRdate(rs.getString(5).substring(2,10));
				NoticeArt.setNoticeRegip(rs.getString(6));
			
				NoticeArts.add(NoticeArt);
				
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return NoticeArts;
	}

	public int selectNoticeCountTotal(String cate1) {
		int total = 0;
		
		try {
			logger.info("CsNoticeDAO selectNoticeCountTotal..");
			conn = getConnection();
			
			psmt = conn.prepareStatement(CsSql.SELECT_NOTICE_COUNT_TOTAL_WITH_CATE);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	
	/**
	 * 2022/12/23 - 관리자/메인 => 공지사항 최근 작성순 5개 가져오기
	 * @author 심규영
	 * @return
	 */
	public List<CsNoticeVO> selectCsNoticeListLimit5() {
		List<CsNoticeVO> vos = new ArrayList<>();
		
		try {
			logger.info("CsNoticeDAO selectCsNoticeListLimit5...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSql.SELECT_CS_NOTICE_LIST_LIMIT5);
			while(rs.next()) {
				CsNoticeVO vo = new CsNoticeVO();
				vo.setNoticeNo(rs.getInt("noticeNo"));
				vo.setNoticeCate(rs.getInt("noticeCate"));
				vo.setNoticeTitle(rs.getString("noticeTitle"));
				vo.setNoticeContent(rs.getString("noticeContent"));
				vo.setNoticeRdate(rs.getString("noticeRdate").substring(2, 16));
				vo.setNoticeRegip(rs.getString("noticeRegip"));
				vos.add(vo);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return vos;
	}
	
	/**
	 * 2022/12/24 - 관리자/고객센터/공지사항 리스트 카테고리별 게시물 갯수 가져오기
	 * @author 심규영
	 * @param t
	 * @return
	 */
	public int selectCountNoticeWithCate(String t) {
		int total = 0;
		String ta = "%"+t+"%";
		try {
			logger.info("CsNoticeDAO selectCountNoticeWithCate...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_NOTICE_COUNT_TOTAL_WITH_CATE);
			psmt.setString(1, ta);
			rs = psmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	
	/**
	 * 2022/12/24 - 관리자/고객센터/공지사항 리스트 카테고리별 게시물 10개 가져오기
	 * @param limitStart
	 * @param t
	 * @return
	 */
	public List<CsNoticeVO> selectNoticeListWithCate(int limitStart, String t) {
		List<CsNoticeVO> vos = new ArrayList<>();
		String ta = "%"+t+"%";
		try {
			logger.info("CsNoticeDAO selectNoticeListWithCate...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_NOTICE_LIST_WITH_CATE);
			psmt.setString(1, ta);
			psmt.setInt(2, limitStart);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsNoticeVO vo = new CsNoticeVO();
				vo.setNoticeNo(rs.getInt("noticeNo"));
				vo.setNoticeCate(rs.getInt("noticeCate"));
				vo.setNoticeTitle(rs.getString("noticeTitle"));
				vo.setNoticeRdate(rs.getString("noticeRdate").substring(2, 10));
				vo.setNoticeHit(rs.getInt("noticeHit"));
				vos.add(vo);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vos;
	}

	public CsNoticeVO selectCsNoticeWithNoticeNo(String noticeNo) {
		CsNoticeVO vo = new CsNoticeVO();
		
		try {
			logger.info("CsNoticeDAO selectCsNoticeWithNoticeNo...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_CS_NOTICE_WITH_NOTICE_NO);
			psmt.setString(1, noticeNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setNoticeNo(rs.getInt("noticeNo"));
				vo.setNoticeCate(rs.getInt("noticeCate"));
				vo.setNoticeTitle(rs.getString("noticeTitle"));
				vo.setNoticeContent(rs.getString("noticeContent"));
				vo.setNoticeRegip(rs.getString("noticeRegip"));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	// upload
	
	// delete
}
