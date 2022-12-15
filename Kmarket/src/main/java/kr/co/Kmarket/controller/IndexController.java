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
import kr.co.Kmarket.vo.ProductVO;

@WebServlet("/index.do")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 카테고리 불러 오기
		List<Cate1VO> vos1 = service.selectcate1();
		Map<String, Object> voss = service.selectCate1Cate2();
		
		// 베스트 상품 불러 오기 => sold 많은 순서, 5개
		List<ProductVO> vos3 = service.selectProductBest();
		
		// 히트 상품 불러 오기 => hit 많은 순서, 8개
		List<ProductVO> vos4 = service.selectProductListMode3(1);
		
		// 추천 상품 불러 오기 => score 많은 순서, 8개
		List<ProductVO> vos5 = service.selectProductListMode3(2);
		
		// 최신 상품 불러 오기 => date 최근 일수, 8개
		List<ProductVO> vos6 = service.selectProductListMode3(4);
		
		// 할인 상품 불러 오기 => discount 많은 순서, 8개
		List<ProductVO> vos7 = service.selectProductListMode3(3);
		
		// 불러온 정보 저장
		req.setAttribute("vos1", vos1);
		req.setAttribute("vos2", voss.get("vos2"));
		req.setAttribute("vos3", vos3);
		req.setAttribute("vos4", vos4);
		req.setAttribute("vos5", vos5);
		req.setAttribute("vos6", vos6);
		req.setAttribute("vos7", vos7);
		
		// 페이지 포워드
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
