<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script src="../js/faqList.js"></script>
<section id="cs">
          <div class="faq">
              <nav>
                  <div>
                      <p>홈<span>></span>자주묻는 질문</p>
                  </div>
              </nav>
              <section class="list">
                  <aside>
                      <h2>자주묻는 질문</h2>
                      <ul>
                      	
                      	<c:forEach var="vo2" items="${ vos2 }">
                      		<li class="${ vo2.cate1 eq csCate1 ? 'on' : 'off' }"><a href="${pageContext.request.contextPath}/cs/faq/list.do?csCate1=${ vo2.cate1 }">${ vo2.cate1Name }</a></li>
                      	</c:forEach>
                      	
                      </ul>
                  </aside>
            <article>
                <nav>
                	
                	<c:forEach var="vo2" items="${ vos2 }" >
                		<c:if test="${ vo2.cate1 eq csCate1 }">
                			<h1>${ vo2.cate1Name }</h1>
                		</c:if>
                	</c:forEach>
                	
                    <h2>가장 자주 묻는 질문입니다.</h2>
                    
                </nav>
				
				<c:forEach var="vo3" items="${ vos3 }" >
				
					<div>
	                    <h3>${ vo3.cate2Name }</h3>
	                    <ul>
	                    	
	                    	<c:set var="count" value="0" ></c:set>
	                    	
	                    	<c:forEach var="vo" items="${ vos }">
	                    		
	                    		<c:if test="${ vo.faqCate2 eq vo3.cate2 }">
	                    		
	                    			<c:set var="count" value="${ count + 1 }" ></c:set>
	                    			<li class="${ count gt 3 ? 'hide' : '' }"><a href="/Kmarket/cs/faq/view.do?faqNo=${ vo.faqNo }&csCate1=${ vo.faqCate1 }"><span>Q.</span>${ vo.faqTitle }</a></li>
	                    			
	                    		</c:if>
	                    		
	                    	</c:forEach>
	                    	
	                    	<c:if test="${ count eq 0 }"><li><a>게시물이 없습니다.</a></li></c:if>
	                    	
	                        <li class="more" onclick="moreView(this)"><a href="#">더보기</a></li>
	                        
	                    </ul>
	                </div>
				
				</c:forEach>
				
            </article>
        </section>
    </div>
</section>
<jsp:include page="../_footer.jsp"/>