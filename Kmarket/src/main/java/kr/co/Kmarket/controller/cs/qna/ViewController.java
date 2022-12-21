package kr.co.Kmarket.controller.cs.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/cs/qna/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsService service = CsService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qnaNo = req.getParameter("no");
		String cate1 = req.getParameter("cate1");
		
		CsQnaVO article = service.selectQnaArticle(qnaNo);
		
		req.setAttribute("article", article);
		req.setAttribute("cate1", cate1);
		req.getRequestDispatcher("/cs/qna/view.jsp").forward(req, resp);
	}
}
