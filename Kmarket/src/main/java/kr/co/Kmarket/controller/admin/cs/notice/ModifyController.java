package kr.co.Kmarket.controller.admin.cs.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.cs.CsNoticeService;
import kr.co.Kmarket.vo.cs.CsNoticeVO;

@WebServlet("/admin/cs/notice/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsNoticeService service = CsNoticeService.instance;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 넘어오는 정보
		String noticeNo = req.getParameter("n");
		
		// 게시물 정보 받기
		CsNoticeVO vo = service.selectNoticeWithNoticeNo(noticeNo);
		
		// 리턴
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/admin/cs/notice/modify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 값 받기
		CsNoticeVO vo = service.insertCsNoticeVO(req);
		
		// 데이터 베이스 수정
		int result = service.updateCsNotice(vo);
		
		// 값 리턴
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		resp.getWriter().write(json.toString());
	}
}
