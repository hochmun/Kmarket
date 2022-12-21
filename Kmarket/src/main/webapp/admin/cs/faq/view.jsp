<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../_header.jsp"/>
    <section id="admin-product-list">
                <nav>
                    <h3>자주묻는질문 보기</h3>
                    <p>
                        HOME > 고객센터 > <strong>자주묻는질문</strong>
                    </p>
                </nav>
 	<!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                   
                    <table>
                        <tr>
                            <td><strong>유형</strong></td>
                            <td>
                                회원 - 가입
                            </td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td>
                               개인회원과 법인회원에 차이가 있나요?
                            </td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td>
                               개인회원은 본인인증, 법인회원은 사업자등록번호를 기준으로 사업자 인증 후 가입 가능<br/>
                               합니다.<br/>
                               개인회원에서 법인회원(사업자 회원)으로 전환은 불가하므로 법인회원(사업자 회원)전환<br/>
                               은 신규 가입으로 진행을 해야 합니다.
                            </td>
                        </tr>
                    </table>
                    <div class="btn3ro">
                        <a href="#" class="w-btn w-btn-indigo">삭제</a>
                        <a href="./modify.do" class="w-btn w-btn-green">수정</a>
                        <a href="./list.do" class="w-btn w-btn-indigo">목록</a>
                    </div>

                   
                </section>         

                
                <p class="ico info">
                    <strong>Tip!</strong>
                    전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
                </p>
       
            </section>
    </div>
</section>
<jsp:include page="../../_footer.jsp"/>