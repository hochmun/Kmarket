<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script src="${pageContext.request.contextPath}/cs/js/cs.js"></script>
<script>
	const sessUserUid = "${ sessUser.uid }"; // 유저 uid 정보 입력
</script>
<section id="cs">
	<div class="qna">
        <nav>
            <div>
                <p>홈<span>></span>문의하기</p>
            </div>
        </nav>
        <section class="list">
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
                    <h1>${vos.cate1Name}</h1>
                    <br>
                    <h2>관련 문의 내용입니다.</h2>
                </nav>
                <table>
                <c:forEach var="QnaArt" items="${QnaArts}">
                    <tr>
                        <td><a href="/Kmarket/cs/qna/view.do?cate1=${cate1}&no=${QnaArt.qnaNo}">[${QnaArt.cate2Name}] ${QnaArt.qnaTitle}</a></td>
                        <c:choose>
                        	<c:when test="${QnaArt.qnaAdminContent eq null}">
                        		<td style="color: #707070;">검토중</td>
                        	</c:when>
                        	<c:otherwise>
                        		<td style="color: #007bff;">검토완료</td>
                        	</c:otherwise>
                        </c:choose>
                        <td>${(QnaArt.uid).substring(0,4)}***</td>
                        <td>${QnaArt.qnaRdate}</td>
                    </tr>
                </c:forEach>
                <c:if test="${total eq 0}">
                	<tr>
                		<td colspan="4" align="center">등록된 문의글이 없습니다.</td>
                	</tr>
                </c:if>
                </table>

                <div class="page">
	                <c:if test="${pageGroupStart gt 1}">
			                <a href="/Kmarket/cs/qna/list.do?cate1=${cate1}&pg=${pageGroupStart - 1}" class="prev"><&nbsp;이전</a>
			            </c:if>
			
			            <c:forEach var="pg" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
			                <a href="/Kmarket/cs/qna/list.do?cate1=${cate1}&pg=${pg}" class="${currentPage eq pg ? 'on' : 'off'}" class="num">${pg}</a>
			            </c:forEach>
			            <c:if test="${pageGroupEnd lt lastPageNum}">
			                <a href="/Kmarket/cs/qna/list.do?cate1=${cate1}&pg=${pageGroupEnd + 1}" class="next">다음&nbsp;></a>
		            </c:if>
                </div>
                <c:choose>
                	<c:when test="${ sessUser eq null }">
                		<a></a>
					</c:when>
					<c:when test="${ sessUser.uid ne null && total eq 0}">
	                	<a href="/Kmarket/cs/qna/write.do?cate1=${cate1}" class="btnWriteEmp">문의하기</a>
					</c:when>
					<c:otherwise>
						<a href="/Kmarket/cs/qna/write.do?cate1=${cate1}" class="btnWrite">문의하기</a>
					</c:otherwise>
				</c:choose>
            </article>
        </section>
    </div>
</section>
<jsp:include page="../_footer.jsp"/>