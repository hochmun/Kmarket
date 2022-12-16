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
			+ "`company`=?, "
			+ "`ceo`=?, "
			+ "`bizRegNum`=?, "
			+ "`comRegNum`=?, "
			+ "`tel`=?, "
			+ "`fax`=?, "
			+ "`email`=?, "
			+ "`type`=2, "
			+ "`level`=1, "
			+ "`zip`=?, "
			+ "`addr1`=?, "
			+ "`addr2`=?, "
			+ "`manager`=?, "
			+ "`managerHp`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	
	public static final String SELECT_COUNT_UID = "SELECT COUNT(`uid`) FROM `km_member` WHERE `uid`=?";

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
			+ "`rdate`=NOW()";
	
	/** 상품 불러오기*/
	public static final String SELECT_PRODUCT = "SELECT * FROM `km_product` WHERE `prodNo` = ?";
	/** 상품목록 불러오기*/
	public static final String SELECT_PRODUCTS = "SELECT * FROM `km_product` WHERE `prodCate1` = ? AND `prodCate2` = ? limit 10";
	
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
														+ "WHERE prodCate1 = ? AND prodCate2 = ? "
														+ "ORDER BY `sold` DESC";
	/** 상품목록 낮은가격순*/
	public static final String SELECT_PRODUCT_LIST_LOW = "SELECT *, `price`*(100-`discount`)*0.01 AS `dprice` FROM `km_product` "
														+ "WHERE prodCate1 = ? AND prodCate2 = ? "
														+ "ORDER BY `dprice` ASC";
	/** 상품목록 높은가격순*/
	public static final String SELECT_PRODUCT_LIST_HIGH = "SELECT *, `price`*(100-`discount`)*0.01 AS `dprice` FROM `km_product` "
														+ "WHERE prodCate1 = ? AND prodCate2 = ? "
														+ "ORDER BY `dprice` DESC";
	/** 상품목록 높은별점순*/
	public static final String SELECT_PRODUCT_LIST_HSTAR = "SELECT * FROM `km_product` "
															+ "WHERE prodCate1 = ? AND prodCate2 = ? "
															+ "ORDER BY `score` desc";
	/** 상품목록 리뷰많은순*/
	public static final String SELECT_PRODUCT_LIST_REVIEW = "SELECT * FROM `km_product` "
															+ "WHERE prodCate1 = ? AND prodCate2 = ? "
															+ "ORDER BY `review` desc";
	/** 상품목록 최근등록순*/
	public static final String SELECT_PRODUCT_LIST_LATEST = "SELECT * FROM `km_product` "
															+ "WHERE prodCate1 = ? AND prodCate2 = ? "
															+ "ORDER BY `prodNo` asc";
	
	/** 제목, 상품설명 키워드 검색*/
	public static final String SELECT_COUNT_PRODUCTS = "SELECT COUNT(`prodNo`) FROM `km_product` "
														+ "WHERE `prodCate1` = ? AND `prodCate2` = ?";
	
														/**+ "AND (`prodName` REGEXP ? "
														+ "OR `descript` REGEXP ?)";  검색기능 추가시 해당 쿼리 고려*/

	
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
	
}
