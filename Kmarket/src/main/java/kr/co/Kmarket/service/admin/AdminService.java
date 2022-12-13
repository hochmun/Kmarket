package kr.co.Kmarket.service.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

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
	public ProductVO insertProductVO(HttpServletRequest req) {
		ProductVO vo = new ProductVO();
		double discount =  Integer.parseInt(req.getParameter("discount"));
		int point = (int)(Integer.parseInt(req.getParameter("price")) * (1 - (discount / 100)))/100;
		
		vo.setSeller(req.getParameter("seller"));
		
		vo.setProdName(req.getParameter("prodName"));
		vo.setProdCate1(req.getParameter("category1"));
		vo.setProdCate2(req.getParameter("category2"));
		vo.setDescript(req.getParameter("descript"));
		vo.setCompany(req.getParameter("company"));
		vo.setPrice(req.getParameter("price"));
		vo.setDiscount(req.getParameter("discount"));
		vo.setPoint(point);
		vo.setStock(req.getParameter("stock"));
		vo.setDelivery(req.getParameter("delivery"));
		vo.setIp(req.getRemoteAddr());
		
		vo.setStatus(req.getParameter("status"));
		vo.setDuty(req.getParameter("duty"));
		vo.setReceipt(req.getParameter("receipt"));
		vo.setBizType(req.getParameter("bizType"));
		vo.setOrigin(req.getParameter("origin"));
		
		//vo.setThumb1(thumb1);
		//vo.setThumb2(thumb2);
		//vo.setThumb3(thumb3);
		//vo.setDetail(detail);
		
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
	 * 2022/12/12 - 서블릿 형태의 파일 업로드 기능
	 * @param req
	 * @param path
	 */
	public ProductVO uploadFile2(HttpServletRequest req, String path, ProductVO vo) {
		try {
			logger.info("AdminService uploadFile2...");
			
			// 이미지 파일 불러오기
			Part thumb1 = req.getPart("thumb1");
			Part thumb2 = req.getPart("thumb2");
			Part thumb3 = req.getPart("thumb3");
			Part detail = req.getPart("detail");
			
			// 이미지 파일 이름 변경
			String thumb1FileName = fileReName(getFileName(thumb1));
			String thumb2FileName = fileReName(getFileName(thumb2));
			String thumb3FileName = fileReName(getFileName(thumb3));
			String detailFileName = fileReName(getFileName(detail));
			
			// 이미지 파일 출력(저장)
			fileOutPut(thumb1FileName, thumb1, path);
			fileOutPut(thumb2FileName, thumb2, path);
			fileOutPut(thumb3FileName, thumb3, path);
			fileOutPut(detailFileName, detail, path);
			
			// vo에 저장
			vo.setThumb1(thumb1FileName);
			vo.setThumb2(thumb2FileName);
			vo.setThumb3(thumb3FileName);
			vo.setDetail(detailFileName);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return vo;
	}
	
	/**
	 * 2022/12/12 - 이미지 파일 출력
	 * @param fileName
	 * @param filePart
	 * @param path
	 */
	public void fileOutPut(String fileName, Part filePart, String path) {
		try {
			logger.info("adminService fileoutput....");
			// 파일 이름 및 경로 설정
			File file = new File(path+fileName);
			// 해당 이미지의 내용을 inputStream으로 가져옴
			InputStream is = filePart.getInputStream();
			// 파일 출력 준비
			FileOutputStream fos = null;
			
			fos = new FileOutputStream(file);
			
			int temp = -1;
			// inputStream으로 가져온 이미지를 byte 단위로 읽음
			// 더이상 읽을 byte가 없을 경우 -1을 반환
			while((temp = is.read()) != -1) {
				// 읽은 byte를 출력
				fos.write(temp);
			}
			
			// 종료
			is.close();
			fos.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
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
	public String fileReName(String fileName) {
		// 난수 생성
		String now = UUID.randomUUID().toString();
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = now+ext;
		
		return newFileName;
	}
	
	/**
	 * 2022/12/12 - part 에서 이름 가져오기
	 * @param filePart
	 * @return String 파일 이름
	 */
	 public String getFileName(Part filePart) {
        for(String filePartData : filePart.getHeader("Content-Disposition").split(";")) {
            if(filePartData.trim().startsWith("filename")) {
                return filePartData.substring(filePartData.indexOf("=") + 1).trim().replace("\"", "");
            }
        }
        
        return null;
	 }
	
	// create
	/**
	 * 2022/12/09 상품등록
	 * @author 심규영
	 * @param vo
	 */
	public int insertProduct(ProductVO vo) {
		return dao.insertProduct(vo);
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
