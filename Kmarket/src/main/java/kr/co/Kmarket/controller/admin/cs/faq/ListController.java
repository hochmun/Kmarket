package kr.co.Kmarket.controller.admin.cs.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.Kmarket.service.cs.CsFaqService;
import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsFaqVO;

@WebServlet("/admin/cs/faq/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsFaqService service = CsFaqService.INSTANCE;
	private CsService service2 = CsService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 들어오는 값 없음 => 페이지 동적 처리
		// 처음 페이지 들어올 때 전체 게시물 목록에서 조회수 순 상위 10개만 가져오기
		List<CsFaqVO> vos = service.selectCsFaqListLimit10();
		
		// cate1값 가져오기
		List<CsCate1VO> vos2 = service2.selectCsCate1();
		
		// 전송
		req.setAttribute("vos", vos);
		req.setAttribute("vos2", vos2);
		
		req.getRequestDispatcher("/admin/cs/faq/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 출력 인코딩 설정
		resp.setContentType("application/json;charset=UTF-8");
		
		// 동적 처리 들어오는 값 받기
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		// 카테고리에 따른 10개 게시물 받아서 내보내기
		List<CsFaqVO> vos = service.selectCsFaqListWithCate1AndCate2(cate1, cate2);
		
		// 전송
		resp.getWriter().write(new Gson().toJson(vos));
	}
}
