<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<section id="cs">
    <div class="notice">
        <nav>
            <div>
                <p>홈<span>></span>공지사항</p>
            </div>
        </nav>
        <section class="view">
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
                    <h1>${ vo.noticeTitle }</h1>
                </nav>

                <div class="content">
                    <p>
                    	${vo.noticeContent}
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
                <a href="/Kmarket/cs/notice/list.do?c=${param.c}" class="btnList">목록보기</a>
            </article>
        </section>
    </div>
</section>
<jsp:include page="../_footer.jsp"/>      
