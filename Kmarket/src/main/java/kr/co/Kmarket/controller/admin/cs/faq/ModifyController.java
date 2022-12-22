package kr.co.Kmarket.controller.admin.cs.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.cs.CsFaqService;
import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsFaqVO;

@WebServlet("/admin/cs/faq/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsFaqService service = CsFaqService.INSTANCE;
	private CsService service2 = CsService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 기본으로 넘어 오는 정보
		String faqNo = req.getParameter("faqNo");
		
		// 넘어 오는 정보로 게시물 정보 불러오기
		CsFaqVO vo = service.selectCsFaqWithFaqNo(faqNo);
		
		// 카테고리1 값 불러오기, 현재 카테고리1의 카테고리2값 불러오기
		List<CsCate1VO> vos2 = service2.selectCsCate1();
		List<CsCate2VO> vos3 = service2.selectCsCate2(vo.getFaqCate1()+"");
		
		// 리턴
		req.setAttribute("vo", vo);
		req.setAttribute("vos2", vos2);
		req.setAttribute("vos3", vos3);
		
		req.getRequestDispatcher("/admin/cs/faq/modify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 들어오는값 받기
		CsFaqVO vo = service.insertCsFaqVO(req);
		
		// 데이터 베이스 수정
		int result = service.updateCsFaq(vo);
		
		// 리턴
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		resp.getWriter().write(json.toString());
	}
}
