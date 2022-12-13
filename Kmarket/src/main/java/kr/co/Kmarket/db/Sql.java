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
	
	/** 상품목록*/
	public static final String SELECT_PRODUCT_LIST_SOLD = "SELECT DISTINCT `prodname`,`descript`,`seller`,`price`,`discount`,`delivery`, "
														+ "`score`,`thumb1` FROM `km_product` AS a "
														+ "JOIN `km_product_cate1` AS b ON a.prodcate1 = b.cate1 "
														+ "JOIN `km_product_cate2` AS c ON a.prodcate2 = c.cate2 "
														+ "WHERE b.cate1 = ? AND c.cate2 = ? "
														+ "ORDER BY a.sold DESC";
	
	public static final String SELECT_PRODUCT_LIST_LOW = "SELECT DISTINCT `prodname`,`descript`,`seller`,`price`,`discount`,`delivery`, "
														+ "`score`,`thumb1` FROM `km_product` AS a "
														+ "JOIN `km_product_cate1` AS b ON a.prodcate1 = b.cate1 "
														+ "JOIN `km_product_cate2` AS c ON a.prodcate2 = c.cate2 "
														+ "WHERE b.cate1 = ? AND c.cate2 = ? "
														+ "ORDER BY a.price ASC";
	
	public static final String SELECT_PRODUCT_LIST_HIGH = "SELECT DISTINCT `prodname`,`descript`,`seller`,`price`,`discount`,`delivery`, "
														+ "`score`,`thumb1` FROM `km_product` AS a "
														+ "JOIN `km_product_cate1` AS b ON a.prodcate1 = b.cate1 "
														+ "JOIN `km_product_cate2` AS c ON a.prodcate2 = c.cate2 "
														+ "WHERE b.cate1 = ? AND c.cate2 = ? "
														+ "ORDER BY a.price DESC";
	
	public static final String SELECT_PRODUCT_LIST_HSTAR = "SELECT DISTINCT `prodname`,`descript`,`seller`,`price`,`discount`,`delivery`, "
															+ "`score`,`thumb1` FROM `km_product` AS a "
															+ "JOIN `km_product_cate1` AS b ON a.prodcate1 = b.cate1 "
															+ "JOIN `km_product_cate2` AS c ON a.prodcate2 = c.cate2 "
															+ "WHERE b.cate1 = ? AND c.cate2 = ? "
															+ "ORDER BY a.score desc";
	
	public static final String SELECT_PRODUCT_LIST_REVIEW = "SELECT DISTINCT `prodname`,`descript`,`seller`,`price`,`discount`,`delivery`, "
															+ "`score`,`thumb1` FROM `km_product` AS a "
															+ "JOIN `km_product_cate1` AS b ON a.prodcate1 = b.cate1 "
															+ "JOIN `km_product_cate2` AS c ON a.prodcate2 = c.cate2 "
															+ "WHERE b.cate1 = ? AND c.cate2 = ? "
															+ "ORDER BY a.review desc";
	
	public static final String SELECT_PRODUCT_LIST_LATEST = "SELECT DISTINCT `prodname`,`descript`,`seller`,`price`,`discount`,`delivery`, "
															+ "`score`,`thumb1` FROM `km_product` AS a "
															+ "JOIN `km_product_cate1` AS b ON a.prodcate1 = b.cate1 "
															+ "JOIN `km_product_cate2` AS c ON a.prodcate2 = c.cate2 "
															+ "WHERE b.cate1 = ? AND c.cate2 = ? "
															+ "ORDER BY a.prodNo asc";
	
	public static final String SELECT_COUNT_PRODUCTS = "SELECT COUNT(a.`prodNo`) FROM `km_product` AS a "
														+ "JOIN `km_product_cate1` AS b ON a.`prodcate1` = b.`cate1` "
														+ "JOIN `km_product_cate2` AS c ON a.`prodcate2` = c.`cate2` "
														+ "WHERE b.`cate1`=? AND c.cate2 = ? "
														+ "AND (a.`prodName` LIKE '?' "
														+ "OR a.`descript` LIKE '?')";
	
	
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

	
}
