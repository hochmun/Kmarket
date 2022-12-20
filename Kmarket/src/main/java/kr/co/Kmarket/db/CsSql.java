package kr.co.Kmarket.db;

public class CsSql {
	/** cate */ 
	/** faq */ 
	/** notice */ 
	/** qna */ 
	
	//qna 카테고리별 작성글 count 
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`qnaNo`) FROM `km_cs_qna` WHERE `qnaCate1` = ?";
	
	// qna 카테고리 작성글 list 가져오기 
	public static final String SELECT_ARTICLES = "SELECT a.*, c.cate2Name FROM `km_cs_qna` AS a "
												+ "JOIN `km_cs_cate1` AS b "
												+ "ON a.qnaCate1 = b.cate1 "
												+ "JOIN `km_cs_cate2` AS c "
												+ "ON b.cate1 = c.cate1 AND a.qnaCate2 = c.cate2 "
												+ "WHERE b.cate1 = ? "
												+ "ORDER BY `qnaNo` DESC LIMIT ?, 10";
	// qna 글 작성
	public static final String INSERT_QNA_ARTICLES = "INSERT INTO `km_cs_qna` SET "
													+ "`uid` = ?, "
													+ "`qnaTitle` = ?, "
													+ "`qnaContent` = ?, "
													+ "`qnaCate1` = ?, "
													+ "`qnaCate2` = ?, "
													+ "`qnaRdate` = NOW(), "
													+ "`qnaRegip` = ?";
	// qna 작성글 가져오기
	public static final String SELECT_ARTICLE = "SELECT a.*, c.cate2Name FROM `km_cs_qna` AS a "
												+ "JOIN `km_cs_cate1` AS b "
												+ "ON a.qnaCate1 = b.cate1 "
												+ "JOIN `km_cs_cate2` AS c "
												+ "ON b.cate1 = c.cate1 AND a.qnaCate2 = c.cate2 "
												+ "WHERE `qnaNo` = ?";
	
	// qna 최신글 번호
	public static final String SELECT_MAX_NO = "SELECT MAX(`qnaNo`) FROM `km_cs_qna`";
	
	public static final String SELECT_CS_CATE = "SELECT a.*, b.cate2, b.cate2Name FROM `km_cs_cate1` AS a "
												+ "LEFT JOIN `km_cs_cate2` AS b ON a.cate1 = b.cate1 "
												+ "WHERE a.cate1 = ? AND b.cate2 = ?"; 
	
	
}
