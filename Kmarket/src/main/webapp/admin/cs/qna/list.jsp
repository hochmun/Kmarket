<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../_header.jsp"/>
    <section id="admin-product-list">
    
    <script type="text/javascript">
		$(document).ready(function() {
			$("#cbx_chkAll").click(function() {
				if($("#cbx_chkAll").is(":checked")) $("input[name=chk]").prop("checked", true);
				else $("input[name=chk]").prop("checked", false);
			});
			
			$("input[name=chk]").click(function() {
				var total = $("input[name=chk]").length;
				var checked = $("input[name=chk]:checked").length;
				
				if(total != checked) $("#cbx_chkAll").prop("checked", false);
				else $("#cbx_chkAll").prop("checked", true); 
			});
		});
	</script>
                <nav>
                    <h3>문의하기 목록</h3>
                    <p>
                        HOME > 고객센터 > <strong>문의하기</strong>
                    </p>
                </nav>
                <!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                    <div>
                        <select name="search" id="selectBox">
                            <option value="0" >1차 선택</option>
                            <option value="10">회원</option>
                            <option value="11">쿠폰/이벤트</option>
                            <option value="12">주문/결제</option>                                    
                            <option value="13">배송</option>                                    
                            <option value="14">취소/반품/교환</option>                                    
                            <option value="15">판매자</option>                                    
                            <option value="16">안전거래</option>                                    
                        </select>
                        
                    </div>
                    <div>
                        <select name="search" id="selectBox2" class="cate2">
                            <option value="search1">2차 선택</option>
                            <option value="search1">상품코드</option>
                            <option value="search1">제조사</option>
                            <option value="search1">판매자</option>                                    
                        </select>
                    </div>
                    <table>
                        <tr>
                            <th><input type="checkbox" id="cbx_chkAll"/></th>
                            <th>번호</th>
                            <th>1차유형</th>
                            <th>2차유형</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>상태</th>
                        </tr>
                        <c:forEach var="QnaArt" items="${QnaArts}">
                        <tr>
                            <td><input type="checkbox" name="chk"/></td>
                            <td>${QnaArt.qnaNo}</td>
                            <td>${vos.cate1Name}</td>
                            <td>${QnaArt.cate2Name}</td>
                            <td>${QnaArt.qnaTitle}</td>
                            <td>${QnaArt.uid}</td>
                            <td>${QnaArt.qnaRdate}</td>
                        <c:choose>
                        <c:when test="${QnaArt.qnaAdminContent eq null}">
                            <td>
                                <a href="#">검토중</a>
                            </td>
                        </c:when>
                        <c:otherwise>
                        	<td>
                                <a href="#">검토완료</a>
                            </td>
                        </c:otherwise>
                        </c:choose>
                        </tr>
                        </c:forEach>
                        <c:if test="${total eq 0}">
                        	<tr>
                        		<td colspan="4" align="center">등록된 문의글이 없습니다.</td>
                        	</tr>
                        </c:if>
                    </table>

                    
                     <a href="./list.do" class="w-btn w-btn-indigo">선택삭제</a>


                    <div class="paging">
                        <span class="prev">
                            <a href="#"><&nbsp;이전</a>
                        </span>
                        <span class="num">
                            <a href="#" class="w-btn-outline w-btn-blue-outline">1</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">2</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">3</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">4</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">5</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">6</a>
                            <a href="#" class="w-btn-outline w-btn-blue-outline">7</a>
                        </span>
                        <span class="next">
                            <a href="#">다음&nbsp;></a>
                        </span>
                        </div>

                </section>              
    </div>
</section>
<jsp:include page="../../_footer.jsp"/>