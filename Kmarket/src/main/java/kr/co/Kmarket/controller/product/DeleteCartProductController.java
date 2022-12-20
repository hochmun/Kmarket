package kr.co.Kmarket.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.product.ProductCartService;

@WebServlet("/product/deleteProduct.do")
public class DeleteCartProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductCartService service = ProductCartService.INSTANCE;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 상품 번호 가져오기
		String[] cartNos = req.getParameterValues("cartNos");
		
		// 장바구니에서 상품 정보 제거
		int result = service.deleteProductCartWithCartNos(cartNos);
		
		// json 출력
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		resp.getWriter().print(json.toString());
	}
}
