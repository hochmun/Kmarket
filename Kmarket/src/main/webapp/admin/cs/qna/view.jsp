<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../_header.jsp"/>
    <section id="admin-product-list">
                <nav>
                    <h3>문의하기 보기</h3>
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
                                ${vos.cate1Name} - ${vos.cate2Name}
                            </td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td>
                               ${vos.qnaTitle}
                            </td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td>
                               ${vos.qnaContent}
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