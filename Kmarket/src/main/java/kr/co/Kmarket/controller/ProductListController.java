package kr.co.Kmarket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.Kmarket.service.product.ProductService;
import kr.co.Kmarket.vo.Cate1VO;
import kr.co.Kmarket.vo.ProductVO;

@WebServlet("/product/list.do")
public class ProductListController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodCate1 = req.getParameter("cate1");
		String prodCate2 = req.getParameter("cate2");
		
		String pg = req.getParameter("pg");
		
		/*페이징*/		
		int boardPaging = service.selectCountProducts(prodCate1, prodCate2);
					
		
		/*product list 가져오기*/
		List<ProductVO> pvos = service.selectProducts(prodCate1, prodCate2);
		/*prodCate 가져오기*/
		Cate1VO cvo = service.selectProdCates(prodCate1, prodCate2);
		/*카테고리별 전체 상품 갯수 + 검색기능(beta) */
		int total = service.selectCountProducts(prodCate1, prodCate2);
		
		/*판매 분류*/
		List<ProductVO> prods1 = service.SelectProductSold(prodCate1, prodCate2);
		List<ProductVO> prods2 = service.SelectProductLow(prodCate1, prodCate2);
		List<ProductVO> prods3 = service.SelectProductHigh(prodCate1, prodCate2);
		List<ProductVO> prods4 = service.SelectProductHstar(prodCate1, prodCate2);
		List<ProductVO> prods5 = service.SelectProductReview(prodCate1, prodCate2);
		List<ProductVO> prods6 = service.SelectProductLatest(prodCate1, prodCate2);
		
		/*다수의 판매분류 item을 하나의 list로 추가(beta) [작동 안될 시 item별로 controller 만들어야 함]*/
		List<ProductVO> prods = new ArrayList<>();
		prods.addAll(prods1);
		prods.addAll(prods2);
		prods.addAll(prods3);
		prods.addAll(prods4);
		prods.addAll(prods5);
		prods.addAll(prods6);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(prods);
		
		resp.setContentType("application/json;charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.print(jsonData);
		
		req.setAttribute("cvo", cvo); // selectProducts 
		req.setAttribute("total", total); 
		req.setAttribute("prods", prods); 
		req.setAttribute("pg", pg); 
		req.setAttribute("pvos", pvos);
		req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
		
		
	}
}
