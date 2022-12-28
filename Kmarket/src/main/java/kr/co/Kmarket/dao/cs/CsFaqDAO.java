package kr.co.Kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import kr.co.Kmarket.db.CsSql;
import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsFaqVO;

public class CsFaqDAO extends DBCP {
	// create
	/**
	 * 2022/12/22 자주하는 질문 게시물 작성
	 * @author 심규영
	 * @param vo
	 * @return
	 */
	public int insertCsFaq(CsFaqVO vo) {
		int result = 0;
		
		try {
			logger.info("CsFaqDAO insertCsFaq...");
			conn = getConnection();
			
			psmt = conn.prepareStatement(CsSql.INSERT_CS_FAQ);
			psmt.setInt(1, vo.getFaqCate1());
			psmt.setInt(2, vo.getFaqCate2());
			psmt.setString(3, vo.getFaqTitle());
			psmt.setString(4, vo.getFaqContent());
			psmt.setString(5, vo.getFaqRegip());

			result = psmt.executeUpdate();
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return result;
	}
	
	// read
	/**
	 * 2022/12/20 - /cs/faq/list - cate1값으로 리스트 불러오기
	 * @param CsCate1
	 * @return
	 */
	public List<CsFaqVO> selectCsFaqListWithCsCate1(List<CsCate2VO> vos3) {
		List<CsFaqVO> vos = new ArrayList<>();
		try {
			logger.info("CsFaqDAO selectCsFaqListWithCsCate1...");
			conn = getConnection();
			
			psmt = conn.prepareStatement(CsSql.SELECT_CS_FAQ_LIST_WITH_CS_CATE1);
			
			for(CsCate2VO vo3 : vos3) {
				psmt.setInt(1, vo3.getCate1());
				psmt.setInt(2, vo3.getCate2());
				rs = psmt.executeQuery();
				while(rs.next()) {
					CsFaqVO vo = new CsFaqVO();
					vo.setFaqNo(rs.getInt("faqNo"));
					vo.setFaqCate1(rs.getInt("faqCate1"));
					vo.setFaqCate2(rs.getInt("faqCate2"));
					vo.setFaqTitle(rs.getString("faqTitle"));
					vo.setFaqContent(rs.getString("faqContent"));
					vo.setFaqRegip(rs.getString("faqRegip"));
					
					vos.add(vo);
				}
				psmt.clearParameters();
			}
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vos;
	}
	
	/**
	 * 2022/12/21 자주묻는 질문 게시물 번호로 게시물 정보 불러오기
	 * @author 심규영
	 * @param faqNo
	 * @return
	 */
	public CsFaqVO selectCsFaqWithFaqNo(String faqNo) {
		CsFaqVO vo = new CsFaqVO();
		
		try {
			logger.info("CsFaqDAO selectCsFaqWithFaqNo...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_CS_FAQ_WITH_FAQ_NO);
			psmt.setString(1, faqNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setFaqNo(rs.getInt("faqNo"));
				vo.setFaqCate1(rs.getInt("faqCate1"));
				vo.setFaqCate2(rs.getInt("faqCate2"));
				vo.setFaqTitle(rs.getString("faqTitle"));
				vo.setFaqContent(rs.getString("faqContent"));
				vo.setFaqRegip(rs.getString("faqRegip"));
				
				vo.setCate1Name(rs.getString("cate1Name"));
				vo.setCate2Name(rs.getString("cate2Name"));
				
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return vo;
	}

	/**
	 * 2022/12/21 관리자 자주묻는 질문 처음 접근시 게시물 상위 10개 불러오기
	 * @author 심규영
	 * @return
	 */
	public List<CsFaqVO> selectCsFaqListLimit10() {
		List<CsFaqVO> vos = new ArrayList<>();
		
		try {
			logger.info("CsFaqDAO selectCsFaqListLimit10...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSql.SELECT_CS_FAQ_LIST_LIMIT10);
			while(rs.next()) {
				CsFaqVO vo = new CsFaqVO();
				vo.setFaqNo(rs.getInt("faqNo"));
				vo.setFaqCate1(rs.getInt("faqCate1"));
				vo.setFaqCate2(rs.getInt("faqCate2"));
				vo.setFaqTitle(rs.getString("faqTitle"));
				vo.setFaqContent(rs.getString("faqContent"));
				vo.setFaqRegip(rs.getString("faqRegip"));
				vo.setFaqHit(rs.getInt("faqHit"));
				vo.setFaqRdate(rs.getString("faqRdate").substring(2, 10));
				
				vo.setCate1Name(rs.getString("cate1Name"));
				vo.setCate2Name(rs.getString("cate2Name"));
				
				vos.add(vo);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return vos;
	}
	
	/**
	 * 2022/12/21 관리자 카테1 과 카테2 값으로 상위 10개 게시물 가져오기
	 * @author 심규영
	 * @param cate1
	 * @param cate2
	 * @return
	 */
	public List<CsFaqVO> selectCsFaqListWithCate1AndCate2(String cate1, String cate2) {
		List<CsFaqVO> vos = new ArrayList<>();
		
		try {
			logger.info("CsFaqDAO selectCsFaqListWithCate1AndCate2...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_CS_FAQ_LIST_WITH_CATE1_AND_CATE2);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsFaqVO vo = new CsFaqVO();
				
				vo.setFaqNo(rs.getInt("faqNo"));
				vo.setFaqCate1(rs.getInt("faqCate1"));
				vo.setFaqCate2(rs.getInt("faqCate2"));
				vo.setFaqTitle(rs.getString("faqTitle"));
				vo.setFaqContent(rs.getString("faqContent"));
				vo.setFaqRegip(rs.getString("faqRegip"));
				vo.setFaqHit(rs.getInt("faqHit"));
				vo.setFaqRdate(rs.getString("faqRdate").substring(2, 10));
				
				vo.setCate1Name(rs.getString("cate1Name"));
				vo.setCate2Name(rs.getString("cate2Name"));
				
				vos.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return vos;
	}
	
	// upload
	/**
	 * 2022/12/22 자주묻는 질문 수정
	 * @author 심규영
	 * @param vo
	 * @return
	 */
	public int updateCsFaq(CsFaqVO vo) {
		int result = 0;
		
		try {
			logger.info("CsFaqDAO updateCsFaq...");
			conn = getConnection();
			
			psmt = conn.prepareStatement(CsSql.UPDATE_CS_FAQ);
			
			psmt.setInt(1, vo.getFaqCate1());
			psmt.setInt(2, vo.getFaqCate2());
			psmt.setString(3, vo.getFaqTitle());
			psmt.setString(4, vo.getFaqContent());
			psmt.setString(5, vo.getFaqRegip());
			psmt.setInt(6, vo.getFaqNo());
			
			result = psmt.executeUpdate();
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return result;
	}
	
	// delete
	/**
	 * 2022/12/22 자주묻는 질문 삭제 기능 개별, 전체 통합
	 * @author 심규영
	 * @param arrays
	 * @return
	 */
	public int deleteCsFaqNoWithFaqNo(String[] arrays) {
		int result = 0;
		
		try {
			logger.info("CsFaqDAO deleteCsFaqNoWithFaqNo...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.DELETE_CS_FAQ_WITH_FAQNO);
			
			for (String faqNo : arrays) {
				psmt.setString(1, faqNo);
				psmt.addBatch();
				psmt.clearParameters();
			}
			
			result = psmt.executeBatch()[0];
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return result;
	}
	
}
