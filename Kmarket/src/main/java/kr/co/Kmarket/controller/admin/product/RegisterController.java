package kr.co.Kmarket.controller.admin.product;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.admin.AdminService;

@WebServlet("/admin/product/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> voss = service.selectcate();
		req.setAttribute("c1vos", voss.get("c1vos"));
		req.setAttribute("c2vos", voss.get("c2vos"));
		req.getRequestDispatcher("/admin/product/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
