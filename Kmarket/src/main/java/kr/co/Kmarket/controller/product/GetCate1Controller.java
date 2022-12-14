package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.Kmarket.service.product.ProductService;
import kr.co.Kmarket.vo.Cate1VO;
import kr.co.Kmarket.vo.Cate2VO;
@WebServlet("/Kmarket/getLatests.do")
public class GetCate1Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		String cate1 = req.getParameter("cate1");
		//if( cate1 == "" || cate1 == null ) List<Cate1VO> vos = service.selectcate1();
		//else List<Cate2VO> vos = service.selectcate2(cate1);
		
		
		//resp.getWriter().print(new Gson().toJson(vos));
	}

}
