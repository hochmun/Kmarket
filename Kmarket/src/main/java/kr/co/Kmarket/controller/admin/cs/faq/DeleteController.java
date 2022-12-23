package kr.co.Kmarket.controller.admin.cs.faq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.cs.CsFaqService;

@WebServlet("/admin/cs/faq/delete.do")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsFaqService service = CsFaqService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 받아오는 정보
		String faqNo = req.getParameter("faqNo");
		
		// 배열로 변경
		String[] arrays = faqNo.split(",");
		
		// 데이터 베이스에서 삭제
		service.deleteCsFaqNoWithFaqNo(arrays);
		
		// 페이지 이동
		req.getSession().setAttribute("success", "602");
		resp.sendRedirect("/Kmarket/loadingPage.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 받아오는 정보
		String faqNo = req.getParameter("faqNo");
		
		// 배열로 변경
		String[] arrays = faqNo.split(",");
		
		// 데이터 베이스에서 삭제
		int result = service.deleteCsFaqNoWithFaqNo(arrays);
		
		// 리턴
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		resp.getWriter().write(json.toString());
	}
}
