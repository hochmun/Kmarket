package kr.co.Kmarket.controller.admin.cs.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsNoticeService;
import kr.co.Kmarket.vo.cs.CsNoticeVO;

@WebServlet("/admin/cs/notice/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsNoticeService service = CsNoticeService.instance;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noticeNo = req.getParameter("n");
		
		CsNoticeVO vo = service.selectNoticeWithNoticeNo(noticeNo);
		
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/admin/cs/notice/view.jsp").forward(req, resp);
	}
}
