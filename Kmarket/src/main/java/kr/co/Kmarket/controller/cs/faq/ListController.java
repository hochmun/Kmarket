package kr.co.Kmarket.controller.cs.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.cs.CsFaqService;
import kr.co.Kmarket.service.cs.CsService;
import kr.co.Kmarket.vo.cs.CsCate1VO;
import kr.co.Kmarket.vo.cs.CsCate2VO;
import kr.co.Kmarket.vo.cs.CsFaqVO;

@WebServlet("/cs/faq/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CsFaqService service = CsFaqService.INSTANCE;
	private CsService service2 = CsService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 넘어오는 csCate1정보 확인 => 없을 경우 기본 10으로 설정
		String csCate1 = req.getParameter("csCate1");
		if(csCate1 == "" || csCate1 == null) csCate1 = "10";
		
		// 카테고리1 정보 가져오기
		List<CsCate1VO> vos2 = service2.selectCsCate1();
		
		// 카테고리1 값으로 카테고리2 정보 가져오기
		List<CsCate2VO> vos3 = service2.selectCsCate2(csCate1);
		
		// csCate1과 csCate2에 따른 카테고리 10개씩 불러오기
		List<CsFaqVO> vos = service.selectCsFaqListWithCsCate1(vos3);
		
		// 저장
		req.setAttribute("vos", vos);
		req.setAttribute("vos2", vos2);
		req.setAttribute("vos3", vos3);
		req.setAttribute("csCate1", csCate1);
		
		// 포워드
		req.getRequestDispatcher("/cs/faq/list.jsp").forward(req, resp);
	}
}
