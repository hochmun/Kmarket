package kr.co.Kmarket.controller.admin.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.Kmarket.service.admin.AdminService;
import kr.co.Kmarket.vo.ProductVO;

@WebServlet("/admin/product/register.do")
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
		// 업로드 디렉터리의 물리적 경로 확인
		String saveDirectory = req.getServletContext().getRealPath("/thumb");
		
		// 디렉토리 생성
		service.dirCreate(saveDirectory);
		
		// 첨부 파일 최대 용량 설정 - 1MB
		int maxPostSize = 1024*1024;
		
		// 파일 업로드
		MultipartRequest mr = service.uploadFile(req, saveDirectory, maxPostSize);
		
		// 폼값을 vo에 저장
		ProductVO vo = service.insertProductVO(req, mr, saveDirectory);
		
		// 데이터 베이스 처리
		service.insertProduct(vo);
		
		// TODO - 나중에 이동 페이지 수정할것
		// 이동
		resp.sendRedirect("/Kmarket/admin/product/register.do");
	}
}
