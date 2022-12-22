package kr.co.Kmarket.db;

public class CsSql {
	/** cate */ 
	
	// csCate1 정보 가져오기
	public static final String SELECT_CS_CATE1 = 
			"SELECT * FROM `km_cs_cate1`";
	
	// Cate1 값으로 csCate2 정보 가져오기
	public static final String SELECT_CS_CATE2_WITH_CS_CATE1 = 
			"SELECT * FROM `km_cs_cate2` WHERE `cate1`=?";
	
	/** faq */ 
	
	// faq 리스트 가져오기 cate1과 cate2 값으로 10개씩
	public static final String SELECT_CS_FAQ_LIST_WITH_CS_CATE1 = 
			"SELECT * FROM `km_cs_faq` WHERE `faqCate1`=? AND `faqCate2`=? LIMIT 10";
	
	/** faqNo로 게시물 정보 가져오기 */
	public static final String SELECT_CS_FAQ_WITH_FAQ_NO = 
			"SELECT * FROM `km_cs_faq` WHERE `faqNo`=?";
	
	/** 관리자 자주묻는 질문 처음 접근시 조회수 상위 10개 가져오기 */
	public static final String SELECT_CS_FAQ_LIST_LIMIT10 = 
			"SELECT "
			+ "	f.*, "
			+ "	c2.cate2Name, "
			+ "	c1.cate1Name "
			+ "FROM `km_cs_faq` AS f "
			+ "JOIN `km_cs_cate2` AS c2 ON f.faqCate2 = c2.cate2 AND f.faqCate1 = c2.cate1 "
			+ "JOIN `km_cs_cate1` AS c1 ON f.faqCate1 = c1.cate1 "
			+ "ORDER BY `faqHit` DESC LIMIT 10";
	
	/** 관리자 자주묻는 질문 카테1값과 카테2값에 해당하는 상위 10개 가져오기 */
	public static final String SELECT_CS_FAQ_LIST_WITH_CATE1_AND_CATE2 = 
			"SELECT "
			+ "	f.*, "
			+ "	c2.cate2Name, "
			+ "	c1.cate1Name "
			+ "FROM `km_cs_faq` AS f "
			+ "JOIN `km_cs_cate2` AS c2 ON f.faqCate2 = c2.cate2 AND f.faqCate1 = c2.cate1 "
			+ "JOIN `km_cs_cate1` AS c1 ON f.faqCate1 = c1.cate1 "
			+ "WHERE f.faqCate1 = ? AND f.faqCate2 = ? "
			+ "ORDER BY `faqHit` DESC LIMIT 10";
	
	/** notice */ 
	public static final String SELECT_CS_NOTICE_LIST_WITH_CS_CATE =
			"SELECT * FROM `km_cs_notice` WHERE `NoticeCate`=? LIMIT 10";
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
												+ "WHERE a.cate1 = ?"; 
	
	/* ADMIN QNA  */
	
	public static final String SELECT_ADMIN_QNA_NO = "SELECT * FROM `km_cs_qna` WHERE `qnaNo` = ?";
	
	// admin qna 해당 카테고리 전체 list 가져오기
	public static final String SELECT_ADMIN_QNA_LIST = "SELECT * FROM `km_cs_qna` "
														+ "WHERE `qnaCate1` = ? AND `qnaCate2` = ? LIMIT 10";
	
	// admin qna 작성글 전체 list 번호순으로 가져오기
	public static final String SELECT_ADMIN_QNA_LIST_NO = "SELECT a.*, b.cate1Name, c.cate2Name FROM `km_cs_qna` AS a "
														+ "JOIN `km_cs_cate1` AS b "
														+ "ON a.qnaCate1 = b.cate1 "
														+ "JOIN `km_cs_cate2` AS c "
														+ "ON b.cate1 = c.cate1 AND a.qnaCate2 = c.cate2 "
														+ "ORDER BY `qnaNo` DESC LIMIT 10";
	
	// admin qna 해당 카테고리 작성글 list 번호순 가져오기 
	public static final String SELECT_ADMIN_QNA_LIST_CATE = "SELECT a.*, b.cate1Name, c.cate2Name FROM `km_cs_qna` AS a "
															+ "JOIN `km_cs_cate1` AS b "
															+ "ON a.qnaCate1 = b.cate1 "
															+ "JOIN `km_cs_cate2` AS c "
															+ "ON b.cate1 = c.cate1 AND a.qnaCate2 = c.cate2 "
															+ "WHERE b.cate1 = ? AND c.cate2 = ? "
															+ "ORDER BY `qnaNo` DESC LIMIT 10";
}
