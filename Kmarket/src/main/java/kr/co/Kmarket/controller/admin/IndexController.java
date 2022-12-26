package kr.co.Kmarket.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsNoticeService;
import kr.co.Kmarket.service.cs.CsQnaService;
import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.service.member.MemberService;
import kr.co.Kmarket.vo.AdminVO;
import kr.co.Kmarket.vo.MemberVO;
import kr.co.Kmarket.vo.cs.CsNoticeVO;
import kr.co.Kmarket.vo.cs.CsQnaVO;

@WebServlet("/admin/index.do")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsNoticeService service1 = CsNoticeService.instance;
	private CsQnaService service2 = CsQnaService.INSTANCE;
	private CsService service3 = CsService.INSTANCE;
	private MemberService service4 = MemberService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 쇼핑몰 운영현황 가져오기
		AdminVO vo3 = service3.selectAll();
		
		// 공지사항 가져오기
		List<CsNoticeVO> vos1 = service1.selectCsNoticeListLimit5();
		
		// 고객문의 가져오기
		List<CsQnaVO> vos2 = service2.selectCsQnaListLimit5();
		
		// 멤버 가져오기
		//List<MemberVO> vos4 = service3.selectTopManager();
		
		// 전송
		req.setAttribute("vos1", vos1);
		req.setAttribute("vos2", vos2);
		req.setAttribute("vo3", vo3);
		//req.setAttribute("vos4", vos4);
		
		req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}