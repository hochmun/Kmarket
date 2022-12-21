package kr.co.Kmarket.controller.cs.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/cs/qna/write.do")
public class WriteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsService service = CsService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qnaCate1 = req.getParameter("cate1");
		
		req.setAttribute("cate1", qnaCate1);
		req.getRequestDispatcher("/cs/qna/write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qnaCate1 = req.getParameter("cate1");
		String qnaCate2 = req.getParameter("cate2");
		String qnaTitle = req.getParameter("title");
		String qnaContent = req.getParameter("content");
		String uid = req.getParameter("uid");
		String qnaRegip = req.getRemoteAddr();
		
		CsQnaVO vo = new CsQnaVO();
				vo.setQnaCate1(qnaCate1);
				vo.setQnaCate2(qnaCate2);
				vo.setQnaTitle(qnaTitle);
				vo.setQnaContent(qnaContent);
				vo.setUid(uid);
				vo.setQnaRegip(qnaRegip);
				
				int result = service.insertQnaArticle(vo);
				if(result > 0) {
					resp.sendRedirect("/Kmarket/cs/qna/list.do?cate1="+qnaCate1);
				}
	}
}
