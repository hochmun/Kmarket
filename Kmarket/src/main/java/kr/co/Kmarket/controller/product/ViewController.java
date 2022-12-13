package kr.co.Kmarket.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.product.ProductService;
import kr.co.Kmarket.vo.ProductVO;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 상품 정보 가져오기
		ProductVO vo = service.selectProductWithProdNo(req.getParameter("prodNo"));
		
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
}
