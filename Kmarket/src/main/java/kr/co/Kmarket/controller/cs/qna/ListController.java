package kr.co.Kmarket.controller.cs.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/cs/qna/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsService service = CsService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate1 = req.getParameter("cate1");
		// 페이징
		String pg = req.getParameter("pg");
		if(pg == null || pg.trim().equals("")){
			pg = "1";
			}
		
		CsCate1VO vos = service.selectCsCate(cate1);
		int total = service.selectCountTotal(cate1);
		int limitStart = service.boardPaging(req, cate1);
		
		List<CsQnaVO> QnaArts = null;
		QnaArts = service.selectQnaArticles(cate1, limitStart);
		
		req.setAttribute("cate1", cate1);
		req.setAttribute("QnaArts", QnaArts);
		req.setAttribute("articles", service.selectQnaArticles(cate1, limitStart));
		req.setAttribute("pg", pg);
		req.setAttribute("vos", vos);
		req.setAttribute("total", total);
		req.setAttribute("limitStart", limitStart);
		req.getRequestDispatcher("/cs/qna/list.jsp").forward(req, resp);
	}
}
