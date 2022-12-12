package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.member.MemberService;

@WebServlet("/member/checkUid.do")
public class CheckUidController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonObject json = new JsonObject();
		json.addProperty("result", service.checkUid(req.getParameter("km_uid")));
		resp.getWriter().print(json.toString());
	}

}
