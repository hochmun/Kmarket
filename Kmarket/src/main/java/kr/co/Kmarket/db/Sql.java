package kr.co.Kmarket.db;

public class Sql {
	// member
	
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
	
	public static final String SELECT_CATE1 = 
			"SELECT * FROM `km_product_cate1`";
	public static final String SELECT_CATE2 = 
			"SELECT * FROM `km_product_cate2` WHERE `cate1`=?";
}
