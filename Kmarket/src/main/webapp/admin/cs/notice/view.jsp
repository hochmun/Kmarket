<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../_header.jsp"/>
    <section id="admin-product-list">
                <nav>
                    <h3>공지사항 보기</h3>
                    <p>
                        HOME > 고객센터 > <strong>공지사항</strong>
                    </p>
                </nav>
 	<!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                   
                    <table>
                        <tr>
                            <td><strong>유형</strong></td>
                            <td>
                                고객서비스
                            </td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td>
                               [안내] 해외결제 사칭 문자 주의
                            </td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td>
                               <p>안녕하세요. K마켓입니다.<p/><br/>
                               
                               <p>K마켓 해외직구를 사칭하는 피싱 문자가 최근 다시 신고되고 있어 주의 안내드립니다.<p/><br/>
                               
                               아래와 같이 K마켓 해외직구 승인결제 피싱 문자 또는 발신번호 006,002 등으로<br/>
                               시작하는 피싱 문자를 수신하신 고객님께서는 통화 또는 문자 내 기재된 번호/링크 등을<br/>
                               클릭하지 않도록 주의하여 주시기 바랍니다.     
                            </td>
                        </tr>
                    </table>
                    <div>
                        <a href="#" class="btnList">삭제</a>
                        <a href="/Kmarket/admin/cs/notice/modify.do" class="btnList">수정</a>
                        <a href="/Kmarket/admin/cs/notice/list.do" class="btnSubmit" class="btnSubmit">목록</a>
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