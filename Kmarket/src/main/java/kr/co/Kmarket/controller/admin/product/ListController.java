package kr.co.Kmarket.controller.admin.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.admin.AdminService;

@WebServlet("/admin/product/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 페이징 처리
		service.pagingService(req);
		
		// 포워드
		req.getRequestDispatcher("/admin/product/list.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 삭제 기능
		// 받아오는 정보
		String prodNo = req.getParameter("prodNo");
		
		// 배열로 변경
		String[] arrays = prodNo.split(",");
		
		// 데이터 베이스에서 삭제
		int result = service.deleteProductWithProdNos(arrays);
		
		// 리턴
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		resp.getWriter().write(json.toString());
	}
}
