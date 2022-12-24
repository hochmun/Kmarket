package kr.co.Kmarket.controller.admin.cs.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kr.co.Kmarket.service.cs.CsNoticeService;
import kr.co.Kmarket.vo.cs.CsNoticeVO;

@WebServlet("/admin/cs/notice/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CsNoticeService service = CsNoticeService.instance;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 들어오는 값
		String p = req.getParameter("p"); // 현재 페이지
		String t = req.getParameter("t"); // 검색 타입
		
		if(t == null) t = ""; // t값이 없을 경우
		
		// p값이 있을 경우
		int currentPage = service.NoticeCurrentPage(p);
		
		// 총 게시물 번호
		int total = service.selectCountNoticeWithCate(t);
		
		// 마지막 페이지 번호
		int lastPageNum = service.NoticelastPageNum(total);
		
		// limit 시작값 계산
		int limitStart = (currentPage - 1) * 10;
		
		// 페이지 그룹 계산
		int pageGroupCurrent = (int)Math.ceil(currentPage/10.0);
		int pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
		int pageGroupEnd = pageGroupCurrent * 10;
		if (pageGroupEnd > lastPageNum) pageGroupEnd = lastPageNum;
		
		// 페이지 시작 번호 계산
		int pageStartNum = total - limitStart;
		
		// 페이지 불러오기
		List<CsNoticeVO> vos = service.selectNoticeListWithCate(limitStart, t);
		
		// 전송
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("pageGroupCurrent", pageGroupCurrent);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("vos", vos);
		
		req.getRequestDispatcher("/admin/cs/notice/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");;
		
		// 들어오는 값
		String p = req.getParameter("p"); // 현재 페이지
		String t = req.getParameter("t"); // 검색 타입
		
		if(t == null) t = ""; // t값이 없을 경우
		
		logger.debug("t : "+t);
		
		// p값이 있을 경우
		int currentPage = service.NoticeCurrentPage(p);
		
		// 총 게시물 번호
		int total = service.selectCountNoticeWithCate(t);
		
		// 마지막 페이지 번호
		int lastPageNum = service.NoticelastPageNum(total);
		
		// limit 시작값 계산
		int limitStart = (currentPage - 1) * 10;
		
		// 페이지 그룹 계산
		int pageGroupCurrent = (int)Math.ceil(currentPage/10.0);
		int pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
		int pageGroupEnd = pageGroupCurrent * 10;
		if (pageGroupEnd > lastPageNum) pageGroupEnd = lastPageNum;
		
		// 페이지 시작 번호 계산
		int pageStartNum = total - limitStart;
		
		// 페이지 불러오기
		List<CsNoticeVO> vos = service.selectNoticeListWithCate(limitStart, t);
		
		// 전송
		JsonObject json = new JsonObject();
		json.addProperty("lastPageNum", lastPageNum);
		json.addProperty("currentPage", currentPage);
		json.addProperty("pageGroupCurrent", pageGroupCurrent);
		json.addProperty("pageGroupStart", pageGroupStart);
		json.addProperty("pageGroupEnd", pageGroupEnd);
		json.addProperty("pageStartNum", pageStartNum);
		
		String jsonStr = json.toString();
		String vosStr = jsonStr.substring(0, jsonStr.length()-1) 
				+",\"vos\":"+ (new Gson().toJson(vos))+"}";
		
		PrintWriter out = resp.getWriter();
		out.write(vosStr);
	}
}
