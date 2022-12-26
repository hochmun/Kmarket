package kr.co.Kmarket.controller.cs.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsNoticeService;
import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsNoticeVO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/cs/notice/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsNoticeService service = CsNoticeService.instance;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 들어오는 값
		String cate1 = req.getParameter("c");
		if(cate1 == "" || cate1 == null ) cate1 = "%%";
		
		String pg = req.getParameter("pg");
		if(pg == "" || pg == null) pg = "1";
		
		// 페이징 처리	
		service.paing(req, pg , cate1);
		
		req.setAttribute("c", req.getAttribute("c"));
		
		req.getRequestDispatcher("/cs/notice/list.jsp").forward(req, resp);
	}
}
