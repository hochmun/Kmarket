package kr.co.Kmarket.db;

public class Sql {
	// member
	
	public static final String SELECT_USER = 
			"SELECT * FROM `km_member` WHERE `uid`=? AND `pass`=SHA2(?,256)";
	public static final String SELECT_MEMBER_TERMS = 
			"SELECT * FROM `km_member_terms`";
	
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
			+ "`Tel`=?, "
			+ "`fax`=?, "
			+ "`email`=?, "
			+ "`type`=2, "
			+ "`level`=1, "
			+ "`zip`=?, "
			+ "`addr1`=?, "
			+ "`addr2`=?, "
			+ "`name`=?, "
			+ "`hp`=?, "
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
	
	
	/** 상품목록 판매량순*/
	public static final String SELECT_PRODUCT_LIST_SOLD = "SELECT DISTINCT `prodName`,`descript`,`seller`,`price`,`discount`,`delivery`, "
														+ "`score`,`thumb1` FROM `km_product` "
														+ "WHERE prodCate1 = ? AND prodCate2 = ? "
														+ "ORDER BY `sold` DESC";
	/** 상품목록 낮은가격순*/
	public static final String SELECT_PRODUCT_LIST_LOW = "SELECT DISTINCT `prodname`,`descript`,`seller`,`price`,`discount`,`delivery`, "
														+ "`score`,`thumb1` FROM `km_product` "
														+ "WHERE prodCate1 = ? AND prodCate2 = ? "
														+ "ORDER BY `price` ASC";
	/** 상품목록 높은가격순*/
	public static final String SELECT_PRODUCT_LIST_HIGH = "SELECT DISTINCT `prodname`,`descript`,`seller`,`price`,`discount`,`delivery`, "
														+ "`score`,`thumb1` FROM `km_product` "
														+ "WHERE prodCate1 = ? AND prodCate2 = ? "
														+ "ORDER BY `price` DESC";
	/** 상품목록 높은별점순*/
	public static final String SELECT_PRODUCT_LIST_HSTAR = "SELECT DISTINCT `prodname`,`descript`,`seller`,`price`,`discount`,`delivery`, "
															+ "`score`,`thumb1` FROM `km_product` "
															+ "WHERE prodCate1 = ? AND prodCate2 = ? "
															+ "ORDER BY `score` desc";
	/** 상품목록 리뷰많은순*/
	public static final String SELECT_PRODUCT_LIST_REVIEW = "SELECT DISTINCT `prodname`,`descript`,`seller`,`price`,`discount`,`delivery`, "
															+ "`score`,`thumb1` FROM `km_product` "
															+ "WHERE prodCate1 = ? AND prodCate2 = ? "
															+ "ORDER BY `review` desc";
	/** 상품목록 최근등록순*/
	public static final String SELECT_PRODUCT_LIST_LATEST = "SELECT DISTINCT `prodname`,`descript`,`seller`,`price`,`discount`,`delivery`, "
															+ "`score`,`thumb1` FROM `km_product` "
															+ "WHERE prodCate1 = ? AND prodCate2 = ? "
															+ "ORDER BY `prodNo` asc";
	
	/** 제목, 상품설명 키워드 검색*/
	public static final String SELECT_COUNT_PRODUCTS = "SELECT COUNT(`prodNo`) FROM `km_product` "
														+ "WHERE `prodCate1` = ? AND `prodCate2` = ? "
														+ "AND (`prodName` REGEXP ? "
														+ "OR `descript` REGEXP ?)";

	
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
	
	public static final String SELECT_PROD_CATE = "SELECT * FROM `km_product_cate1` as a "
												+ "JOIN `km_product_cate2` AS b ON a.cate1 = b.cate1 "
												+ "WHERE a.cate1 = ? AND b.cate2 = ?";

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

}
