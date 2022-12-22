package kr.co.Kmarket.controller.admin.cs.qna;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.Kmarket.service.admin.AdminServiceQna;
import kr.co.Kmarket.service.cs.CsFaqService;
import kr.co.Kmarket.service.cs.CsQnaService;
import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/admin/cs/qna/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsQnaService service = CsQnaService.INSTANCE;
	private CsService service2 = CsService.INSTANCE;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CsQnaVO> vos = service.selectCsQnaList();
		List<CsCate1VO> vos2 = service2.selectCsCate1();
		
		req.setAttribute("vos", vos);
		req.setAttribute("vos2", vos2);
		req.getRequestDispatcher("/admin/cs/qna/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		List<CsQnaVO> vos = service.selectCsQnaListCate(cate1, cate2);
		
		resp.getWriter().write(new Gson().toJson(vos));
	}
}
