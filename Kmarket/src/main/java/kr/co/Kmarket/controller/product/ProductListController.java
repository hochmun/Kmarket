package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		if(pg == null || pg.trim().equals("")){
		pg = "0";
		}
		
		/*product list 가져오기*/
		List<ProductVO> pvos = service.selectProducts(prodCate1, prodCate2);
		/*prodCate 가져오기*/
		Cate1VO cvo = service.selectProdCates(prodCate1, prodCate2);
		
		/**
		 * 페이징
		 */
		
		/*전체 상품 수 가져오기*/
		int total = service.selectCountProducts(prodCate1, prodCate2);
		
		/*페이지 처리*/
		int lastPageNum = service.getLastPageNum(total);
		int currentPage = service.getCurrentPage(pg);
		int limitStart = service.getLimitStart(currentPage);
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);
		int pageStartNum = service.getPageStartNum(total, limitStart);
		int start = service.getStartNum(currentPage);
		
		
		req.setAttribute("cvo", cvo); // selectProducts
		req.setAttribute("pg", pg); 
		req.setAttribute("pvos", pvos);
		
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("limitStart", limitStart);
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("start", start);
		req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
		}
	}
