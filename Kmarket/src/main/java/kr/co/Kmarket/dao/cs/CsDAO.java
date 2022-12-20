package kr.co.Kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import kr.co.Kmarket.db.CsSql;
import kr.co.Kmarket.db.DBCP;
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
	public List<CsQnaVO> selectQnaArticles(int cate1, int start){
		List<CsQnaVO> QnaArts = new ArrayList<>();
		try {
			logger.info("selectQnaArticles...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_ARTICLES);
			psmt.setInt(1, cate1);
			psmt.setInt(2, start);
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
	public int selectCountTotal(int cate1) {
		int total = 0;
		try {
			logger.info("selectCountTotal...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_COUNT_TOTAL);
			psmt.setInt(1, cate1);
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
	
	
	// delete
}
