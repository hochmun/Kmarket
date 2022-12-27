package kr.co.Kmarket.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsNoticeService;
import kr.co.Kmarket.service.cs.CsQnaService;
import kr.co.Kmarket.vo.cs.CsNoticeVO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/cs/index.do")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsNoticeService service1 = CsNoticeService.instance;
	private CsQnaService service2 = CsQnaService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 공지 사항 불러오기 5개
		List<CsNoticeVO> vos1 = service1.selectCsNoticeListLimit5();
		
		// 문의 하기 불러오기 5개
		List<CsQnaVO> vos2 = service2.selectCsQnaListLimit5();
		
		req.setAttribute("vos1", vos1);
		req.setAttribute("vos2", vos2);
		
		req.getRequestDispatcher("/cs/index.jsp").forward(req, resp);
	}
}
