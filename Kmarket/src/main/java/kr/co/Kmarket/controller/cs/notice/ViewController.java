package kr.co.Kmarket.controller.cs.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsNoticeService;
import kr.co.Kmarket.vo.cs.CsFaqVO;

@WebServlet("/cs/notice/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsNoticeService serivce = CsNoticeService.instance;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cv");
		if(cate1 == "" || cate1 == null ) cate1 = "%%";
		
		String pg = req.getParameter("pg");
		if(pg == "" || pg == null) pg = "1";
		
		req.getAttribute("cv");
		
		req.getRequestDispatcher("/cs/notice/view.jsp").forward(req, resp);
		
	}
}
