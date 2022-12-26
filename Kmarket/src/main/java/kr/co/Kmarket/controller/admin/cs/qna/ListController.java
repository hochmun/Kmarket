package kr.co.Kmarket.controller.admin.cs.qna;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
		String pg = req.getParameter("pg");
		if(pg == null || pg.trim().equals("")){
		pg = "1";
		}
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		if(cate1 == null) cate1 = "";
		if(cate2 == null) cate2 = "";
		
		int limitStart = service.boardPaging(req, pg, cate1, cate2);
		List<CsQnaVO> vos = service.selectCsQnaList(limitStart, cate1, cate2);
		List<CsCate1VO> vos2 = service2.selectCsCate1();
		
		req.setAttribute("vos", vos);
		req.setAttribute("vos2", vos2);
		req.setAttribute("pg", pg); 
		req.setAttribute("limitStart", limitStart);
		req.getRequestDispatcher("/admin/cs/qna/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		String pg = req.getParameter("pg");
		if(pg == null || pg.trim().equals("")){
		pg = "1";
		}
		JsonObject json = new JsonObject();
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		if(cate1 == null) cate1 = "";
		if(cate2 == null) cate2 = "";
		
		int limitStart = service.boardPaging2(req, pg, json, cate1, cate2);
		List<CsQnaVO> vos = service.selectCsQnaListCate(cate1, cate2, limitStart);
		
		String jsonStr = json.toString();
		String vosStr = jsonStr.substring(0, jsonStr.length()-1) 
				+",\"vos\":"+ (new Gson().toJson(vos))+"}";
		
		PrintWriter out = resp.getWriter();
		out.write(vosStr);
	}
}
