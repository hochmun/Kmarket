package kr.co.Kmarket.controller;

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
		String titName = service.cateNameFormat(req.getParameter("cate1"), req.getParameter("cate2"));
		String search = req.getParameter("search");
		
		if(titName.equals("-1")) {
			// 보안 설정 - titName = -1 일때 /로 이동
			resp.sendRedirect("/Kmarket/");
		}else {
			// 게시물 페이징
			int limitStart = service.boardPaging(req, titName, search);
		}
		// 카테고리 조건별 불러오기
		
		
		// 목록 불러오기
		req.setAttribute("vos", service.selectcate2(search));
		req.getRequestDispatcher("/Kmarket/product/list.jsp").forward(req, resp);
		
		
	}
	

}
