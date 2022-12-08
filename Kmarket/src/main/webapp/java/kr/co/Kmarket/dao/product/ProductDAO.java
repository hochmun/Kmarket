package kr.co.Kmarket.dao.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.Kmarket.db.DBCP;
import kr.co.Kmarket.db.Sql;
import kr.co.Kmarket.vo.Cate1VO;
import kr.co.Kmarket.vo.Cate2VO;

public class ProductDAO extends DBCP {
	// create 
	
	// read
	/**
	 * 2022/12/08 - 카테고리 불러오기
	 * @author 심규영
	 * @return c1vos, c2vos - 카테고리1, 카테고리2
	 */
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
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
				c1vos.add(vo);
			}
			
			rs = stmt.executeQuery(Sql.SELECT_CATE2);
			while(rs.next()) {
				Cate2VO vo = new Cate2VO();
				vo.setCate1(rs.getInt(1));
				vo.setCate2(rs.getInt(2));
				vo.setC2Name(rs.getString(3));
				c2vos.add(vo);
			}
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		voss.put("c1vos", c1vos);
		voss.put("c2vos", c2vos);
		return voss;
	}
	
	// upload
	
	// delete
}
