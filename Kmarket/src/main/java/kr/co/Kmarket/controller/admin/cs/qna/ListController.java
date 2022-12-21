package kr.co.Kmarket.controller.admin.cs.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.admin.AdminServiceQna;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/admin/cs/qna/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AdminServiceQna service = AdminServiceQna.INSTANCE;

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
		req.setAttribute("QnaArts", service.selectQnaArticles(cate1, limitStart));
		req.setAttribute("pg", pg);
		req.setAttribute("vos", vos);
		req.setAttribute("total", total);
		req.setAttribute("limitStart", limitStart);
		
		req.getRequestDispatcher("/admin/cs/qna/list.jsp").forward(req, resp);
	}
}
