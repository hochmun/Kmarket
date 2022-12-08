<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
            <article>
                <form action="#">
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