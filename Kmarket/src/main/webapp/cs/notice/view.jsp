<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
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
                    <li class="${param.cv eq '' ? 'on' : 'off'}"><a href="./view.do">전체</a></li>
                    <li class="${param.cv eq '10' ? 'on' : 'off'}"><a href="./view.do?c=10">고객서비스</a></li>
                    <li class="${param.cv eq '11' ? 'on' : 'off'}"><a href="./view.do?c=11">안전거래</a></li>
                    <li class="${param.cv eq '12' ? 'on' : 'off'}"><a href="./view.do?c=12">위해상품</a></li>
                    <li class="${param.cv eq '13' ? 'on' : 'off'}"><a href="./view.do?c=13">이벤트당첨</a></li>
                </ul>
            </aside>
            <article>
                <nav>
                    <h2 class="title">${cv.noticeTitle}</h2>
                    <span class="date">2022.11.20</span>
                </nav>

                <div class="content">
                    <p>
                        ${vos.noticeContent}
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
                <a href="/Kmarket/cs/notice/list.do" class="btnList">목록보기</a>
            </article>
        </section>
    </div>
</section>
<jsp:include page="./_footer.jsp"/>      
