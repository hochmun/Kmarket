package kr.co.Kmarket.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.Kmarket.service.product.ProductService;

@WebServlet("/product/getside.do")
public class GetCate1Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		
		// cate1 값이 없으면 cate1 가져오기
		// cate1 값이 있으면 해당 category의 cate2 가져 오기
		if(req.getParameter("cate1") == null || req.getParameter("cate1") == "")
			resp.getWriter().print(new Gson().toJson(service.selectcate1()));
		else resp.getWriter().print(
				new Gson().toJson(service.selectcate2(req.getParameter("cate1"))));
	}
	
}
