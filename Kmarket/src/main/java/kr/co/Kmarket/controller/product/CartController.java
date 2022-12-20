package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.product.ProductCartService;
import kr.co.Kmarket.vo.MemberVO;
import kr.co.Kmarket.vo.ProductCartVO;

@WebServlet("/product/cart.do")
public class CartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductCartService service = ProductCartService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		// 로그인 되어 있지 않을 경우 쿠키?에서 가져오기 => 나중에 처리
		
		// 로그인이 되어 있을 경우
		if(sess.getAttribute("sessUser") != null) {
			
			// 유저 정보로 장바구니 가져오기
			List<ProductCartVO> vos = service.selectProductCartWithUid(((MemberVO)sess.getAttribute("sessUser")).getUid());
			
			// 저장
			req.setAttribute("vos", vos);
			
			req.getRequestDispatcher("/product/cart.jsp").forward(req, resp);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// checkArray값이 없을 경우 0, 있으면 1
		int result = 0;
		
		// 값이 있을 경우
		if(req.getParameterValues("checkArray") != null) {
			result = 1;
			
			// 배열 값 받기
			String[] cartNos = req.getParameterValues("checkArray");
			
			// 콤마 단위로 입력
			String cartNo = "";
			for(String no : cartNos) {
				cartNo += no + ",";
			}
			
			// 값 세션에 넣기
			req.getSession().setAttribute("cartNo", cartNo);
		}
		
		// 출력
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		resp.getWriter().write(json.toString());
	}
}
