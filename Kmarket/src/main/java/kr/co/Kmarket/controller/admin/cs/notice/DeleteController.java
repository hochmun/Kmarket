package kr.co.Kmarket.controller.admin.cs.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.cs.CsFaqService;
import kr.co.Kmarket.service.cs.CsNoticeService;

@WebServlet("/admin/cs/notice/delete.do")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsNoticeService service = CsNoticeService.instance;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 받아오는 정보
		String n = req.getParameter("n"); // 번호
		String t = req.getParameter("t"); // 전송 타입 (1:일반,2:json)
		
		// 배열로 변경
		String[] arrays = n.split(",");
		
		// 데이터 베이스에서 삭제
		int result = service.deleteCsFaqNoWithNoticeNo(arrays);
		
		// 결과
		if(t.equals("1")) {
			// 페이지 이동
			req.getSession().setAttribute("success", "602");
			resp.sendRedirect("/Kmarket/loadingPage.do");
		} else if(t.equals("2")) {
			// 리턴
			JsonObject json = new JsonObject();
			json.addProperty("result", result);
			resp.getWriter().write(json.toString());
		}
		
	}
}
