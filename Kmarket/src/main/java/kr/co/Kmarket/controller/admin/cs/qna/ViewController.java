package kr.co.Kmarket.controller.admin.cs.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.Kmarket.service.admin.AdminServiceQna;
import kr.co.Kmarket.service.cs.CsQnaService;
import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/admin/cs/qna/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsQnaService service = CsQnaService.INSTANCE;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CsQnaVO> vos = service.selectCsQnaList();
		req.setAttribute("vos", vos);
		
		req.getRequestDispatcher("/admin/cs/qna/view.jsp").forward(req, resp);
	}
}
