package kr.co.Kmarket.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.product.ProductCartService;
import kr.co.Kmarket.service.product.ProductService;
import kr.co.Kmarket.vo.ProductCartVO;
import kr.co.Kmarket.vo.ProductVO;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	private ProductCartService service2 = ProductCartService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 상품 정보 가져오기
		ProductVO vo = service.selectProductWithProdNo(req.getParameter("prodNo"));
		
		// 상품 정보 방문시 방문 횟수 늘리기
		service.updateProductHitCount(vo.getProdNo());
		
		// 카테고리 이름 불러오기
		String cate1 = service.formatCate1Name(vo.getProdCate1());
		String cate2 = service.formatCate2Name(vo.getProdCate1(), vo.getProdCate2());
		
		// 할인율 계산
		double discount = vo.getDiscount();
		int price = vo.getPrice();
		int disprice = 0;
		if(discount > 0) {
			disprice = (int)(price * (1 - (discount / 100)));
		}
		
		// 포워드
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		req.setAttribute("disprice", disprice);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/product/view.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 카트에 등록할 상품 정보 vo에 저장
		ProductCartVO vo = service2.insertProductCartVO(req);
		
		// type에 따라 처리
		String type = req.getParameter("type");
		
		int result = 0;
		
		if(type.equals("cart")) {
			// 데이터 베이스에 저장
			result = service2.insertProductCart(vo);
		}
		
		if(type.equals("order")) {
			// 상품 정보를 세션에 저장
			req.getSession().setAttribute("prodNo", vo);
			result = vo.getProdNo();
		}
		
		// json 저장
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		// 출력
		resp.getWriter().write(json.toString());
	}
}
