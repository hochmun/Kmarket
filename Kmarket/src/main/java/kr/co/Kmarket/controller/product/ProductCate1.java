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
import com.google.gson.JsonObject;

import kr.co.Kmarket.service.product.ProductService;
import kr.co.Kmarket.vo.ProductVO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/product/ProductCate1.do")
public class ProductCate1 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pg = req.getParameter("pg");
		if(pg == null || pg.trim().equals("")){
		pg = "1";
		}
		JsonObject json = new JsonObject();
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		if(cate1 == null) cate1 = "";
		if(cate2 == null) cate2 = "";
		
		int limitStart = service.boardPaging(req, pg, json, cate1, cate2);
		
		List<ProductVO> vos = service.SelectProductSold(cate1, cate2, limitStart);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(vos);

		resp.setContentType("application/json;charset=UTF-8");	
		
		PrintWriter writer = resp.getWriter();
		writer.print(jsonData);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		String pg = req.getParameter("pg");
		if(pg == null || pg.trim().equals("")){
		pg = "1";
		}
		JsonObject json = new JsonObject();
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		if(cate1 == null) cate1 = "";
		if(cate2 == null) cate2 = "";
		
		int limitStart = service.boardPaging(req, pg, json, cate1, cate2);
		List<ProductVO> vos = service.SelectProductSold(cate1, cate2, limitStart);
		
		String jsonStr = json.toString();
		String vosStr = jsonStr.substring(0, jsonStr.length()-1) 
				+",\"vos\":"+ (new Gson().toJson(vos))+"}";
		
		PrintWriter out = resp.getWriter();
		out.write(vosStr);
	}

}
