package kr.co.Kmarket.controller.admin.cs.faq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsFaqService;
import kr.co.Kmarket.vo.cs.CsFaqVO;

@WebServlet("/admin/cs/faq/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsFaqService service = CsFaqService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 들어오는 값 => 게시물 번호
		String faqNo = req.getParameter("faqNo");
		
		// 게시물 번호에 따른 게시물 정보 불러오기
		CsFaqVO vo = service.selectCsFaqWithFaqNo(faqNo);
		
		// 전송
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/admin/cs/faq/view.jsp").forward(req, resp);
	}
}
