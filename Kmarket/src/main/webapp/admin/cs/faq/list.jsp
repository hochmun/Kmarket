<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
    <section id="admin-product-list">
                <nav>
                    <h3>자주묻는질문 작성</h3>
                    <p>
                        HOME > 고객센터 > <strong>자주묻는질문</strong>
                    </p>
                </nav>
 	<!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                   
                    <table>
                        <tr>
                            <td>유형</td>
                            <td>
                                <select name="type">
                                    <option value="0">1차 선택</option>
                                    <option value="">가입</option>
                                    <option value="">탈퇴</option>
                                    <option value="">회원정보</option>
                                    <option value="">로그인</option>
                                </select>
                                <select name="type">
                                    <option value="0">2차 선택</option>
                                    <option value="">가입</option>
                                    <option value="">탈퇴</option>
                                    <option value="">회원정보</option>
                                    <option value="">로그인</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td>
                                <input type="text" name="title" placeholder="제목을 입력하세요.">
                            </td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td>
                                <textarea name="content" placeholder="내용을 입력하세요."></textarea>
                            </td>
                        </tr>
                    </table>
                    <div>
                        <a href="./list.html" class="btnList">취소하기</a>
                        <input type="submit" class="btnSubmit" value="등록하기">
                    </div>

                   
                </section>         

                
                <p class="ico info">
                    <strong>Tip!</strong>
                    전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
                </p>
       
            </section>
    </div>
</section>
<jsp:include page="./_footer.jsp"/>