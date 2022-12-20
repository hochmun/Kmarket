package kr.co.Kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import kr.co.Kmarket.db.CsSql;
import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsFaqVO;

public class CsFaqDAO extends DBCP {
	// create
	
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
			
			for(CsCate2VO vo3 : vos3) {
				psmt = conn.prepareStatement(CsSql.SELECT_CS_FAQ_LIST_WITH_CS_CATE1);
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
			}
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return vos;
	}
	
	// upload
	
	// delete
}
