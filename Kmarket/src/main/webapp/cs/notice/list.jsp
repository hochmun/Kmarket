<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/cs/js/cs.js"></script>
<jsp:include page="./_header.jsp"/>

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
                    <c:forEach var="vo" items="${vos}" >
                   	 	<h1>${vo.noticeCate}</h1>
                		   <c:if test="${ vo.noticeCate eq '10'}"><td>고객서비스</td></c:if>
                           <c:if test="${ vo.noticeCate eq '11'}"><td>안전거래</td></c:if>
                           <c:if test="${ vo.noticeCate eq '12'}"><td>위해상품</td></c:if>
                           <c:if test="${ vo.noticeCate eq '13'}"><td>이벤트상품</td></c:if>
                	</c:forEach>
                </nav>

                <table>
                   <c:forEach var="vo" items="${vos}">
                    <tr>
                        <td><a href="/Kmarket/cs/notice/view.do?cate1=&no=${vo.noticeNo}">[${vo.noticeCate}] ${vo.noticeTitle}</a></td>
                        <td>${vo.noticeRdate}</td>
                    </tr>
                </c:forEach>
                </table>

               <div class="page">
                <c:if test="${pageGroupStart gt 1}">
		                <a href="/Kmarket/cs/notice/list.do?cate1=${cate1}&pg=${pageGroupStart - 1}" class="prev"><&nbsp;이전</a>
		            </c:if>
		
		            <c:forEach var="pg" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
		                <a href="/Kmarket/cs/notice/list.do?cate1=${cate1}&pg=${pg}" class="${currentPage eq pg ? 'on' : 'off'}" class="num">${pg}</a>
		            </c:forEach>
		            <c:if test="${pageGroupEnd lt lastPageNum}">
		                <a href="/Kmarket/cs/list.do?cate1=${cate1}&pg=${pageGroupEnd + 1}" class="next">다음&nbsp;></a>
	            </c:if>
                </div>

            </article>
        </section>
    </div>

</section>
<jsp:include page="./_footer.jsp"/>