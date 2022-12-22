package kr.co.Kmarket.controller.admin.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.admin.AdminService;
import kr.co.Kmarket.vo.ProductVO;

@WebServlet("/admin/product/register.do")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 2,
		maxRequestSize = 1024 * 1024 * 5
		)
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 카테고리1 리스트 불러오기
		req.setAttribute("vos", service.selectcate1());
		// 포워드
		req.getRequestDispatcher("/admin/product/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		// 업로드 디렉터리의 물리적 경로 확인
		String cate1 = req.getParameter("category1");
		String cate2 = req.getParameter("category2");
		String saveDirectory = "/home/kmarket/thumb/"+cate1+"/"+cate2+"/";
		
		// 디렉토리 생성
		service.dirCreate(saveDirectory);
		
		// 첨부 파일 최대 용량 설정 - 1MB
		//int maxPostSize = 1024*1024;
		
		// 폼값을 vo에 저장
		ProductVO vo = service.insertProductVO(req);
		
		// 파일 업로드
		//MultipartRequest mr = service.uploadFile(req, saveDirectory, maxPostSize);
		vo = service.uploadFile2(req, saveDirectory, vo);
		
		// 데이터 베이스 처리
		int result = service.insertProduct(vo);
		
		// 이동
		if (result == 0) req.getSession().setAttribute("success", "600"); // 실패시
		else req.getSession().setAttribute("success", "601"); // 성공시
		
		resp.sendRedirect("/Kmarket/loadingPage.do");
	}
}
