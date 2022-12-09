package kr.co.Kmarket.service.admin;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;

import kr.co.Kmarket.dao.product.ProductDAO;
import kr.co.Kmarket.vo.Cate1VO;
import kr.co.Kmarket.vo.Cate2VO;
import kr.co.Kmarket.vo.ProductVO;

public enum AdminService {
	
	INSTANCE;
	private ProductDAO dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private AdminService () {
		dao = new ProductDAO();
	}
	
	// service
	/**
	 * 2022/12/09 productVO 값입력
	 * @param req
	 * @param mr
	 * @param saveDirectory
	 * @return {@link ProductVO}
	 */
	public ProductVO insertProductVO(HttpServletRequest req, MultipartRequest mr, String saveDirectory) {
		ProductVO vo = new ProductVO();
		int discount =  1 - Integer.parseInt(mr.getParameter("discount"))/100;
		int point = (Integer.parseInt(mr.getParameter("price")) * discount)/100;
		
		vo.setSeller(mr.getParameter("seller"));
		
		vo.setProdName(mr.getParameter("prodName"));
		vo.setProdCate1(mr.getParameter("category1"));
		vo.setProdCate2(mr.getParameter("category2"));
		vo.setDescript(mr.getParameter("descript"));
		vo.setCompany(mr.getParameter("company"));
		vo.setPrice(mr.getParameter("price"));
		vo.setDiscount(mr.getParameter("discount"));
		vo.setPoint(point);
		vo.setStock(mr.getParameter("stock"));
		vo.setDelivery(mr.getParameter("delivery"));
		vo.setIp(req.getRemoteAddr());
		
		vo.setStatus(mr.getParameter("status"));
		vo.setDuty(mr.getParameter("duty"));
		vo.setReceipt(mr.getParameter("receipt"));
		vo.setBizType(mr.getParameter("bizType"));
		vo.setOrigin(mr.getParameter("origin"));
		
		// 파일 이름 변경 작업
		String thumb1 = fileReName(mr.getFilesystemName("thumb1"), vo, "thumb1", saveDirectory);
		String thumb2 = fileReName(mr.getFilesystemName("thumb2"), vo, "thumb2", saveDirectory);
		String thumb3 = fileReName(mr.getFilesystemName("thumb3"), vo, "thumb3", saveDirectory);
		String detail = fileReName(mr.getFilesystemName("detail"), vo, "detail", saveDirectory);
		
		vo.setThumb1(thumb1);
		vo.setThumb2(thumb2);
		vo.setThumb3(thumb3);
		vo.setDetail(detail);
		
		return vo;
	}
	
	/**
	 * 2022/12/09 해당 디렉토리가 없을시 디렉토리 생성
	 * @author 심규영
	 * @param targetDir
	 */
	public void dirCreate(String targetDir) {
		File Directory = new File(targetDir);
		if(!Directory.exists()) Directory.mkdirs();
	}
	
	/**
	 * 2022/12/09 파일 업로드
	 * @author 심규영
	 * @param req
	 * @param saveDirectory
	 * @param maxPostSize
	 * @return {@link MultipartRequest}
	 */
	public MultipartRequest uploadFile(HttpServletRequest req, String saveDirectory, int maxPostSize) {
		try {
			// 파일 업로드
			return new MultipartRequest(req, saveDirectory, maxPostSize, "UTF-8");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	/**
	 * 2022/12/09 업로드된 파일 이름 변경 작업
	 * @author 심규영
	 * @param fileName
	 * @param seller
	 * @param fileValue
	 * @param saveDirectory
	 * @return String 새로운 파일 이름
	 */
	public String fileReName(String fileName, ProductVO vo, String fileValue, String saveDirectory) {
		String now = UUID.randomUUID().toString();
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = fileValue+"_"+vo.getProdCate1()+"_"+vo.getProdCate2()+"_"+now+ext;
		
		File oldFile = new File(saveDirectory + File.separator + fileName);
		File newFile = new File(saveDirectory + File.separator + newFileName);
		
		oldFile.renameTo(newFile);
		
		return newFileName;
	}
	
	// create
	/**
	 * 2022/12/09 상품등록
	 * @author 심규영
	 * @param vo
	 */
	public void insertProduct(ProductVO vo) {
		dao.insertProduct(vo);
	}
	
	/**
	 * 2022/12/09 상품등록
	 * @author 심규영
	 * @param ProductVO
	public void insertProduct(ProductVO vo) {
		dao.insertProduct(vo);
	}
	
	// read 
	/**
	 * 2022/12/08 - 카테고리1 불러오기
	 * @author 심규영
	 * @return List<{@link Cate1VO}> - 카테고리1
	 */
	public List<Cate1VO> selectcate1() {
		return dao.selectcate1();
	}
	
	/**
	 * 2022/12/08 - 카테고리2 불러오기
	 * @author 심규영
	 * @param cate1
	 * @return 카테고리2 리스트
	 */
 	public List<Cate2VO> selectcate2(String cate1) {
		return dao.selectcate2(cate1);
	}
	
	// upload
	
	// delete
}
