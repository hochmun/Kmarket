package kr.co.Kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import kr.co.Kmarket.db.CsSql;
import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

public class CsQnaDAO extends DBCP{

	public CsQnaVO selectCsQnaNo(String qnaNo){
		CsQnaVO vo = new CsQnaVO();
		try {
			logger.info("selectCsQnaNo...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_ADMIN_QNA_NO);
			psmt.setString(1, qnaNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setQnaNo(rs.getInt("qnaNo"));
				vo.setQnaCate1(rs.getInt("qnaCate1"));
				vo.setQnaCate2(rs.getInt("qnaCate2"));
				vo.setUid(rs.getString("uid"));
				vo.setQnaTitle(rs.getString("qnaTitle"));
				vo.setQnaContent(rs.getString("qnaContent"));
				vo.setQnaAdminContent(rs.getString("qnaAdminContent"));
				vo.setQnaType(rs.getInt("qnaType"));
				vo.setQnaRegip(rs.getString("qnaRegip"));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	public List<CsQnaVO> selectCsQnaListWithCsCate1(List<CsCate2VO> vos3){
		List<CsQnaVO> vos = new ArrayList<>();
		try {
			logger.info("selectCsQnaListWithCsCate1...");
			conn = getConnection();
			
			for(CsCate2VO vo3 : vos3) {
				psmt = conn.prepareStatement(CsSql.SELECT_ADMIN_QNA_LIST);
				psmt.setInt(1, vo3.getCate1());
				psmt.setInt(2, vo3.getCate2());
				rs = psmt.executeQuery();
				while(rs.next()) {
					CsQnaVO vo = new CsQnaVO();
					vo.setQnaNo(rs.getInt("qnaNo"));
					vo.setQnaCate1(rs.getInt("qnaCate1"));
					vo.setQnaCate2(rs.getInt("qnaCate2"));
					vo.setUid(rs.getString("uid"));
					vo.setQnaTitle(rs.getString("qnaTitle"));
					vo.setQnaContent(rs.getString("qnaContent"));
					vo.setQnaAdminContent(rs.getString("qnaAdminContent"));
					vo.setQnaType(rs.getInt("qnaType"));
					vo.setQnaRegip(rs.getString("qnaRegip"));
					
					vos.add(vo);
				}
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vos;
	}
	
	public List<CsQnaVO> selectCsQnaList(){
		List<CsQnaVO> vos = new ArrayList<>();
		
		try {
			logger.info("selectCsQnaList...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CsSql.SELECT_ADMIN_QNA_LIST_NO);
			while(rs.next()) {
				CsQnaVO vo = new CsQnaVO();
				vo.setQnaNo(rs.getInt("qnaNo"));
				vo.setQnaCate1(rs.getInt("qnaCate1"));
				vo.setQnaCate2(rs.getInt("qnaCate2"));
				vo.setUid(rs.getString("uid"));
				vo.setQnaTitle(rs.getString("qnaTitle"));
				vo.setQnaContent(rs.getString("qnaContent"));
				vo.setQnaAdminContent(rs.getString("qnaAdminContent"));
				vo.setQnaType(rs.getInt("qnaType"));
				vo.setQnaRegip(rs.getString("qnaRegip"));
				vo.setQnaRdate(rs.getString("qnaRdate").substring(2, 10));
				
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
	
	public List<CsQnaVO> selectCsQnaListCate(String cate1, String cate2){
		List<CsQnaVO> vos = new ArrayList<>();
		try {
			logger.info("selectCsQnaListCate...");
			conn = getConnection();
			psmt = conn.prepareStatement(CsSql.SELECT_ADMIN_QNA_LIST_CATE);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			while (rs.next()) {
				CsQnaVO vo = new CsQnaVO();
				vo.setQnaNo(rs.getInt("qnaNo"));
				vo.setQnaCate1(rs.getInt("qnaCate1"));
				vo.setQnaCate2(rs.getInt("qnaCate2"));
				vo.setUid(rs.getString("uid"));
				vo.setQnaTitle(rs.getString("qnaTitle"));
				vo.setQnaContent(rs.getString("qnaContent"));
				vo.setQnaAdminContent(rs.getString("qnaAdminContent"));
				vo.setQnaType(rs.getInt("qnaType"));
				vo.setQnaRegip(rs.getString("qnaRegip"));
				vo.setQnaRdate(rs.getString("qnaRdate").substring(2, 10));
				
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
}
