<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/cs/js/cs.js"></script>
<jsp:include page="../_header.jsp"/>

<section id="cs">
    <div class="notice">
        <nav>
            <div>
                <p>홈<span>></span>공지사항</p>
            </div>
        </nav>
        <section class="list">
            <aside>
                <h2>공지사항</h2>
                <ul>
                    <li class="${param.c eq '' ? 'on' : 'off'}"><a href="./list.do">전체</a></li>
                    <li class="${param.c eq '10' ? 'on' : 'off'}"><a href="./list.do?c=10">고객서비스</a></li>
                    <li class="${param.c eq '11' ? 'on' : 'off'}"><a href="./list.do?c=11">안전거래</a></li>
                    <li class="${param.c eq '12' ? 'on' : 'off'}"><a href="./list.do?c=12">위해상품</a></li>
                    <li class="${param.c eq '13' ? 'on' : 'off'}"><a href="./list.do?c=13">이벤트당첨</a></li>
                </ul>
            </aside>
            <article>
                <nav>
            		   <c:if test="${ param.c eq null || param.c eq ''}"><h1>전체</h1></c:if>
            		   <c:if test="${ param.c eq '10'}"><h1>고객서비스</h1></c:if>
                       <c:if test="${ param.c eq '11'}"><h1>안전거래</h1></c:if>
                       <c:if test="${ param.c eq '12'}"><h1>위해상품</h1></c:if>
                       <c:if test="${ param.c eq '13'}"><h1>이벤트상품</h1></c:if>
                </nav>

                <table>
                   <c:forEach var="vo" items="${vos}">
                    <tr>
                        <td><a href="/Kmarket/cs/notice/view.do?c=${ vo.noticeCate }&no=${vo.noticeNo}">[${vo.noticeCate}] ${vo.noticeTitle}</a></td>
                        <td>${vo.noticeRdate}</td>
                    </tr>
                </c:forEach>
                </table>

               <div class="page">
                	<c:if test="${pageGroupStart gt 1}">
		                <a href="/Kmarket/cs/notice/list.do?c=${param.c}&pg=${pageGroupStart - 1}" class="prev"><&nbsp;이전</a>
		            </c:if>
		
		            <c:forEach var="pg" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
		                <a href="/Kmarket/cs/notice/list.do?c=${param.c}&pg=${pg}" class="${currentPage eq pg ? 'on' : 'off'}" class="num">${pg}</a>
		            </c:forEach>
		            <c:if test="${pageGroupEnd lt lastPageNum}">
		                <a href="/Kmarket/cs/notice/list.do?c=${param.c}&pg=${pageGroupEnd + 1}" class="next">다음&nbsp;></a>
	            	</c:if>
                </div>

            </article>
        </section>
    </div>

</section>
<jsp:include page="../_footer.jsp"/>