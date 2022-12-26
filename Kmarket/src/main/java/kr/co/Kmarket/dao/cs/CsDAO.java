package kr.co.Kmarket.dao.cs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.CSS;

import kr.co.Kmarket.db.CsSql;
import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.vo.AdminVO;
import kr.co.Kmarket.vo.MemberVO;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

public class CsDAO extends DBCP{
	
	// create
	/**
	 * 2022/12/19 qna 글 작성
	 * @author 김재준
	 */
	public int insertQnaArticle(CsQnaVO vo) {
		int result = 0;
		try {
			logger.info("insertQnaArticle...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.INSERT_QNA_ARTICLES);
			stmt = conn.createStatement();
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getQnaTitle());
			psmt.setString(3, vo.getQnaContent());
			psmt.setInt(4, vo.getQnaCate1());
			psmt.setInt(5, vo.getQnaCate2());
			psmt.setString(6, vo.getQnaRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(CsSql.SELECT_MAX_NO);
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	// read
	/**
	 * 2022/12/19 qna 작성글 불러오기
	 * @author 김재준
	 */
	public CsQnaVO selectQnaArticle(String qnaNo) {
		CsQnaVO vo = null;
		try {
			logger.info("selectQnaArticle...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_ARTICLE);
			psmt.setString(1, qnaNo);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new CsQnaVO();
				vo.setQnaNo(rs.getInt(1));
				vo.setQnaCate1(rs.getInt(2));
				vo.setQnaCate2(rs.getInt(3));
				vo.setUid(rs.getString(4));
				vo.setQnaTitle(rs.getString(5));
				vo.setQnaContent(rs.getString(6));
				vo.setQnaAdminContent(rs.getString(7));
				vo.setQnaType(rs.getInt(8));
				vo.setQnaRdate(rs.getString(9));
				vo.setQnaRegip(rs.getString(10));
				vo.setCate2Name(rs.getString(11));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	/**
	 * 2022/12/19 qna 작성글 목록 불러오기
	 * @author 김재준
	 */
	public List<CsQnaVO> selectQnaArticles(String cate1, int limitStart){
		List<CsQnaVO> QnaArts = new ArrayList<>();
		try {
			logger.info("selectQnaArticles...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_ARTICLES);
			psmt.setString(1, cate1);
			psmt.setInt(2, limitStart);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsQnaVO QnaArt = new CsQnaVO();
				QnaArt.setQnaNo(rs.getInt(1));
				QnaArt.setQnaCate1(rs.getInt(2));
				QnaArt.setQnaCate2(rs.getInt(3));
				QnaArt.setUid(rs.getString(4));
				QnaArt.setQnaTitle(rs.getString(5));
				QnaArt.setQnaContent(rs.getString(6));
				QnaArt.setQnaAdminContent(rs.getString(7));
				QnaArt.setQnaType(rs.getInt(8));
				QnaArt.setQnaRdate(rs.getString(9));
				QnaArt.setQnaRegip(rs.getString(10));
				QnaArt.setCate2Name(rs.getString(11));
				
				QnaArts.add(QnaArt);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return QnaArts;
	}
	
	/**
	 * 2022/12/19 qna 카테고리별 작성글 count
	 * @author 김재준
	 */
	public int selectCountTotal(String cate1) {
		int total = 0;
		try {
			logger.info("selectCountTotal...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_COUNT_TOTAL);
			psmt.setString(1, cate1);
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
	 * 2022/12/20 카테고리1 정보 불러오기
	 * @return
	 */
	public List<CsCate1VO> selectCsCate1() {
		List<CsCate1VO> vos = new ArrayList<>();
		
		try {
			logger.info("CsDAO selectCsCate1...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSql.SELECT_CS_CATE1);
			while(rs.next()) {
				CsCate1VO vo = new CsCate1VO();
				
				vo.setCate1(rs.getInt("cate1"));
				vo.setCate1Name(rs.getString("cate1Name"));
				
				vos.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return vos;
	}
	
	/**
	 * 2022/12/20 카테고리1 값으로 카테고리 2 정보 가져오기
	 * @author 심규영
	 * @param csCate1
	 * @return
	 */
	public List<CsCate2VO> selectCsCate2(String csCate1) {
		List<CsCate2VO> vos = new ArrayList<>();
		
		try {
			logger.info("CsDAO selectCsCate2...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_CS_CATE2_WITH_CS_CATE1);
			psmt.setString(1, csCate1);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsCate2VO vo = new CsCate2VO();
				vo.setCate1(rs.getInt("cate1"));
				vo.setCate2(rs.getInt("cate2"));
				vo.setCate2Name(rs.getString("cate2Name"));
				vos.add(vo);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return vos;
	}
	
	public CsCate1VO selectCsCate(String cate1) {
		CsCate1VO vos = null;
		try {
			logger.info("CsDAO selectCsCate...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_CS_CATE);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vos = new CsCate1VO();
				vos.setCate1(rs.getInt("cate1"));
				vos.setCate1Name(rs.getString("cate1Name"));
				vos.setCate2(rs.getInt("cate2"));
				vos.setCate2Name(rs.getString("cate2Name"));
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return vos;
	}
	
	/**
	 * 2022/12/23 관리자/메인 쇼핑몰 운영 현황
	 * @author 심규영
	 * @return
	 */
	public AdminVO selectAll() {
		AdminVO vo = new AdminVO();
		try {
			logger.info("CsDAO selectAll...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSql.SELECT_ALL_COUNT);
			if(rs.next()) {
				vo.setCountOrdNo(rs.getInt("countOrdNo"));
				vo.setCountOrdNoDay(rs.getInt("countOrdNoDay"));
				vo.setCountOrdNoWeek(rs.getInt("countOrdNoWeek"));
				vo.setCountOrdNoMonth(rs.getInt("countOrdNoMonth"));
				vo.setSumOrdTotPrice(rs.getInt("sumOrdTotPrice"));
				vo.setSumOrdTotPriceDay(rs.getInt("sumOrdTotPriceDay"));
				vo.setSumOrdTotPriceWeek(rs.getInt("sumOrdTotPriceWeek"));
				vo.setSumOrdTotPriceMonth(rs.getInt("sumOrdTotPriceMonth"));
				vo.setCountMember(rs.getInt("countMember"));
				vo.setCountMemberDay(rs.getInt("countMemberDay"));
				vo.setCountMemberWeek(rs.getInt("countMemberWeek"));
				vo.setCountMemberMonth(rs.getInt("countMemberMonth"));
				vo.setCountProductRdateDay(rs.getInt("countProductRdateDay"));
				vo.setCountProductRdateWeek(rs.getInt("countProductRdateWeek"));
				vo.setCountProductRdateMonth(rs.getInt("countProductRdateMonth"));
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	public List<MemberVO> selectTopManager() {
		List<MemberVO> tvo = new ArrayList<>();
		
		try {
			logger.info("CsDAO selectTopManager...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSql.SELECT_CS_TOPMANAGER);
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setCeo(rs.getString("memberCeo"));
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return tvo;
	}
	// delete
	
	
}
