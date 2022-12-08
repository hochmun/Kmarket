package kr.co.Kmarket.dao.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.db.Sql;

public class ProductDAO extends DBCP {
	// create 
	
	// read
	public Map<String, Object> selectcate() {
		Map<String, Object> voss = new HashMap<>();
		List<Cate1VO> c1vos = new ArrayList<>();
		List<Cate2VO> c2vos = new ArrayList<>();
		try {
			logger.info("selectcate... 카테고리 불러오기");
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(Sql.SELECT_CATE1);
			while(rs.next()) {
				Cate1VO vo = new Cate1VO();
				vo.setCate1(rs.getString(1));
				vo.setC1Name(rs.getString(2));
				c1vos.add(vo);
			}
			
			rs = stmt.executeQuery(Sql.SELECT_CATE2);
			while(rs.next()) {
				Cate2VO vo = new Cate2VO();
				vo.setCate1(rs.get)
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
