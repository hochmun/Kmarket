package kr.co.Kmarket.controller.admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.Kmarket.service.admin.AdminService;
import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.Cate2VO;
import kr.co.Kmarket.vo.cs.CsCate2VO;

@WebServlet("/admin/product/getCate2.do")
public class GetCate2Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AdminService service = AdminService.INSTANCE;
	private CsService service2 = CsService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 출력 인코딩 설정
		resp.setContentType("application/json;charset=UTF-8");
		// 카테고리2 불러오기
		List<Cate2VO> vos = service.selectcate2(req.getParameter("cate1"));
		// 출력
		resp.getWriter().print(new Gson().toJson(vos));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 출력 인코딩 설정
		resp.setContentType("application/json;charset=UTF-8");
		// 카테고리2 불러오기
		List<CsCate2VO> vos = service2.selectCsCate2(req.getParameter("cate1"));
		// 출력
		resp.getWriter().print(new Gson().toJson(vos));
	}
}
