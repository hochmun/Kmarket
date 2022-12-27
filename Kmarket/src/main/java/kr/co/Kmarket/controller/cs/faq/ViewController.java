package kr.co.Kmarket.controller.cs.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsFaqService;
import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsFaqVO;

@WebServlet("/cs/faq/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsService service2 = CsService.INSTANCE;
	private CsFaqService service = CsFaqService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 카테고리1 정보 가져오기
		List<CsCate1VO> vos2 = service2.selectCsCate1();
		
		// 게시물 번호 받기
		String faqNo = req.getParameter("faqNo");
		
		// 게시물 번호로 게시물 정보 받기
		CsFaqVO vo = service.selectCsFaqWithFaqNo(faqNo);
		
		// 저장
		req.setAttribute("vo", vo);
		req.setAttribute("vos2", vos2);
		
		req.getRequestDispatcher("/cs/faq/view.jsp").forward(req, resp);
	}
}
