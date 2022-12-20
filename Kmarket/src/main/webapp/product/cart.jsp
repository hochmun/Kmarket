<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="./_header.jsp"/>
<script src="./js/cart.js"></script>
<!-- 장바구니 페이지 시작 -->
<section class="cart">
  
	<!-- 제목, 페이지 네비게이션 -->
	<nav>
		<h1>장바구니</h1>
		<p>
			HOME > <span>패션·의류·뷰티</span> > <strong>장바구니</strong>
		</p>
	</nav>

	<form action="#">
	
	<!-- 장바구니 목록 -->
	<table>
		<tr>
			<th><input type="checkbox" name="all" onclick="allchecked(this)"></th>
			<th>상품명</th>
			<th>총수량</th>
			<th>판매가</th>
			<th>할인</th>
			<th>포인트</th>
			<th>배송비</th>
			<th>소계</th>
		</tr>
		
		<!-- 장바구니의 상품 갯수가 1보다 작을 때 실행 -->
		<c:if test="${ fn:length(vos) lt 1 }">
			<tr class="empty">
				<td colspan="7">장바구니에 상품이 없습니다.</td>
			</tr>
		</c:if>
		
		<!-- 장바구니의 상품 출력 -->
		<c:forEach var="vo" items="${ vos }">
		
			<tr>
				<td>
					<input type="checkbox" name="productCheck" onclick="productCheck2(this)" value="${ vo.cartNo }">
				</td>
				<td>
					<article>
						<a href="${pageContext.request.contextPath}/product/view.do?prodNo=${ vo.prodNo }"><img src="/thumb/${ vo.prodCate1 }/${ vo.prodCate2 }/${ vo.thumb1 }" alt="상품 이미지"></a>
						<div>
							<h2><a href="${pageContext.request.contextPath}/product/view.do?prodNo=${ vo.prodNo }">${ vo.prodName }</a></h2>
							<p>${ vo.descript }</p>
						</div>
					</article>
				</td>
				<td>${ vo.count }</td>
				<td><fmt:formatNumber value="${ vo.price }" pattern="#,###"/></td>
				<td>${ vo.discount }%</td>
				<td><fmt:formatNumber value="${ vo.point }" pattern="#,###"/></td>
				
				<c:choose>
					<c:when test="${ vo.delivery gt 0 }">
						<td><fmt:formatNumber value="${ vo.delivery }" pattern="#,###"/></td>
					</c:when>
					<c:otherwise>
						<td>무료배송</td>
					</c:otherwise>
				</c:choose>
				
			</tr>
		
		</c:forEach>
		
	</table>
	<input type="button" name="del" value="선택삭제" onclick="deleteChecked()">

	<!-- 장바구니 전체합계 -->
	<div class="total">
		<h2>전체합계</h2>
		<table>
			<tr>
				<td>상품수</td>
				<td>0</td>
			</tr>
			<tr>
				<td>상품금액</td>
				<td>0</td>
			</tr>
			<tr>
				<td>할인금액</td>
				<td>0</td>
			</tr>
			<tr>
				<td>배송비</td>
				<td>0</td>
			</tr>              
			<tr>
				<td>포인트</td>
				<td>0</td>
			</tr>
			<tr>
				<td>전체주문금액</td>
				<td>0</td>
			</tr>
		</table>
     	<input type="submit" name="" value="주문하기" onclick="ProductOrder()">    
	</div>

</form>

</section>
<!-- 장바구니 페이지 끝 -->
</main>
<jsp:include page="./_footer.jsp"/>      