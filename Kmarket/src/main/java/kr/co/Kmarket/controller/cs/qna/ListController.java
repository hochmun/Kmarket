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
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/cs/qna/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsService service = CsService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cate1 = Integer.parseInt(req.getParameter("cate1"));
		// 페이징
		String pg = req.getParameter("pg");
		if(pg == null || pg.trim().equals("")){
			pg = "1";
			}
		String c1name = service.getC1name(cate1);
		req.setAttribute("cate1", cate1);
		req.setAttribute("c1name", c1name);
		
		int currentPage = service.getCurrentPage(pg);
		int total = service.selectCountTotal(cate1);
		int lastPageNum = service.getLastPageNum(total);
		int[] pageGroup = service.getPageGroupNum(currentPage, lastPageNum);
		int start = service.getStartNum(currentPage);
		List<CsQnaVO> QnaArts = null;
		QnaArts = service.selectQnaArticles(cate1, start);
		
		req.setAttribute("QnaArts", QnaArts);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupStart", pageGroup[0]);
		req.setAttribute("pageGroupEnd", pageGroup[1]);
		req.setAttribute("total", total);
		
		req.getRequestDispatcher("/cs/qna/list.jsp").forward(req, resp);
	}
}
