<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
		<section id="cs">
            <div class="faq">
                <nav>
                    <div>
                        <p>홈<span>></span>자주묻는 질문</p>
                    </div>
                </nav>
                <section class="view">
                    <aside>
                        <h2>자주묻는 질문</h2>
                        <ul>
                            <c:forEach var="vo2" items="${ vos2 }">
	                      		<li class="${ vo2.cate1 eq param.csCate1 ? 'on' : 'off' }"><a href="${pageContext.request.contextPath}/cs/faq/list.do?csCate1=${ vo2.cate1 }">${ vo2.cate1Name }</a></li>
	                      	</c:forEach>
                        </ul>
                    </aside>
                    
		            <article>
		                <nav>
		                    <h2 class="title"><span>Q.</span>${ vo.faqTitle }</h2>
		                </nav>
		
		                <div class="content">
		                    <p>
		                        ${ vo.faqContent }
		                    </p>
		                    <p>
		                        ※ 피싱 관련 피해신고<br /><br />
		                        ▶ 경찰청 사이버수사국 (국번없이)182 :
		                        http://cyberbureau.police.go.kr<br />
		                        ▶ KISA 인터넷침해대응센터 (국번없이)118 :
		                        http://www.krcert.or.kr<br />
		                        감사합니다.<br /> 
		                    </p>
		                </div>
		                <a href="/Kmarket/cs/faq/list.do?csCate1=${ param.csCate1 }" class="btnList">목록보기</a>
		            </article>
		        </section>
		    </div>
		</section>
<jsp:include page="../_footer.jsp"/>