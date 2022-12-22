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
				logger.info("cn1");
				vo = new CsNoticeVO();
				logger.info("cn2");
				vo.setNoticeNo(rs.getInt(1));
				logger.info("cn3");
				vo.setNoticeCate(rs.getInt(2));
				logger.info("cn4");
				vo.setNoticeTitle(rs.getString(3));
				logger.info("cn5");
				vo.setNoticeContent(rs.getString(4));
				logger.info("cn6");
				vo.setNoticeRdate(rs.getString(5));
				logger.info("cn7");
				vo.setNoticeRegip(rs.getString(6));
				
			}		
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}

	public int selectNoticeCountTotal(String cate1) {
		int total = 0;
		
		try {
			logger.info("CsNoticeDAO selectNoticeCountTotal..");
			conn = getConnection();
			
			if(cate1.equals("0")) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(CsSql.SELECT_NOTICE_COUNT_TOTAL);
				if(rs.next()) {
					total = rs.getInt(1);
				}
			} else {
				psmt = conn.prepareStatement(CsSql.SELECT_NOTICE_COUNT_TOTAL_WITH_CATE);
				psmt.setString(1, cate1);
				rs = psmt.executeQuery();
				if(rs.next()) {
					total = rs.getInt(1);
				}
			}
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	
	// upload
	
	// delete
}
