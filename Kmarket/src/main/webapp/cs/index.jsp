<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="./_header.jsp"/>
<section id="cs">
    <div class="main">
        <h1 class="title">
            <strong>케이마켓</strong>이 도와드릴게요!
        </h1>
        <section class="notice">
            <h1>공지사항<a href="/Kmarket/cs/notice/list.do">전체보기</a></h1>
            <ul>
            	
            	<c:forEach var="vo1" items="${ vos1 }">
            		<li>
	                    <a href="/Kmarket/cs/notice/view.do?c=${ vo1.noticeCate }&no=${ vo1.noticeNo }" class="title">${ vo1.noticeTitle }</a>
	                    <span class="date">${ fn:substring(vo1.noticeRdate, 0, 8) }</span>
	                </li>
            	</c:forEach>
            	
            </ul>
        </section>

        <section class="faq">
            <h1>자주 묻는 질문</h1>
            <ol>
                <li>
                    <a href="/Kmarket/cs/faq/list.do?csCate1=10"><span>회원</span></a>
                </li>
                <li>
                    <a href="/Kmarket/cs/faq/list.do?csCate1=11"><span>쿠폰/혜택/이벤트</span></a>
                </li>
                <li>
                    <a href="/Kmarket/cs/faq/list.do?csCate1=12"><span>주문/결제</span></a>
                </li>
                <li>
                    <a href="/Kmarket/cs/faq/list.do?csCate1=13"><span>배송</span></a>
                </li>
                <li>
                    <a href="/Kmarket/cs/faq/list.do?csCate1=14"><span>취소/반품/교환</span></a>
                </li>
                <li>
                    <a href="/Kmarket/cs/faq/list.do?csCate1=15"><span>여행/숙박/항공</span></a>
                </li>
                <li>
                    <a href="/Kmarket/cs/faq/list.do?csCate1=16"><span>안전거래</span></a>
                </li>
            </ol>
        </section>

        <section class="qna">
            <h1>문의하기<a href="/Kmarket/cs/qna/list.do?cate1=10">상세보기</a></h1>
            <ul>
            	
	            <c:forEach var="vo2" items="${ vos2 }">
            		<li>
	                    <a href="/Kmarket/cs/qna/view.do?no=${ vo2.qnaNo }&cate1=${ vo2.qnaCate1 }" class="title">${ vo2.qnaTitle }</a>
	                    <p>
	                        <span class="uid">${ fn:substring(vo2.uid, 0, 4) }<c:forEach begin="5" end="${ fn:length(vo2.uid) }" step="1">*</c:forEach></span>
	                        <span class="date">${ fn:substring(vo2.qnaRdate, 0, 8) }</span>
	                    </p>
	                </li>
            	</c:forEach>
            	
            </ul>
        </section>

        <section class="tel">
            <h1>
                1:1 상담이 필요하신가요?
            </h1>

            <article>
                <div>
                    <h3>고객센터 이용안내</h3>
                    <p>
                        <span>일반회원/비회원</span><br/>
                        <strong>1566-0001</strong><span>(평일 09:00 ~ 18:00)</span>
                    </p>
                    <p>
                        <span>스마일클럽 전용</span><br/>
                        <strong>1566-0002</strong><span>(365일 09:00 ~ 18:00)</span>
                    </p>
                </div>
            </article>

            <article>
                <div>
                    <h3>판매상담 이용안내</h3>
                    <p>
                        <span>판매고객</span>
                        <strong>1566-5700</strong><span>(평일 09:00 ~ 18:00)</span>
                    </p>
                    <p>
                        <a href="/Kmarket/member/join.do">판매자 가입 및 서류 접수 안내 〉</a>
                    </p>
                </div>
            </article>
        </section>
    </div>
</section>
<jsp:include page="./_footer.jsp"/>