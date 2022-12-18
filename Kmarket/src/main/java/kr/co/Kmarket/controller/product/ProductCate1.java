package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.Kmarket.service.product.ProductService;
import kr.co.Kmarket.vo.ProductVO;

@WebServlet("/product/ProductCate1.do")
public class ProductCate1 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodCate1 = req.getParameter("cate1");
		String prodCate2 = req.getParameter("cate2");
		
		List<ProductVO> prods = service.SelectProductSold(prodCate1, prodCate2);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(prods);
		resp.setContentType("application/json;charset=UTF-8");	
		
		PrintWriter writer = resp.getWriter();
		writer.print(jsonData);
	}

}
