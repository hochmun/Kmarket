package kr.co.Kmarket.db;

public class Sql {
	// member
	
	public static final String SELECT_USER = 
			"SELECT * FROM `km_member` WHERE `uid`=? AND `pass`=SHA2(?,256)";
	public static final String SELECT_MEMBER_TERMS = 
			"SELECT * FROM `km_member_terms`";
	public static final String SELECT_MEMBER_WITH_UID = 
			"SELECT * FROM `km_member` WHERE `uid`=?";
	
	/**일반회원*/
	public static final String INSERT_MEMBER_TYPE1 = "INSERT INTO `km_member` SET "
			+ "`uid`=?, "
			+ "`pass`=SHA2(?, 256), "
			+ "`name`=?, "
			+ "`gender`=?, "
			+ "`hp`=?, "
			+ "`email`=?, "
			+ "`type`=1, "
			+ "`point`=0, "
			+ "`level`=1, "
			+ "`zip`=?, "
			+ "`addr1`=?, "
			+ "`addr2`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	
	/**판매자회원*/
	public static final String INSERT_MEMBER_TYPE2 = "INSERT INTO `km_member` SET "
			+ "`uid`=?, "
			+ "`pass`=SHA2(?, 256), "
			+ "`email`=?, "
			+ "`type`=2, "
			+ "`level`=1, "
			+ "`zip`=?, "
			+ "`addr1`=?, "
			+ "`addr2`=?, "
			+ "`company`=?, "
			+ "`ceo`=?, "
			+ "`bizRegNum`=?, "
			+ "`comRegNum`=?, "
			+ "`tel`=?, "
			+ "`manager`=?, "
			+ "`managerHp`=?, "
			+ "`fax`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	
	public static final String SELECT_COUNT_UID = "SELECT COUNT(`uid`) FROM `km_member` WHERE `uid`=?";

	/** product/order - 유저정보의 누적 포인트 수정 */
	public static final String UPDATE_MEMBER_IN_POINT = 
			"UPDATE `km_member` SET "
			+ "`point` = `point` + ? - ? "
			+ "WHERE `uid`=?";
	
	// member_point
	
	public static final String INSERT_MEMBER_POINT = 
			"INSERT INTO `km_member_point` SET "
			+ "`uid`=?, "
			+ "`ordNo`=?, "
			+ "`point`=?, "
			+ "`pointDate`=NOW()";
	
	// product
	public static final String INSERT_PRODUCT = 
			"INSERT INTO `km_product` SET "
			+ "`prodCate1`=?, "
			+ "`prodCate2`=?, "
			+ "`prodName`=?, "
			+ "`descript`=?, "
			+ "`company`=?, "
			+ "`seller`=?, "
			+ "`price`=?, "
			+ "`discount`=?, "
			+ "`point`=?, "
			+ "`stock`=?, "
			+ "`delivery`=?, "
			+ "`thumb1`=?, "
			+ "`thumb2`=?, "
			+ "`thumb3`=?, "
			+ "`detail`=?, "
			+ "`status`=?, "
			+ "`duty`=?, "
			+ "`receipt`=?, "
			+ "`bizType`=?, "
			+ "`origin`=?, "
			+ "`ip`=?, "
			+ "`uid`=?, "
			+ "`rdate`=NOW()";
	
	/** 상품 불러오기*/
	public static final String SELECT_PRODUCT = "SELECT * FROM `km_product` WHERE `prodNo` = ?";
	/** 상품목록 불러오기*/
	public static final String SELECT_PRODUCTS = "SELECT * FROM `km_product` WHERE `prodCate1` LIKE ? AND `prodCate2` LIKE ? limit ?, 10";
	
	public static final String SELECT_PRODUCTS_CONDITION = "SELECT * FROM `km_product` "
															+ "WHERE `prodCate1` = ? AND `prodCate2` = ? "
															+ "ORDER BY `prodNo` desc"
															+ "limit 10";
	
	/** 메인 페이지 - 베스트 상품 불러오기 => 판매량 많은 순 */
	public static final String SELECT_PRODUCT_BEST = 
			"SELECT "
			+ "	`prodNo`,"
			+ " `prodCate1`,"
			+ " `prodCate2`,"
			+ "	`prodName`,"
			+ "	`price`,"
			+ "	`discount`,"
			+ "	`thumb1`,"
			+ "	`thumb2` "
			+ "FROM `km_product` ORDER BY `sold` DESC LIMIT 5";
	
	/** 메인 페이지 - hit, score, discount 많은 순서, 8개 불러오기 */
	public static final String SELECT_PRODUCT_HIT = 
			"SELECT "
			+ "	`prodNo`,"
			+ " `prodCate1`,"
			+ " `prodCate2`,"
			+ "	`prodName`,"
			+ " `descript`,"
			+ "	`price`,"
			+ "	`discount`,"
			+ " `delivery`,"
			+ "	`thumb2` "
			+ "FROM `km_product` ORDER BY `hit` DESC LIMIT 8";
	public static final String SELECT_PRODUCT_SCORE = 
			"SELECT "
			+ "	`prodNo`,"
			+ " `prodCate1`,"
			+ " `prodCate2`,"
			+ "	`prodName`,"
			+ " `descript`,"
			+ "	`price`,"
			+ "	`discount`,"
			+ " `delivery`,"
			+ "	`thumb2` "
			+ "FROM `km_product` ORDER BY `score` DESC LIMIT 8";
	public static final String SELECT_PRODUCT_DISCOUNT = 
			"SELECT "
			+ "	`prodNo`,"
			+ " `prodCate1`,"
			+ " `prodCate2`,"
			+ "	`prodName`,"
			+ " `descript`,"
			+ "	`price`,"
			+ "	`discount`,"
			+ " `delivery`,"
			+ "	`thumb2` "
			+ "FROM `km_product` ORDER BY `discount` DESC LIMIT 8";
	public static final String SELECT_PRODUCT_DATE = 
			"SELECT "
					+ "	`prodNo`,"
					+ " `prodCate1`,"
					+ " `prodCate2`,"
					+ "	`prodName`,"
					+ " `descript`,"
					+ "	`price`,"
					+ "	`discount`,"
					+ " `delivery`,"
					+ "	`thumb2` "
					+ "FROM `km_product` ORDER BY `rdate` DESC LIMIT 8";
	/*
	public String SELECT_PRODUCT_LIST_MODE3(int mode) {
		String query = "SELECT * FROM `km_product` ORDER BY ";
		
		if(mode == 1) query += " `hit` ";
		if(mode == 2) query += " `score` ";
		if(mode == 3) query += " `discount` ";
		
		query += " DESC LIMIT 8 ";
		
		return query;
	}
	*/
	
	/** 상품목록 판매량순*/
	public static final String SELECT_PRODUCT_LIST_SOLD = "SELECT * FROM `km_product` "
														+ "WHERE prodCate1 LIKE ? AND prodCate2 LIKE ? "
														+ "ORDER BY `sold` DESC limit ?, 10";
	/** 상품목록 낮은가격순*/
	public static final String SELECT_PRODUCT_LIST_LOW = "SELECT *, `price`*(100-`discount`)*0.01 AS `dprice` FROM `km_product` "
														+ "WHERE prodCate1 LIKE ? AND prodCate2 LIKE ? "
														+ "ORDER BY `dprice` ASC limit ?, 10";
	/** 상품목록 높은가격순*/
	public static final String SELECT_PRODUCT_LIST_HIGH = "SELECT *, `price`*(100-`discount`)*0.01 AS `dprice` FROM `km_product` "
														+ "WHERE prodCate1 LIKE ? AND prodCate2 LIKE ? "
														+ "ORDER BY `dprice` DESC limit ?, 10";
	/** 상품목록 높은별점순*/
	public static final String SELECT_PRODUCT_LIST_HSTAR = "SELECT * FROM `km_product` "
															+ "WHERE prodCate1 LIKE ? AND prodCate2 LIKE ? "
															+ "ORDER BY `score` desc limit ?, 10";
	/** 상품목록 리뷰많은순*/
	public static final String SELECT_PRODUCT_LIST_REVIEW = "SELECT * FROM `km_product` "
															+ "WHERE prodCate1 LIKE ? AND prodCate2 LIKE ? "
															+ "ORDER BY `review` desc limit ?, 10";
	/** 상품목록 최근등록순*/
	public static final String SELECT_PRODUCT_LIST_LATEST = "SELECT * FROM `km_product` "
															+ "WHERE prodCate1 LIKE ? AND prodCate2 LIKE ? "
															+ "ORDER BY `prodNo` DESC limit ?, 10";
	
	/** 제목, 상품설명 키워드 검색*/
	public static final String SELECT_COUNT_PRODUCTS = "SELECT COUNT(`prodNo`) FROM `km_product` "
														+ "WHERE `prodCate1` LIKE ? AND `prodCate2` LIKE ?";
	
														/**+ "AND (`prodName` REGEXP ? "
														+ "OR `descript` REGEXP ?)";  검색기능 추가시 해당 쿼리 고려*/
	
	/** 관리자/상품/리스트 - 해당 판매자의 상품 갯수 가져오기 */
	public static final String SELECT_COUNT_PRODUCT_WITH_UID = 
			"SELECT COUNT(`prodNo`) FROM `km_product` WHERE `uid` = ?";
	
	/** 관리자/상품/리스트 - 최고관리자 전체 상품 갯수 가져오기 */
	public static final String SELECT_COUNT_PRODUCT = 
			"SELECT COUNT(`prodNo`) FROM `km_product` WHERE `uid` LIKE '%%'";
	
	/** 관리자/상품/리스트 - 페이징 상품 갯수 가져오기 머리 */
	public static final String SELECT_PRODUCT_PAGE_LIST_HEAD = 
			"SELECT * FROM `km_product` "
			+ " WHERE `uid` LIKE ? ";
	
	/** 관리자/상품/리스트 - 페이징 상품 갯수 가져오기 다리*/
	public static final String SELECT_PRODUCT_PAGE_LIST_FOOTER = 
			"ORDER BY `prodNo` DESC "
			+ "LIMIT ?, 10";
	
	public static final String SELECT_CATE1 = 
			"SELECT * FROM `km_product_cate1`";
	public static final String SELECT_CATE2 = 
			"SELECT * FROM `km_product_cate2` WHERE `cate1`=?";
	public static final String SELECT_CATE1_NAME = 
			"SELECT `c1Name` FROM `km_product_cate1` WHERE `cate1`=?";
	public static final String SELECT_CATE2_NAME = 
			"SELECT `c2Name` FROM `km_product_cate2` WHERE `cate1`=? AND `cate2`=?";
	public static final String SELECT_PRODUCT_WITH_PRODNO = 
			"SELECT * FROM `km_product` WHERE `prodNo`=?";
	public static final String SELECT_CATE1_CATE2 = 
			"SELECT "
			+ "	a.`cate1`, "
			+ "	a.cate2, "
			+ "	a.c2Name, "
			+ "	b.c1Name "
			+ "FROM `km_product_cate2` AS a "
			+ "LEFT JOIN `km_product_cate1` AS b ON a.cate1 = b.cate1";
	
	public static final String SELECT_PROD_CATE = "SELECT a.*, b.cate2, b.c2Name FROM `km_product_cate1` as a "
												+ "LEFT JOIN `km_product_cate2` AS b ON a.cate1 = b.cate1 "
												+ "WHERE a.cate1 = ? AND b.cate2 = ?";

	public static final String UPDATE_PRODUCT_HIT = "UPDATE `km_product` SET `hit`=`hit`+1 WHERE `prodNo`=?";
	public static final String UPDATE_PRODUCT_MINUS_STOCK = 
			"UPDATE `km_product` SET "
			+ "`stock` = `stock` - ? "
			+ "WHERE `prodNo`=?";
	
	// product_cart
	
	public static final String INSERT_PRODUCT_CART = 
			"INSERT INTO `km_product_cart` SET "
			+ "`uid`=?, "
			+ "`prodNo`=?, "
			+ "`count`=?, "
			+ "`price`=?, "
			+ "`discount`=?, "
			+ "`point`=?, "
			+ "`delivery`=?, "
			+ "`total`=?, "
			+ "`rdate`=NOW()";

	public static final String SELECT_PRODUCT_CART_WITH_UID = 
			"SELECT "
				+ "pc.*, "
				+ "p.thumb1, "
				+ "p.prodCate1, "
				+ "p.prodCate2, "
				+ "p.prodName, "
				+ "p.descript "
			+ "FROM `km_product_cart` AS pc "
			+ "JOIN `km_product` AS p ON pc.prodNo = p.prodNo "
			+ "WHERE pc.`uid`=?";
	
	public static final String SELECT_PRODUCT_CART_WITH_CARTNO = 
			"SELECT "
				+ "pc.*, "
				+ "p.thumb1, "
				+ "p.prodCate1, "
				+ "p.prodCate2, "
				+ "p.prodName, "
				+ "p.descript "
			+ "FROM `km_product_cart` AS pc "
			+ "JOIN `km_product` AS p ON pc.prodNo = p.prodNo "
			+ "WHERE pc.`cartNo`=?";
	
	/** 방금 넣은 상품의 key값 가져오기 */
	public static final String SELECT_MAX_CARTNO_PRODUCT_CART = "SELECT MAX(`cartNo`) FROM `km_product_cart`";
	
	/** product/order - 장바구니에 상품 정보 삭제 */
	public static final String DELETE_PRODUCT_CART = 
			"DELETE FROM `km_product_cart` WHERE `cartNo`=?";
	
	// product_order
	
	/** product/order - 주문 등록 */
	public static final String INSERT_PRODUCT_ORDER = 
			"INSERT INTO `km_product_order` SET "
			+ "`ordUid`=?, "
			+ "`ordCount`=?, "
			+ "`ordPrice`=?, "
			+ "`ordDiscount`=?, "
			+ "`ordDelivery`=?, "
			+ "`savePoint`=?, "
			+ "`usedPoint`=?, "
			+ "`ordTotPrice`=?, "
			+ "`recipName`=?, "
			+ "`recipHp`=?, "
			+ "`recipZip`=?, "
			+ "`recipAddr1`=?, "
			+ "`recipAddr2`=?, "
			+ "`ordPayment`=?, "
			+ "`ordComplete`=1, "
			+ "`ordDate`=NOW()";
	
	/** product/order - 주문 등록의 주문 번호 반환 */
	public static final String SELECT_PRODUCT_ORDER_ORDERNO = 
			"SELECT `ordNo` "
			+ "FROM `km_product_order` "
			+ "WHERE `ordUid`=? "
			+ "ORDER BY `ordNo` DESC "
			+ "LIMIT 1";
	
	public static final String SELECT_PRODUCT_ORDER_WITH_ORDNO = 
			"SELECT * FROM `km_product_order` WHERE `ordNo`=?";
	
	// product_order_item
	
 	public static final String INSERT_PRODUCT_ORDER_ITEM = 
 			"INSERT INTO `km_product_order_item` SET "
 			+ "`ordNo`=?, "
 			+ "`prodNo`=?, "
 			+ "`count`=?, "
 			+ "`price`=?, "
 			+ "`discount`=?, "
 			+ "`point`=?, "
 			+ "`delivery`=?, "
 			+ "`total`=?";
 	
  	public static final String SELECT_PRODUCT_LIST_WITH_ORDNO = 
  			"SELECT "
  			+ "	oi.*, "
  			+ "	p.prodCate1, "
  			+ "	p.prodCate2, "
  			+ "	p.thumb1, "
  			+ "	p.prodName, "
  			+ "	p.descript "
  			+ "FROM `km_product_order_item` AS oi "
  			+ "JOIN `km_product` AS p ON oi.prodNo = p.prodNo "
  			+ "WHERE `ordNo`=?;";
 	
  	/* 판매자 product */
  	
  	// 해당 판매자가 등록한 상품 정보 불러오기
  	public static final String SELECT_ADMIN_PRODS = "SELECT a.* FROM `km_product` AS a "
										  			+ "JOIN `km_member` AS b "
										  			+ "ON a.seller = b.uid "
										  			+ "WHERE `uid` = ? "
										  			+ "ORDER BY `prodNo` DESC "
										  			+ "LIMIT ?, 10";
  	
  	// 등록된 상품 이름으로 검색
  	public static final String SELECT_ADMIN_PRODS_BY_PRODNAME = "SELECT a.* FROM `km_product` AS a "
												  			+ "JOIN `km_member` AS b "
												  			+ "ON a.seller = b.uid "
												  			+ "WHERE `uid` = ? AND `prodName` = ? "
												  			+ "ORDER BY `prodNo` DESC LIMIT ?, 10";
  	// 등록된 상품 번호로 검색
  	public static final String SELECT_ADMIN_PRODS_BY_PRODNO = "SELECT a.* FROM `km_product` AS a "
												  			+ "JOIN `km_member` AS b "
												  			+ "ON a.seller = b.uid "
												  			+ "WHERE `uid` = ? AND `prodNo` = ? "
												  			+ "ORDER BY `prodNo` DESC LIMIT ?, 10";
  	// 등록된 상품 판매자명으로 검색
  	public static final String SELECT_ADMIN_PRODS_BY_SELLER = "SELECT a.* FROM `km_product` AS a "
												  			+ "JOIN `km_member` AS b "
												  			+ "ON a.seller = b.uid "
												  			+ "WHERE `uid` = ? AND `seller` = ? "
												  			+ "ORDER BY `prodNo` DESC LIMIT ?, 10";
  	
  	/*ADMIN용 조회*/
  	
  	/** 관리자/상품리스트 삭제 기능 */
  	public static final String DELETE_PRODUCT = 
  			"DELETE FROM `km_product` WHERE `prodNo`=?";
}
