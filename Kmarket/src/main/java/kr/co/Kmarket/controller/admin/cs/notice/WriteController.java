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

@WebServlet("/admin/cs/notice/write.do")
public class WriteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsNoticeService service =  CsNoticeService.instance;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/admin/cs/notice/write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 들어오는 값 받기
		CsNoticeVO vo = service.insertCsNoticeVO(req);
		
		// 데이터 베이스 등록
		int result = service.insertCsNotice(vo);
		
		// 결과 리턴
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		resp.getWriter().write(json.toString());
	}
}
