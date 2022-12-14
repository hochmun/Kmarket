package kr.co.Kmarket.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.product.ProductService;
import kr.co.Kmarket.vo.Cate1VO;

@WebServlet("/index.do")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> voss = service.selectCate1Cate2();
		
		req.setAttribute("vos1", voss.get("vos1"));
		req.setAttribute("vos2", voss.get("vos2"));
		
		// 페이지 포워드
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
