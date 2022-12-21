package kr.co.Kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import kr.co.Kmarket.db.CsSql;
import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsNoticeVO;

public class CsNoticeDAO extends DBCP {
	
	/**
	 * 2022/12/21 - /cs/notice/list 
	 * @author 라성준
	 */
	public List<CsNoticeVO> selectCsNoticeWithCscate1(List<CsCate2VO> vos4){
		List<CsNoticeVO> vos = new ArrayList<>();
		try {
			logger.info("CsNoticeDAO selectCsNoticeListWithCsCae1...");
			conn = getConnection();
			
			for(CsCate2VO vo4 : vos4) {
				psmt = conn.prepareStatement(CsSql.SELECT_CS_NOTICE_LIST_WITH_CS_CATE);
				rs = psmt.executeQuery();
				while(rs.next()) {
					CsNoticeVO vo = new CsNoticeVO();
					vo.setNoticeNo(rs.getInt("noticeNo"));
					vo.setNoticeCate(rs.getInt("noticeCate"));
					vo.setNoticeTitle(rs.getString("noticeTitle"));
					vo.setNoticeContent(rs.getString("noticeContent"));
					vo.setNoticeRdate(rs.getString("noticeRdate"));
					vo.setNoticeRegip(rs.getString("noticeRegip"));
					
					vos.add(vo);
				}
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vos;
	}
}
