package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.Kmarket.service.product.ProductService;
import kr.co.Kmarket.vo.Cate1VO;
import kr.co.Kmarket.vo.ProductVO;

@WebServlet("/product/list.do")
public class ProductListController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonObject json = new JsonObject();
		String sort = req.getParameter("sort");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		String pg = req.getParameter("pg");
		if(pg == null || pg.trim().equals("")){
		pg = "1";
		}
		
		logger.debug("pg : "+pg);

		if(cate1 == null) cate1 = "";
		if(cate2 == null) cate2 = "";
		
		/*페이지 처리*/
		int limitStart = service.boardPaging(req, pg, cate1, cate2, sort);
		
		/*prodCate 가져오기*/
		Cate1VO cvo = service.selectProdCates(cate1, cate2);
		/*product list 가져오기*/
		List<ProductVO> pvos = service.selectProducts(cate1, cate2, limitStart, sort);
		
		req.setAttribute("cvo", cvo); // selectProducts
		req.setAttribute("pg", pg); 
		req.setAttribute("sort", sort); 
		req.setAttribute("pvos", pvos);
		req.setAttribute("pvos", service.selectProducts(cate1, cate2, limitStart, sort));
		
		req.setAttribute("limitStart", limitStart);

		req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
		}
	}
