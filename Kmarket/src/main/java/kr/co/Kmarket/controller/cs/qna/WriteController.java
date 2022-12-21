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
		String cate1 = req.getParameter("cate1");
		
		req.setAttribute("cate1", cate1);
		req.getRequestDispatcher("/cs/qna/write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int qnaCate1 = Integer.parseInt(req.getParameter("qnaCate1"));
		int qnaCate2 = Integer.parseInt(req.getParameter("qnaCate2"));
		String qnaTitle = req.getParameter("qnaTitle");
		String qnaContent = req.getParameter("qnaContent");
		String uid = req.getParameter("uid");
		String qnaRegip = req.getParameter("qnaRegip");
		
		CsQnaVO vo = new CsQnaVO();
				vo.setQnaCate1(qnaCate1);
				vo.setQnaCate2(qnaCate2);
				vo.setQnaTitle(qnaTitle);
				vo.setQnaContent(qnaContent);
				vo.setUid(uid);
				vo.setQnaRegip(qnaRegip);
				
				int result = service.insertQnaArticle(vo);
				if(result > 0) {
					resp.sendRedirect("/cs/qna/list.do?cate1="+qnaCate1);
				}
	}
}
