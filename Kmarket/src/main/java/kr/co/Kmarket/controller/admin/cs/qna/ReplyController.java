package kr.co.Kmarket.controller.admin.cs.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.cs.CsQnaService;
import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/admin/cs/qna/reply.do")
public class ReplyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsQnaService service = CsQnaService.INSTANCE;
	private CsService service2 = CsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qnaNo = req.getParameter("qnaNo");

		CsQnaVO vo = service.selectCsQnaWithQnaNo(qnaNo);

		List<CsCate1VO> vos2 = service2.selectCsCate1();
		List<CsCate2VO> vos3 = service2.selectCsCate2(vo.getQnaCate1()+"");

		req.setAttribute("vo", vo);
		req.setAttribute("vos2", vos2);
		req.setAttribute("vos3", vos3);
		
		req.getRequestDispatcher("/admin/cs/qna/reply.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// qna 답변 post
		
		CsQnaVO vo = service.insertCsQnaVO(req);

		int result = service.updateQnaAdminContent(vo);
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		resp.getWriter().write(json.toString());
		
	}
}
