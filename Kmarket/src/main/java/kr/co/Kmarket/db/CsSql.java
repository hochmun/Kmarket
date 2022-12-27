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
	
	public static final String INSERT_CS_FAQ = 
			"INSERT INTO `km_cs_faq` SET "
			+ "`faqCate1`=?, "
			+ "`faqCate2`=?, "
			+ "`faqTitle`=?, "
			+ "`faqContent`=?, "
			+ "`faqRegip`=?, "
			+ "`faqRdate`=NOW()";
	
	// faq 리스트 가져오기 cate1과 cate2 값으로 10개씩
	public static final String SELECT_CS_FAQ_LIST_WITH_CS_CATE1 = 
			"SELECT * FROM `km_cs_faq` WHERE `faqCate1`=? AND `faqCate2`=? LIMIT 10";
	
	/** faqNo로 게시물 정보 가져오기 */
	public static final String SELECT_CS_FAQ_WITH_FAQ_NO = 
			"SELECT "
			+ "	f.*,"
			+ "	c2.cate2Name,"
			+ "	c1.cate1Name "
			+ "FROM `km_cs_faq` AS f "
			+ "JOIN `km_cs_cate2` AS c2 ON f.faqCate2 = c2.cate2 AND f.faqCate1 = c2.cate1 "
			+ "JOIN `km_cs_cate1` AS c1 ON f.faqCate1 = c1.cate1 "
			+ "WHERE `faqNo`=?";
	
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
	
	public static final String UPDATE_CS_FAQ = 
			"UPDATE `km_cs_faq` SET "
			+ "`faqCate1`=?, "
			+ "`faqCate2`=?, "
			+ "`faqTitle`=?, "
			+ "`faqContent`=?, "
			+ "`faqRegip`=?, "
			+ "`faqRdate`=NOW() "
			+ "WHERE `faqNo`=?";
	
	public static final String DELETE_CS_FAQ_WITH_FAQNO = 
			"DELETE FROM `km_cs_faq` WHERE `faqNo`=?";
	
	/** notice */ 
	
	/** 2022/12/26 심규영 관리자/고객센터/공지사항/글쓰기 */
	public static final String INSERT_NOTICE = 
			"INSERT INTO `km_cs_notice` SET "
			+ "`noticeCate`=?, "
			+ "`noticeTitle`=?, "
			+ "`noticeContent`=?, "
			+ "`noticeRdate`=NOW(), "
			+ "`noticeRegip`=? ";
	
	// notice 작성글 가져오기
	public static final String SELECT_NOTICE_ARTICLE = "SELECT * FROM `km_cs_notice` ORDER BY `noticeNo` DESC LIMIT 10";
	
	/** 2022/12/26 심규영 공지사항 게시물 불러오기 */
	public static final String SELECT_NOTICE_WITH_NOTICENO = "SELECT * FROM `km_cs_notice` WHERE `noticeNo` = ?";
	
	// notice 카테고리 작성글 list 가져오기 
	public static final String SELECT_NOTICE_ARTICLES = "SELECT a.*, c.cate2Name FROM `km_cs_notice` AS a "
												+ "JOIN `km_cs_cate1` AS b "
												+ "ON a.noticeCate = b.cate1 "
												+ "JOIN `km_cs_cate2` AS c "
												+ "ON b.cate1 = c.cate1 AND a.noticeCate = c.cate2 "
												+ "WHERE b.cate1 LIKE ? "
												+ "ORDER BY `noticeNo` DESC LIMIT ?, 10";	
	
	// noticeNo로 게시물 정보 가져오기 
	public static final String SELECT_CS_NOTICE_WITH_NOTICE_NO = "SELECT * FROM `km_cs_notice` "
																+ "WHERE `noticeNo`=? ";
											
	
	/** admin/index 공지사항 최근 작성 날짜 기준으로 5개 가져오기  */
	public static final String SELECT_CS_NOTICE_LIST_LIMIT5 = 
			"SELECT * FROM `km_cs_notice` ORDER BY `noticeRdate` DESC LIMIT 5";
	
	//notice 카테고리별 작성글 count 
	public static final String SELECT_NOTICE_COUNT_TOTAL_WITH_CATE = "SELECT COUNT(`noticeNo`) FROM `km_cs_notice` WHERE `noticeCate` LIKE ?";
	public static final String SELECT_NOTICE_COUNT_TOTAL = "SELECT COUNT(`noticeNo`) FROM `km_cs_notice`";
	
	public static final String SELECT_NOTICE_LIST_WITH_CATE = 
			"SELECT "
			+ "`noticeNo`, "
			+ "`noticeCate`, "
			+ "`noticeTitle`, "
			+ "`noticeRdate`, "
			+ "`noticeHit` "
			+ "FROM `km_cs_notice` WHERE `noticeCate` LIKE ? "
			+ "ORDER BY `noticeNo` DESC LIMIT ?, 10";
	
	public static final String UPDATE_CS_NOTICE = 
			"UPDATE `km_cs_notice` SET "
			+ "`noticeCate`=?, "
			+ "`noticeTitle`=?, "
			+ "`noticeContent`=?, "
			+ "`noticeRegip`=?, "
			+ "`noticeRdate`=NOW() "
			+ "WHERE `noticeNo`=?";
	
	public static final String DELETE_CS_NOTICE_WITH_NOTICENO = 
			"DELETE FROM `km_cs_notice` WHERE `noticeNo`=?";
	
	/** qna */ 
	
	//qna 카테고리별 작성글 count 
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`qnaNo`) FROM `km_cs_qna` WHERE `qnaCate1` = ?";
	
	public static final String SELECT_COUNT_TOTAL_ALL = "SELECT COUNT(`qnaNo`) FROM `km_cs_qna`";
	public static final String SELECT_COUNT_TOTAL_CATE1_AND_CATE2 = "SELECT COUNT(`qnaNo`) FROM `km_cs_qna` WHERE qnaCate1 LIKE ? AND qnaCate2 LIKE ?";
	
	public static final String SELECT_COUNT_TOTAL_ADMIN = "SELECT COUNT(`qnaNo`) FROM `km_cs_qna` WHERE `qnaCate1` = ? AND `qnaCate2` = ?";
	
	
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
	
	/** 관리자/메인 문의사항 최신순 5개 가져오기 */
	public static final String SELECT_CS_QNA_LIST_LIMIT5 = 
			"SELECT "
			+ "`qnaTitle`, "
			+ "`qnaRdate`, "
			+ "`qnaNo`, "
			+ "`qnaCate1`, "
			+ "`uid` "
			+ " FROM `km_cs_qna` ORDER BY `qnaRdate` DESC LIMIT 5";
	
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
														+ "Where a.qnaCate1 LIKE ? AND a.qnaCate2 LIKE ? "
														+ "ORDER BY `qnaNo` DESC LIMIT ?, 10";
	
	// admin qna 해당 카테고리 작성글 list 번호순 가져오기 
	public static final String SELECT_ADMIN_QNA_LIST_CATE = "SELECT a.*, b.cate1Name, c.cate2Name FROM `km_cs_qna` AS a "
															+ "JOIN `km_cs_cate1` AS b "
															+ "ON a.qnaCate1 = b.cate1 "
															+ "JOIN `km_cs_cate2` AS c "
															+ "ON b.cate1 = c.cate1 AND a.qnaCate2 = c.cate2 "
															+ "WHERE b.cate1 LIKE ? AND c.cate2 LIKE ? "
															+ "ORDER BY `qnaNo` DESC LIMIT ?, 10";
	
	public static final String SELECT_ADMIN_QNA_ARTICLE_NO = "SELECT a.*, b.cate1Name, c.cate2Name FROM `km_cs_qna` AS a "
															+ "JOIN `km_cs_cate1` AS b "
															+ "ON a.qnaCate1 = b.cate1 "
															+ "JOIN `km_cs_cate2` AS c "
															+ "ON b.cate1 = c.cate1 AND a.qnaCate2 = c.cate2 "
															+ "WHERE `qnaNo` = ?";
	
	// admin 이름 가져오기
	public static final String SELECT_CS_TOPMANAGER = "SELECT * FROM `km_member` WHERE `ceo` = ?";
	
	// admin qna 답변
	public static final String UPDATE_QNA_ADMIN_CONTENT = "UPDATE `km_cs_qna` SET "
														+ "`qnaAdminContent` = ?, "
														+ "`qnaType` = 2 "
														+ "WHERE `qnaNo` = ?";
	
	// admin qna 문의글 삭제
	public static final String DELETE_QNA_ARTICLE = "DELETE FROM `km_cs_qna` WHERE `qnaNo` = ?";

	/* 관리자/메인 */
	/** 관리자 메인 운영현황 불러오기 */
	public static final String SELECT_ALL_COUNT = 
			"SELECT "
			+ "	COUNT(`ordNo`) AS countOrdNo,"
			+ "	(SELECT COUNT(`ordNo`) "
			+ "		FROM `km_product_order` WHERE `ordDate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 DAY ) AND NOW() ) AS countOrdNoDay,"
			+ "	(SELECT COUNT(`ordNo`) "
			+ "		FROM `km_product_order` WHERE `ordDate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 WEEK ) AND NOW() ) AS countOrdNoWeek,"
			+ "	(SELECT COUNT(`ordNo`) "
			+ "		FROM `km_product_order` WHERE `ordDate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 MONTH ) AND NOW() ) AS countOrdNoMonth,"
			+ "	SUM(`ordTotPrice`) AS sumOrdTotPrice,"
			+ "	(SELECT SUM(`ordTotPrice`) "
			+ "		FROM `km_product_order` WHERE `ordDate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 DAY ) AND NOW() ) AS sumOrdTotPriceDay, "
			+ "	(SELECT SUM(`ordTotPrice`) "
			+ "		FROM `km_product_order` WHERE `ordDate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 WEEK ) AND NOW() ) AS sumOrdTotPriceWeek, "
			+ "	(SELECT SUM(`ordTotPrice`) "
			+ "		FROM `km_product_order` WHERE `ordDate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 MONTH ) AND NOW() ) AS sumOrdTotPriceMonth, "
			+ "	(SELECT COUNT(`pass`) FROM `km_member`) AS countMember,"
			+ "	(SELECT COUNT(`pass`) "
			+ "		FROM `km_member` WHERE `rdate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 DAY ) AND NOW() ) AS countMemberDay, "
			+ "	(SELECT COUNT(`pass`) "
			+ "		FROM `km_member` WHERE `rdate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 WEEK ) AND NOW() ) AS countMemberWeek, "
			+ "	(SELECT COUNT(`pass`) "
			+ "		FROM `km_member` WHERE `rdate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 MONTH ) AND NOW() ) AS countMemberMonth, "
			+ "	(SELECT COUNT(`rdate`) "
			+ "		FROM `km_product` WHERE `rdate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 DAY ) AND NOW() ) AS countProductRdateDay, "
			+ "	(SELECT COUNT(`rdate`) "
			+ "		FROM `km_product` WHERE `rdate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 WEEK ) AND NOW() ) AS countProductRdateWeek, "
			+ "	(SELECT COUNT(`rdate`) "
			+ "		FROM `km_product` WHERE `rdate` BETWEEN DATE_ADD(NOW(), INTERVAL -1 MONTH ) AND NOW() ) AS countProductRdateMonth "
			+ "FROM `km_product_order`";
}
