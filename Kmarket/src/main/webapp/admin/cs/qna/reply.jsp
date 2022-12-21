<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../_header.jsp"/>
    <section id="admin-product-list">
                <nav>
                    <h3>문의하기 답변</h3>
                    <p>
                        HOME > 고객센터 > <strong>문의하기</strong>
                    </p>
                </nav>
 	<!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                   
                    <table>
                        <tr>
                            <td><strong>유형</strong></td>
                            <td>
                                회원-가입
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
                               개인회원하고 법인회원하고 차이를 알고 싶어요.그리고 법인회원으로 가입하면<br/>
                               혜택이 있나요?<br/>
                               마지막으로 법인가입 하려면 어떻게 해야 하죠?<br/>
                               알려주세요.     
                            </td>
                        </tr>
                        <tr>
                        	<td>답변</td>
                        	<td>
                                <textarea name="content" placeholder=""></textarea>
                            </td>
                        </tr>
                    </table>
                    <div class="btn3ro">
                        <a href="#" class="w-btn w-btn-indigo">삭제</a>
                        <a href="/Kmarket/admin/cs/notice/modify.do" class="w-btn w-btn-gra3 w-btn-gra-anim">답변등록</a>
                        <a href="/Kmarket/admin/cs/notice/list.do" class="w-btn w-btn-indigo">목록</a>
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