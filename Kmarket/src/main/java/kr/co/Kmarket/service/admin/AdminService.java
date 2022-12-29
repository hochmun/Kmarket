package kr.co.Kmarket.service.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;

import kr.co.Kmarket.dao.product.ProductDAO;
import kr.co.Kmarket.vo.Cate1VO;
import kr.co.Kmarket.vo.Cate2VO;
import kr.co.Kmarket.vo.MemberVO;
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
		
		// 셀러 이름을 회사 로그인한 판매자의 회사 이름에서 가져옴
		MemberVO vo2 = (MemberVO) req.getSession().getAttribute("sessUser");
		if(vo2.getCompany() != null) {
			vo.setSeller(vo2.getCompany());
			vo.setUid(vo2.getUid());
		}
		
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
	
	 /**
	  * 2022/12/23 product/list 페이징 처리
	  * @author 심규영
	  * @param req
	  */
	 public void pagingService(HttpServletRequest req) {
		 // 들어오는 값
		 String pg = req.getParameter("pg"); // 현제 페이지 번호
		 String searchType = req.getParameter("st"); // 검색한 내용 종류
		 String search = req.getParameter("s"); // 검색한 게시물
		 MemberVO vo = null;
		 
		 // 세션에서 로그인한 유저 정보 가져오기
		 HttpSession sess = req.getSession();
		 if(sess.getAttribute("sessUser") != null) vo = (MemberVO)sess.getAttribute("sessUser");
		 
		 // pg값이 있을 경우
		 int currentPage = 1;
		 if(pg != null) currentPage = Integer.parseInt(pg); // 현제 페이지를 pg로 지정
		 
		 // 중간쿼리문
		 String queryMid = "";
		 if((search != null && search != "") && (searchType != null && searchType != "")) queryMid = createSql(search, searchType);
		 
		 // 총 게시물 번호 => 로그인한 유저가 판매자일 경우 , 최고 관리자일 경우
		 int total = 0;
		 if(vo.getType() == 2) total = dao.selectCountProductWithUid(vo.getUid(), queryMid); // 판매자가 올린 상품만 조회
		 if(vo.getType() == 5) total = dao.selectCountProduct(queryMid); // 전체 상품 조회
		 
		 // 마지막 페이지 계산
		 int lastPageNum = 0;
		 if(total % 10 != 0) lastPageNum = (total/10)+1;
		 else lastPageNum = (total/10);
		 
		 // limit 시작값 계산
		 int limitStart = (currentPage - 1) * 10;
		 
		// 페이지 그룹 계산
		int pageGroupCurrent = (int)Math.ceil(currentPage/10.0);
		int pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
		int pageGroupEnd = pageGroupCurrent * 10;
		if (pageGroupEnd > lastPageNum) pageGroupEnd = lastPageNum;
		
		// 페이지 시작 번호 계산
		int pageStartNum = total - limitStart;
		
		// 페이지 불러오기
		List<ProductVO> vos = dao.selectProductPageList(limitStart, queryMid,vo);
		
		// 검색어 강조 기능
		if(search != null && searchType != null) {
			searchAccent(search, vos, searchType);
		}
		
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("vos", vos);
	 }
	 
	 /**
	  * 2022/12/29 검색어 강조 기능
	  * @author 심규영
	  * @param search - 검색어
	  * @param vos - 검색된 리스트
	  * @param searchType - 검색 하는 타입
	  */
	 public void searchAccent(String search, List<ProductVO> vos, String searchType) {
		 for (int i = 0; i < vos.size(); i++) {
			ProductVO pvo = vos.get(i);
			if(searchType.equals("prodName")) pvo.setProdName(pvo.getProdName().replace(search, "<em style='background-color : yellow;'>"+search+"</em>"));
			if(searchType.equals("company")) pvo.setCompany(pvo.getCompany().replace(search, "<em style='background-color : yellow;'>"+search+"</em>"));
			if(searchType.equals("seller")) pvo.setSeller(pvo.getSeller().replace(search, "<em style='background-color : yellow;'>"+search+"</em>"));
			vos.set(i, pvo);
		}
	 }
	 
	 /**
	  * 동적 중간 쿼리 작성 기능</br>
	  * 마스터피스(%)를 통한 전체 검색
	  * @param search => 검색어
	  * @param searchType => 검색위치
	  * @return String 완성된 중간 쿼리문
	  */
	 public String createSql(String search, String searchType) {
		 String queryMid = "";
		 
		 queryMid = "AND `"+searchType+"` LIKE '%"+search+"%' ";
		 
		 return queryMid;
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
 	/**
 	 * 2022/12/23 관리자/상품/리스트 상품 삭제 기능
 	 * @author 심규영
 	 * @param arrays
 	 * @return
 	 */
 	public int deleteProductWithProdNos(String[] arrays) {
 		return dao.deleteProductWithProdNos(arrays);
 	}

}
