package kr.co.Kmarket.controller.cs.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsNoticeService;
import kr.co.Kmarket.vo.cs.CsFaqVO;
import kr.co.Kmarket.vo.cs.CsNoticeVO;

@WebServlet("/cs/notice/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsNoticeService service = CsNoticeService.instance;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		if(cate1 == "" || cate1 == null ) cate1 = "%%";
		
		String pg = req.getParameter("pg");
		if(pg == "" || pg == null) pg = "1";
		
		String noticeNo = req.getParameter("no");
		
		CsNoticeVO vo = service.selectCsNoticeWithNoticeNo(noticeNo);
		
		req.setAttribute("vo", vo);
		req.setAttribute("pg", pg);
		req.setAttribute("cate1", cate1);
		req.getRequestDispatcher("/cs/notice/view.jsp").forward(req, resp);
		
	}
}
