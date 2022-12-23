<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../_header.jsp"/>
<script src="../js/productList.js"></script>
    <section id="admin-product-list">
    <style>
    input {
    	width: 200px;
		padding: 6px;
		border: 1px solid #959595;
		font-size: 13px;
		background-color: #fefefe;
		color: #333;
		vertical-align: middle;
		box-sizing: border-box;
    }
    </style>
        <nav>
            <h3>상품목록</h3>
            <p>
                HOME > 상품관리 > <strong>상품목록</strong>
            </p>
        </nav>
        <!-- 상품목록 컨텐츠 시작 -->
        <section>
            <div>
                <select name="searchType">
                    <option value="prodName">상품명</option>
                    <option value="prodNo">상품코드</option>
                    <option value="company">제조사</option>
                    <option value="seller">판매자</option>
                </select>
                <input type="text" name="search">
                <input type="button" name="btnSearch" value="검색" style="
	                float: right;
					text-indent: 0;
					margin-top: 0;
					margin-left: 5px;
				">
            </div>
            <table>
                <tr>
                    <th><input type="checkbox" name="all" id="cbx_chkAll"></th>
                    <th style="width: auto;">이미지</th>
                    <th style="width: 8%;">상품코드</th>
                    <th style="width: auto;">상품명</th>
                    <th style="width: 5%;">판매가격</th>
                    <th style="width: 5%;">할인율</th>
                    <th style="width: 6%;">포인트</th>
                    <th style="width: 5%;">재고</th>
                    <th style="width: 10%;">판매자</th>
                    <th style="width: 5%;">조회</th>
                    <th style="width: 5%;">관리</th>
                </tr>
                
                <c:forEach var="vo" items="${ vos }">
                	<tr>
	                    <td><input type="checkbox" name="상품코드"></td>
	                    <td><img src="/thumb/${ vo.prodCate1 }/${ vo.prodCate2 }/${ vo.thumb1 }" class="thumb"></td>
	                    <td>${ vo.prodNo }</td>
	                    <td>${ vo.prodName }</td>
	                    <td><fmt:formatNumber value="${ vo.price }" pattern="#,###"/></td>
	                    
	                    <c:choose>
	                    	<c:when test="${ vo.discount gt 0 }">
	                    		<td>${ vo.discount }%</td>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<td>-</td>
	                    	</c:otherwise>
	                    </c:choose>
	                    
	                    <td><fmt:formatNumber value="${ vo.point }" pattern="#,###"/></td>
	                    <td><fmt:formatNumber value="${ vo.stock }" pattern="#,###"/></td>
	                    <td>${ vo.seller }</td>
	                    <td><fmt:formatNumber value="${ vo.hit }" pattern="#,###"/></td>
	                    <td>
	                        <a href="#" class="deleteProduct">[삭제]</a>
	                        <a href="#">[수정]</a>
	                    </td>
	                </tr>
                </c:forEach>

            </table>

            <input type="button" value="선택삭제" id="deleteAll" style="text-indent: 0;">

            <div class="paging">
            	
            	<c:if test="${ pageGroupStart gt 1 }">
            		<span class="prev">
	                    <a href="${pageContext.request.contextPath}/admin/product/list.do?pg=${ pageGroupStart - 1 }&s=${ param.s }&st=${ param.st }">&nbsp;이전</a>
	                </span>
            	</c:if>
            	
            	<span class="num">
	            	<c:forEach var="i" begin="${ pageGroupStart }" end="${ pageGroupEnd }" step="1">
	            		<a href="${pageContext.request.contextPath}/admin/product/list.do?pg=${ i }&s=${ param.s }&st=${ param.st }" class="${ currentPage eq i ? 'on' : '' }">${ i }</a>
	            	</c:forEach>
                </span>
                
                <c:if test="${ pageGroupEnd lt lastPageNum }">
                	<span class="next">
	                    <a href="${pageContext.request.contextPath}/admin/product/list.do?pg=${ pageGroupEnd+1 }&s=${ param.s }&st=${ param.st }">다음&nbsp;</a>
	                </span>
                </c:if>
                
            </div>
        </section>

        <p class="ico info">
            <strong>Tip!</strong>
            전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
        </p>

        <!-- 상품목록 컨텐츠 끝 -->
    </section>
</main>
<jsp:include page="../_footer.jsp"/>