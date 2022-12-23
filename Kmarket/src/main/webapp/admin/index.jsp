<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./_header.jsp"/>
        <section id="admin-index">
            <nav>
                <h3>관리자 메인</h3>
                <p>
                    HOME > <strong>메인</strong>
                </p>
            </nav>

            <h4>쇼핑몰 운영현황</h4>
            <article>
                <table>
                    <tr>
                        <td>
                            <strong>주문건수(건)</strong>
                            <span><fmt:formatNumber value="${ vo3.countOrdNo }" pattern="#,###"/></span>
                        </td>
                        <td>
                            <strong>주문금액(원)</strong>
                            <span><fmt:formatNumber value="${ vo3.sumOrdTotPrice }" pattern="#,###"/></span>
                        </td>
                        <td>
                            <strong>회원가입(명)</strong>
                            <span><fmt:formatNumber value="${ vo3.countMember }" pattern="#,###"/></span>
                        </td>
                        <td>
                            <strong>쇼핑몰 방문(명)</strong>
                            <span>1014</span>
                        </td>
                        <td>
                            <strong>신규게시물(건)</strong>
                            <span><fmt:formatNumber value="${ vo3.countProductRdateMonth }" pattern="#,###"/></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>
                                <span>PC</span>
                                <span>60</span>
                            </p>
                            <p>
                                <span>Mobile</span>
                                <span>71</span>
                            </p>
                        </td>
                        <td>
                            <p>
                                <span>PC</span>
                                <span>60</span>
                            </p>
                            <p>
                                <span>Mobile</span>
                                <span>71</span>
                            </p>
                        </td>
                        <td>
                            <p>
                                <span>PC</span>
                                <span>60</span>
                            </p>
                            <p>
                                <span>Mobile</span>
                                <span>71</span>
                            </p>
                        </td>
                        <td>
                            <p>
                                <span>PC</span>
                                <span>60</span>
                            </p>
                            <p>
                                <span>Mobile</span>
                                <span>71</span>
                            </p>
                        </td>
                        <td>
                            <p>
                                <span>PC</span>
                                <span>60</span>
                            </p>
                            <p>
                                <span>Mobile</span>
                                <span>71</span>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>
                                <span>어제</span>
                                <span><fmt:formatNumber value="${ vo3.countOrdNoDay }" pattern="#,###"/></span>
                            </p>
                            <p>
                                <span>주간</span>
                                <span><fmt:formatNumber value="${ vo3.countOrdNoWeek }" pattern="#,###"/></span>
                            </p>
                            <p>
                                <span>월간</span>
                                <span><fmt:formatNumber value="${ vo3.countOrdNoMonth }" pattern="#,###"/></span>
                            </p>
                        </td>
                        <td>
                            <p>
                                <span>어제</span>
                                <span><fmt:formatNumber value="${ vo3.sumOrdTotPriceDay }" pattern="#,###"/></span>
                            </p>
                            <p>
                                <span>주간</span>
                                <span><fmt:formatNumber value="${ vo3.sumOrdTotPriceWeek }" pattern="#,###"/></span>
                            </p>
                            <p>
                                <span>월간</span>
                                <span><fmt:formatNumber value="${ vo3.sumOrdTotPriceMonth }" pattern="#,###"/></span>
                            </p>
                        </td>
                        <td>
                            <p>
                                <span>어제</span>
                                <span><fmt:formatNumber value="${ vo3.countMemberDay }" pattern="#,###"/></span>
                            </p>
                            <p>
                                <span>주간</span>
                                <span><fmt:formatNumber value="${ vo3.countMemberWeek }" pattern="#,###"/></span>
                            </p>
                            <p>
                                <span>월간</span>
                                <span><fmt:formatNumber value="${ vo3.countMemberMonth }" pattern="#,###"/></span>
                            </p>
                        </td>
                        <td>
                            <p>
                                <span>어제</span>
                                <span>4</span>
                            </p>
                            <p>
                                <span>주간</span>
                                <span>10</span>
                            </p>
                            <p>
                                <span>월간</span>
                                <span>30</span>
                            </p>
                        </td>
                        <td>
                            <p>
                                <span>어제</span>
                                <span><fmt:formatNumber value="${ vo3.countProductRdateDay }" pattern="#,###"/></span>
                            </p>
                            <p>
                                <span>주간</span>
                                <span><fmt:formatNumber value="${ vo3.countProductRdateWeek }" pattern="#,###"/></span>
                            </p>
                            <p>
                                <span>월간</span>
                                <span><fmt:formatNumber value="${ vo3.countProductRdateMonth }" pattern="#,###"/></span>
                            </p>
                        </td>
                    </tr>
                </table>
            </article>

            <h4>주문 업무현황</h4>
            <article>
                <table>
                    <tr>
                        <td>
                            <strong>입금대기(건)</strong>
                            <span>100</span>
                        </td>
                        <td>
                            <strong>배송준비(건)</strong>
                            <span>100</span>
                        </td>
                        <td>
                            <strong>취소요청(건)</strong>
                            <span>100</span>
                        </td>
                        <td>
                            <strong>교환요청(건)</strong>
                            <span>100</span>
                        </td>
                        <td>
                            <strong>반품요청(건)</strong>
                            <span>100</span>
                        </td>
                    </tr>
                </table>
            </article>

            <div>
                <div>
                    <h4>공지사항</h4>
                    <article>
                    	
                    	<c:forEach var="vo1" items="${ vos1 }">
                    		<p>
	                            <span>${ vo1.noticeTitle }</span>
	                            <span>${ vo1.noticeRdate }</span>
	                        </p>
                    	</c:forEach>
                    	
                    </article>
                </div>
            
            <div>
                <h4>고객문의</h4>
                <article>
                	
                	<c:forEach var="vo2" items="${ vos2 }">
                   		<p>
                            <span>${ vo2.qnaTitle }</span>
                            <span>${ vo2.qnaRdate }</span>
                        </p>
                   	</c:forEach>
                
                </article>
            </div>
        </div>
    </section>
</main>
<jsp:include page="./_footer.jsp"/>      