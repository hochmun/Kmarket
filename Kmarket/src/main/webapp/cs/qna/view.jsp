<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<section id="cs">
    <div class="qna">
        <nav>
            <div>
                <p>홈<span>></span>문의하기</p>
            </div>
        </nav>
        <section class="view">
            <aside>
                <h2>문의하기</h2>
                <ul>
                    <li class="${cate1 eq '10' ? 'on' : 'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=10">회원</a></li>
                    <li class="${cate1 eq '11' ? 'on' : 'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=11">쿠폰/이벤트</a></li>
                    <li class="${cate1 eq '12' ? 'on' : 'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=12">주문/결제</a></li>
                    <li class="${cate1 eq '13' ? 'on' : 'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=13">배송</a></li>
                    <li class="${cate1 eq '14' ? 'on' : 'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=14">취소/반품/교환</a></li>
                    <li class="${cate1 eq '15' ? 'on' : 'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=15">여행/숙박/항공</a></li>
                    <li class="${cate1 eq '16' ? 'on' : 'off'}"><a href="/Kmarket/cs/qna/list.do?cate1=16">안전거래</a></li>
                </ul>
            </aside>
            <article>
                <nav>
                    <h2 class="title">[${article.cate2Name}] ${article.qnaTitle}</h2>
                    <p>
                        <span>${(article.uid).substring(0,4)}***</span>
                        <span>${article.qnaRdate}</span>
                    </p>
                </nav>

                <div class="content">
                    <p>
                        ${article.qnaContent}
                    </p>
                </div>
                  	<br/>
                  	<br/>
                  	<br/>
              	<c:choose>
           		<c:when test="${article.qnaAdminContent ne null}">
               	<h2 class="answerTitle">[답변] ${article.qnaTitle}</h2>
                	<br/>
                	<div class="qnaAnswer">
                	<p>
                	${article.qnaAdminContent}
                	<br/>
                	<br/>
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
               </c:when>
               <c:otherwise></c:otherwise>
               </c:choose>
                <a href="/Kmarket/cs/qna/list.do?cate1=${cate1}" class="btnList">목록보기</a>
            </article>
        </section>
    </div>
</section>
<jsp:include page="../_footer.jsp"/>