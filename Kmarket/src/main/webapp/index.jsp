<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
<main>
    <!-- 카테고리/베스트 상품 영역 -->
    <aside>
        <!-- 카테고리 -->
        <ul class="category">
            <li>
                <i class="fa fa-bars" aria-hidden="true"></i>
                카테고리
            </li>
            
            <c:forEach var="cate1" items="${ vos1 }">
            	<li>
	                <a href="${pageContext.request.contextPath}/product/list.do?cate1=+${ cate1.cate1 }">
	                	<c:if test="${ cate1.cate1 eq 10 }"><i class="fas fa-shopping-bag"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 11 }"><i class="fas fa-tshirt"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 12 }"><i class="fas fa-baby-carriage"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 13 }"><i class="fas fa-utensils"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 14 }"><i class="fas fa-home"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 15 }"><i class="fas fa-tv"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 16 }"><i class="fas fa-running"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 17 }"><i class="fas fa-car"></i></c:if>
	                	<c:if test="${ cate1.cate1 eq 18 }"><i class="fas fa-book"></i></c:if>
	                    ${ cate1.c1Name }
	                    <i class="fas fa-angle-right"></i>
	                </a>
	                <ol>
	                	<c:forEach var="cate2" items="${ vos2 }">
	                		<c:if test="${ cate2.cate1 eq cate1.cate1 }">
	                			<li><a href="${pageContext.request.contextPath}/product/list.do?cate1=${ cate1.cate1 }&cate2=${ cate2.cate2 }">${ cate2.c2Name }</a></li>
	                		</c:if>
	                	</c:forEach>
	                </ol>
	            </li>
            </c:forEach>
            
        </ul>
        <!-- 베스트상품 배너 -->
        <article class="best">
            <h1><i class="fas fa-crown"></i>베스트상품</h1>
            <ol>
            
            	<c:forEach var="vo3" items="${ vos3 }">
            		<li>
	                    <a href="${pageContext.request.contextPath}/product/view.do?prodNo=${ vo3.prodNo }">
	                        <div class="thumb">
	                            <i>1</i>
	                            <img src="/thumb/${ vo3.prodCate1 }/${ vo3.prodCate2 }/${ vo3.thumb2 }" alt="item1">
	                        </div>
	                        <h2>${ vo3.prodName }</h2>
	                        
	                        <c:choose>
	                        	<c:when test="${ vo3.discount gt 0 }">
	                        		<div class="org_price">
			                            <del><fmt:formatNumber value="${ vo3.price }" pattern="#,###"/></del>
			                            <span>${ vo3.discount }%</span>
			                        </div>
			                        <div class="dis_price">
			                            <ins><fmt:formatNumber value="${ vo3.price * ( 1 - ( vo3.discount div 100 ) ) }" pattern="#,###"/></ins>
			                        </div>
	                        	</c:when>
	                        	<c:otherwise>
	                        		<div class="dis_price">
			                            <ins><fmt:formatNumber value="${ vo3.price }" pattern="#,###"/></ins>
			                        </div>
	                        	</c:otherwise>
	                        </c:choose>
	                        
	                    </a>
	                </li>
            	</c:forEach>
                
            </ol>
        </article>
    </aside>
    <section>
        <!-- 슬라이더 영역 -->
        <section class="slider">
            <ul>
                <li>
                    <a href="#">
                        <img src="/thumb/event/event1.jpg" alt="item1">
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="/thumb/event/event2.jpg" alt="item2">
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="/thumb/event/event3.jpg" alt="item3">
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="/thumb/event/event4.jpg" alt="item4">
                    </a>
                </li>
            </ul>
        </section>
        <!-- 히트상품 영역 -->
        <a name="hit"></a>
        <section class="hit">
            <h3><span>히트상품</span></h3>
            
            <c:forEach var="vo4" items="${ vos4 }">
            	<article>
	                <a href="${pageContext.request.contextPath}/product/view.do?prodNo=${ vo4.prodNo }">
	                    <div class="thumb">
	                        <img src="/thumb/${ vo4.prodCate1 }/${ vo4.prodCate2 }/${ vo4.thumb2 }" alt="t1">
	                    </div>
	                    <h2>${ vo4.prodName }</h2>
	                    <p>${ vo4.descript }</p>
	                    
	                    <c:choose>
                        	<c:when test="${ vo4.discount gt 0 }">
                        		<div class="org_price">
		                            <del><fmt:formatNumber value="${ vo4.price }" pattern="#,###"/></del>
		                            <span>${ vo4.discount }%</span>
		                        </div>
		                        <div class="dis_price">
		                            <ins><fmt:formatNumber value="${ vo4.price * ( 1 - ( vo4.discount div 100 ) ) }" pattern="#,###"/></ins>
		                            <c:choose>
		                            	<c:when test="${ vo4.delivery gt 0 }">
		                            		<span>배송비 <fmt:formatNumber value="${ vo4.delivery }" pattern="#,###"/></span>
		                            	</c:when>
		                            	<c:otherwise>
		                            		<span class="free">무료배송</span>
		                            	</c:otherwise>
		                            </c:choose>
		                        </div>
                        	</c:when>
                        	<c:otherwise>
                        		<div class="dis_price">
		                            <ins><fmt:formatNumber value="${ vo4.price }" pattern="#,###"/></ins>
		                            <c:choose>
		                            	<c:when test="${ vo4.delivery gt 0 }">
		                            		<span>배송비 <fmt:formatNumber value="${ vo4.delivery }" pattern="#,###"/></span>
		                            	</c:when>
		                            	<c:otherwise>
		                            		<span class="free">무료배송</span>
		                            	</c:otherwise>
		                            </c:choose>
		                        </div>
                        	</c:otherwise>
                        </c:choose>
	                    
	                    
	                </a>
	            </article>
            </c:forEach>
            
        </section>
        
        <!-- 추천상품 영역 -->
        <a name="recommend"></a>
        <section class="recommend">
            <h3><span>추천상품</span></h3>
            
            <c:forEach var="vo5" items="${ vos5 }">
            	<article>
	                <a href="${pageContext.request.contextPath}/product/view.do?prodNo=${ vo5.prodNo }">
	                    <div class="thumb">
	                        <img src="/thumb/${ vo5.prodCate1 }/${ vo5.prodCate2 }/${ vo5.thumb2 }" alt="t1">
	                    </div>
	                    <h2>${ vo5.prodName }</h2>
	                    <p>${ vo5.descript }</p>
	                    
	                    <c:choose>
                        	<c:when test="${ vo5.discount gt 0 }">
                        		<div class="org_price">
		                            <del><fmt:formatNumber value="${ vo5.price }" pattern="#,###"/></del>
		                            <span>${ vo5.discount }%</span>
		                        </div>
		                        <div class="dis_price">
		                            <ins><fmt:formatNumber value="${ vo5.price * ( 1 - ( vo5.discount div 100 ) ) }" pattern="#,###"/></ins>
		                            <c:choose>
		                            	<c:when test="${ vo5.delivery gt 0 }">
		                            		<span>배송비 <fmt:formatNumber value="${ vo5.delivery }" pattern="#,###"/></span>
		                            	</c:when>
		                            	<c:otherwise>
		                            		<span class="free">무료배송</span>
		                            	</c:otherwise>
		                            </c:choose>
		                        </div>
                        	</c:when>
                        	<c:otherwise>
                        		<div class="dis_price">
		                            <ins><fmt:formatNumber value="${ vo5.price }" pattern="#,###"/></ins>
		                            <c:choose>
		                            	<c:when test="${ vo5.delivery gt 0 }">
		                            		<span>배송비 <fmt:formatNumber value="${ vo5.delivery }" pattern="#,###"/></span>
		                            	</c:when>
		                            	<c:otherwise>
		                            		<span class="free">무료배송</span>
		                            	</c:otherwise>
		                            </c:choose>
		                        </div>
                        	</c:otherwise>
                        </c:choose>
	                    
	                    
	                </a>
	            </article>
            </c:forEach>
            
        </section>
        
        <!-- 최신상품 영역 -->
        <a name="new"></a>
        <section class="new">
            <h3><span>최신상품</span></h3>
            
            <c:forEach var="vo6" items="${ vos6 }">
            	<article>
	                <a href="${pageContext.request.contextPath}/product/view.do?prodNo=${ vo6.prodNo }">
	                    <div class="thumb">
	                        <img src="/thumb/${ vo6.prodCate1 }/${ vo6.prodCate2 }/${ vo6.thumb2 }" alt="t1">
	                    </div>
	                    <h2>${ vo6.prodName }</h2>
	                    <p>${ vo6.descript }</p>
	                    
	                    <c:choose>
                        	<c:when test="${ vo6.discount gt 0 }">
                        		<div class="org_price">
		                            <del><fmt:formatNumber value="${ vo6.price }" pattern="#,###"/></del>
		                            <span>${ vo6.discount }%</span>
		                        </div>
		                        <div class="dis_price">
		                            <ins><fmt:formatNumber value="${ vo6.price * ( 1 - ( vo6.discount div 100 ) ) }" pattern="#,###"/></ins>
		                            <c:choose>
		                            	<c:when test="${ vo6.delivery gt 0 }">
		                            		<span>배송비 <fmt:formatNumber value="${ vo6.delivery }" pattern="#,###"/></span>
		                            	</c:when>
		                            	<c:otherwise>
		                            		<span class="free">무료배송</span>
		                            	</c:otherwise>
		                            </c:choose>
		                        </div>
                        	</c:when>
                        	<c:otherwise>
                        		<div class="dis_price">
		                            <ins><fmt:formatNumber value="${ vo6.price }" pattern="#,###"/></ins>
		                            <c:choose>
		                            	<c:when test="${ vo6.delivery gt 0 }">
		                            		<span>배송비 <fmt:formatNumber value="${ vo6.delivery }" pattern="#,###"/></span>
		                            	</c:when>
		                            	<c:otherwise>
		                            		<span class="free">무료배송</span>
		                            	</c:otherwise>
		                            </c:choose>
		                        </div>
                        	</c:otherwise>
                        </c:choose>
	                    
	                </a>
	            </article>
            </c:forEach>
            
        </section>
        
        
        <!-- 할인상품 영역 -->
        <a name="discount"></a>
        <section class="discount">
            <h3><span>할인상품</span></h3>
            
            <c:forEach var="vo7" items="${ vos7 }">
            	<article>
	                <a href="${pageContext.request.contextPath}/product/view.do?prodNo=${ vo7.prodNo }">
	                    <div class="thumb">
	                        <img src="/thumb/${ vo7.prodCate1 }/${ vo7.prodCate2 }/${ vo7.thumb2 }" alt="t1">
	                    </div>
	                    <h2>${ vo7.prodName }</h2>
	                    <p>${ vo7.descript }</p>
	                    
	                    <c:choose>
                        	<c:when test="${ vo7.discount gt 0 }">
                        		<div class="org_price">
		                            <del><fmt:formatNumber value="${ vo7.price }" pattern="#,###"/></del>
		                            <span>${ vo7.discount }%</span>
		                        </div>
		                        <div class="dis_price">
		                            <ins><fmt:formatNumber value="${ vo7.price * ( 1 - ( vo7.discount div 100 ) ) }" pattern="#,###"/></ins>
		                            <c:choose>
		                            	<c:when test="${ vo7.delivery gt 0 }">
		                            		<span>배송비 <fmt:formatNumber value="${ vo7.delivery }" pattern="#,###"/></span>
		                            	</c:when>
		                            	<c:otherwise>
		                            		<span class="free">무료배송</span>
		                            	</c:otherwise>
		                            </c:choose>
		                        </div>
                        	</c:when>
                        	<c:otherwise>
                        		<div class="dis_price">
		                            <ins><fmt:formatNumber value="${ vo7.price }" pattern="#,###"/></ins>
		                            <c:choose>
		                            	<c:when test="${ vo7.delivery gt 0 }">
		                            		<span>배송비 <fmt:formatNumber value="${ vo7.delivery }" pattern="#,###"/></span>
		                            	</c:when>
		                            	<c:otherwise>
		                            		<span class="free">무료배송</span>
		                            	</c:otherwise>
		                            </c:choose>
		                        </div>
                        	</c:otherwise>
                        </c:choose>
	                    
	                </a>
	            </article>
            </c:forEach>
            
        </section>
        
        
    </section>
    
</main>
<jsp:include page="./_footer.jsp"/>      