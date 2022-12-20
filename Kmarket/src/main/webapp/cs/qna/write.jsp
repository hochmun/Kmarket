<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
        <nav>
            <div>
                <p>홈<span>></span>문의하기</p>
            </div>
        </nav>
        <section class="write">
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
                <form action="/Kmarket/cs/qna/write.do" method="post">
                    <table>
                        <tr>
                            <td>문의유형</td>
                            <td>
                                <select name="type">
                                    <option value="0">선택</option>
                                    <option value="">가입</option>
                                    <option value="">탈퇴</option>
                                    <option value="">회원정보</option>
                                    <option value="">로그인</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>문의제목</td>
                            <td>
                                <input type="text" name="title" placeholder="제목을 입력하세요.">
                            </td>
                        </tr>
                        <tr>
                            <td>문의내용</td>
                            <td>
                                <textarea name="content" placeholder="내용을 입력하세요."></textarea>
                            </td>
                        </tr>
                    </table>
                    <div>
                        <a href="/Kmarket/cs/qna/list.do" class="btnList">취소하기</a>
                        <input type="submit" class="btnSubmit" value="등록하기">
                    </div>
                </form>
            </article>
        </section>
    </div>
</section>
<jsp:include page="./_footer.jsp"/>