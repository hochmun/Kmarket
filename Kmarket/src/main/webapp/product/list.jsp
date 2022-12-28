<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
    <section class="list">
        <!-- 제목, 페이지 네비게이션 -->
        <nav>
            <h1>상품목록</h1>
            <p>HOME > <span>${cvo.c1Name}</span> > <strong>${cvo.c2Name}</strong></p>
        </nav>

        <!-- 정렬 메뉴 -->
        <ul class="sort" id="items">
            <li><a href="/Kmarket/product/list.do?cate1=${cvo.cate1}&cate2=${cvo.cate2}&pg=${pg}&sort=sold" class="${sort eq 'sold' ? 'on' : 'off'}">판매많은순</a></li>
            <li><a href="/Kmarket/product/list.do?cate1=${cvo.cate1}&cate2=${cvo.cate2}&pg=${pg}&sort=low" class="${sort eq 'low' ? 'on' : 'off'}">낮은가격순</a></li>
            <li><a href="/Kmarket/product/list.do?cate1=${cvo.cate1}&cate2=${cvo.cate2}&pg=${pg}&sort=high" class="${sort eq 'high' ? 'on' : 'off'}">높은가격순</a></li>
            <li><a href="/Kmarket/product/list.do?cate1=${cvo.cate1}&cate2=${cvo.cate2}&pg=${pg}&sort=hstar" class="${sort eq 'hstar' ? 'on' : 'off'}">평점높은순</a></li>
            <li><a href="/Kmarket/product/list.do?cate1=${cvo.cate1}&cate2=${cvo.cate2}&pg=${pg}&sort=review" class="${sort eq 'review' ? 'on' : 'off'}">후기많은순</a></li>
            <li><a href="/Kmarket/product/list.do?cate1=${cvo.cate1}&cate2=${cvo.cate2}&pg=${pg}&sort=latest" class="${sort eq 'latest' ? 'on' : 'off'}">최근등록순</a></li>
        </ul>
        <!-- 상품목록 -->      
        <table border="0" class="productList">
        <c:forEach var="product" items="${pvos}">
         <tr>
             <td><a href="/Kmarket/product/view.do?prodNo=${product.prodNo}" class="thumb"><img src="/thumb/${ product.prodCate1 }/${ product.prodCate2 }/${ product.thumb1 }" alt="상품이미지"></a></td>
             <td>
                 <a href="/Kmarket/product/view.do?prodNo=${product.prodNo}"><h3 class="name">${product.prodName}</h3></a>
                 <a href="/Kmarket/product/view.do?prodNo=${product.prodNo}" class="desc">${product.descript}</a>
             </td>
             <td>
                 <ul>
                 <c:choose>
                 <c:when test="${product.discount gt 0}">
                 		<li><ins class="dis-price"><fmt:formatNumber value="${ product.price * (100-product.discount) * 0.01}" pattern="#,###"/></ins></li>
                         <li><del class="org-price"><fmt:formatNumber value="${ product.price }" pattern="#,###"/></del>
                         <span class="discount">${product.discount}%</span>
                     	</li>
                    </c:when>
                    <c:otherwise>
                    	<li>
                         <del class="dis-price"><fmt:formatNumber value="${ product.price }" pattern="#,###"/></del>
                     </li>
                    </c:otherwise>
                    </c:choose>
                    <c:choose>
                    <c:when test="${product.delivery eq 0}">
                     <li><span class="free-delivery">무료배송</span></li>
                     </c:when>
                     <c:otherwise>
                     <li><span>배송비 <fmt:formatNumber value="${product.delivery}" pattern="#,###"/></span></li>
                     </c:otherwise>
                     </c:choose>
                 </ul>
             </td>
             <td>
                 <h4 class="seller"><i class="fas fa-home"></i>&nbsp;${product.seller}</h4>
                 <h5 class="badge power">판매자등급</h5>
                 <c:choose>
                 <c:when test="${product.score eq 1}">
                 <h6 class="rating star1">상품평</h6>
                 </c:when>
                 <c:when test="${product.score eq 2}">
                 <h6 class="rating star2">상품평</h6>
                 </c:when>
                 <c:when test="${product.score eq 3}">
                 <h6 class="rating star3">상품평</h6>
                 </c:when>
                 <c:when test="${product.score eq 4}">
                 <h6 class="rating star4">상품평</h6>
                 </c:when>
                 <c:when test="${product.score eq 5}">
                 <h6 class="rating star5">상품평</h6>
                 </c:when>
                 <c:when test="${product.score eq 6}">
                 <h6 class="rating star6">상품평</h6>
                 </c:when>
                 <c:when test="${product.score eq 7}">
                 <h6 class="rating star7">상품평</h6>
                 </c:when>
                 <c:when test="${product.score eq 8}">
                 <h6 class="rating star8">상품평</h6>
                 </c:when>
                 <c:when test="${product.score eq 9}">
                 <h6 class="rating star9">상품평</h6>
                 </c:when>
                 <c:otherwise>
                 <h6 class="rating star10">상품평</h6>
                 </c:otherwise>
                 </c:choose>
             </td>
         </tr>
         </c:forEach>
        </table>

        <!-- 상품목록 페이지번호 -->
        <div class="paging">
        <c:if test="${pageGroupStart gt 1}">
            <span class="prev">
                <a href="/Kmarket/product/list.do?cate1=${cvo.cate1}&cate2=${cvo.cate2}&pg=${pageGroupStart - 1}"><&nbsp;이전</a>
            </span>
            </c:if>

            <c:forEach var="pg" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
            <span class="num">
                <a href="/Kmarket/product/list.do?cate1=${cvo.cate1}&cate2=${cvo.cate2}&pg=${pg}&sort=${sort}" class="${currentPage eq pg ? 'on' : 'off'}">${pg}</a>
            </span>
            </c:forEach>
            <c:if test="${pageGroupEnd lt lastPageNum}">
            <span class="next">
                <a href="/Kmarket/product/list.do?cate1=${cvo.cate1}&cate2=${cvo.cate2}&pg=${pageGroupEnd + 1}">다음&nbsp;></a>
            </span>
            </c:if>
        </div>

    </section>
</main>

<jsp:include page="./_footer.jsp"/>
