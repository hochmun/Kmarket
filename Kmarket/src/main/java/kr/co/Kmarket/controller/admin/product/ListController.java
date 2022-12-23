package kr.co.Kmarket.controller.admin.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		req.getRequestDispatcher("/admin/product/list.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
